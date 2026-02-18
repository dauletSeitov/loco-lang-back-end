package com.example.locolangbackend.project;

import analyze.ExpressionAnalyzer;
import analyze.ds.Library;
import com.example.locolangbackend.storage.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.example.locolangbackend.utils.CollectionUtils.concat;
import static com.example.locolangbackend.utils.ExceptionUtils.unchecked;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final StorageService storageService;

    private static final Map<String, String> projectNameToLocationMap = Map.of(
            "Binary search", "binary-search"
    );

    public List<Project> get(String sessionId) {
        var projects = storageService.getBySession(sessionId);
        if (projects == null) {
            var list = getDefault();
            storageService.put(sessionId, list);
            return list;
        }

        return projects;
    }


    private List<Project> getDefault() {
        Library defaultLibraries = ExpressionAnalyzer.getDefaultLibraries();
        var std = defaultLibraries.libraries().stream().map(it -> new File(it.fileName(), it.content())).toList();

        return projectNameToLocationMap.entrySet().stream()
                .map(it -> new Project(it.getKey(), concat(readAllFiles(it.getValue()), std)))
                .toList();

    }

    public List<File> readAllFiles(String projectPath) {
        var resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = unchecked(() -> resolver.getResources("classpath:examples/" + projectPath + "/*"));
        return Arrays.stream(resources)
                .map(it ->
                        unchecked(() -> new File(it.getFilename(), new String(it.getInputStream().readAllBytes()))))
                .toList();
    }
}
