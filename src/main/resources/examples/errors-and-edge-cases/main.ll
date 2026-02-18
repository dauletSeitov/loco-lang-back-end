fun main() {
    var empty = []
    println("size empty: " + size(empty))

    var a = null
    println("null == null: " + (a == null))

    var nums = [1, 2, 3]
    println("index 0: " + nums[0])
    println("index last: " + nums[size(nums) - 1])

    var map = <>
    println("missing key: " + map["missing"])
}
