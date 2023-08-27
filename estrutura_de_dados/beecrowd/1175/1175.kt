import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    // val N = IntArray(20)
    // for (i in 0 until 20) {
    //     N[i] = scanner.nextInt()
    // }

    val N = IntArray(20) { it + 1 }
    

    // for (i in 0 until 10) {
    //     val temp = N[i]
    //     N[i] = N[19 - i]
    //     N[19 - i] = temp
    // }

    N.reverse()

    for (i in 0 until 20) {
        println("N[$i] = ${N[i]}")
    }

    scanner.close()
}
