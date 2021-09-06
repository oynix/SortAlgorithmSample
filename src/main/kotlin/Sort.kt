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

// 冒泡排序
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
}

// 选择排序
fun select () {
    var temp = 0
    var pointer = 0
    while (pointer < arr.size - 1) {
        temp = arr[pointer]
        for (i in pointer until arr.size) {
            if (arr[i] < temp) {
                temp = temp xor arr[i]
                arr[i] = temp xor arr[i]
                temp = temp xor arr[i]
            }
        }
        arr[pointer++] = temp
    }
}

// 快速排序
fun quick(low: Int,high: Int, array: IntArray) {
    if (low >= high) return
    var left = low
    var right = high
    val temp = array[left]
    var reverse = true
    while (left < right) {
        if (reverse) {
            // 从右指针扫描
            // 当值比基准值小时，右指针的值填充到左指针，此时认为右指针为空
            if (array[right] < temp) {
                array[left] = array[right]
                reverse = !reverse // 掉头
            } else {
                right-- // 右指针左移动
            }
        } else {
            // 从左指针扫描
            // 当值比基准值大时，左指针填充到右指针，此时认为左指针为空
            if (array[left] > temp) {
                array[right] = array[left]
                reverse = !reverse // 调用
            } else {
                left++ // 左指针右移动
            }
        }
    }
    // 一趟结束后，指针相遇，把基准值放到指针所在位置
    // 此时左侧都比基准值小，右侧都比基准值大
    array[left] = temp
    // 分别递归左侧和右侧
    quick(low, left - 1, array)
    quick(left + 1, high, array)
}

// 插入排序
fun insert(array: IntArray) {
    var border = 0 // 左侧已排序部分的边界
    while (border < array.size - 1) {
        // 每次取右侧未排序部分的第一个数字，将其插入到左侧的目标位置
        for (i in border downTo 0) {
            if (array[i + 1] < array[i]) {
                // 异或操作交换值，不用额外的临时变量
                array[i] = array[i] xor array[i + 1]
                array[i + 1] = array[i] xor array[i + 1]
                array[i] = array[i] xor array[i + 1]
            } else {
                break
            }
        }
        border++
    }
}

fun main() {
    println(arr.localString())
//    bubble()
//    select()
//    quick(0, arr.size - 1, arr)
    insert(arr)
    println(arr.localString())
}