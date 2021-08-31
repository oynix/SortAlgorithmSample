import java.lang.StringBuilder

// https://www.cnblogs.com/onepixel/articles/7674659.html

val arr = intArrayOf(3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48)

fun IntArray.localString(): String {
    val sb = StringBuilder("[")
    forEach {
        sb.append(it).append(",")
    }
    sb.deleteAt(sb.lastIndex)
    sb.append("]")
    return sb.toString()
}

fun bubble() {
    for (i in arr.indices) {
        for (j in 0 until (arr.size - i - 1)) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    println(arr.localString())
}

fun main() {
    bubble()
}