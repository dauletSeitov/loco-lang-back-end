fun main() {
    var user = <>
    user["name"] = "alex"
    user["age"] = 30
    user["address"] = <>
    user["address"]["city"] = "almaty"
    user["address"]["zip"] = "050000"

    user["tags"] = ["dev", "lang", "backend"]

    println("name: " + user.name)
    println("city: " + user.address.city)
    println("tags: " + user.tags)

    user["tags"] = user["tags"] + ["compiler"]
    println("tags updated: " + user.tags)
}
