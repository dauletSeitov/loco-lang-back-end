fun main() {
    var name = "loco"
    var version = 1
    var pi = 3.14
    var ok = true

    println("name: " + name)
    println("version: " + version)
    println("pi: " + pi)
    println("ok: " + ok)

    var sum = 10 + 5
    var diff = 10 - 5
    var prod = 10 * 5
    var div = 10 / 4
    var mod = 10 % 4

    println("sum: " + sum)
    println("diff: " + diff)
    println("prod: " + prod)
    println("div: " + div)
    println("mod: " + mod)

    if (version > 0 & ok) {
        println("version ok")
    } else {
        println("version not ok")
    }

    for (i = 0; i < 3; i = i + 1) {
        println("i: " + i)
    }
}
