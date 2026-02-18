package com.example.locolangbackend.project;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<Project> listProjects(@RequestHeader(value = "X-SESSION-ID", required = false) String sessionId) {


//        ExpressionAnalyzer.execute(null, "fun main{println(\"ok\")}", "main.ll");

        return projectService.get(sessionId);

    }


}
