import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    // val n = scanner.nextInt()
    val n = 20

    var a = 0
    var b = 1
    var c = 0

    if (n == 0 || n == 1) return
    
    print("$a ")
    for (i in 2 until n) {
        a = b
        b = c
        c = a + b
        print("$c ")
    }

    println(c + b)

    scanner.close()
}
