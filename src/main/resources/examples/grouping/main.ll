
fun main(){

    var numbers = ["hello", "it's", "me"]

    var counts = <>

    for (i = 0; i < size(numbers); i = i + 1) {
        var key = "" + numbers[i]
        if (counts[key] == null) {
            counts[key] = 1
        } else {
            counts[key] = counts[key] + 1
        }
    }
    println("counts: " + counts)

}




