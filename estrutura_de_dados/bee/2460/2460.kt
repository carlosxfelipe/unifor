import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val N = scanner.nextInt()
    val fila = List(N) { scanner.nextInt() }

    val M = scanner.nextInt()
    val idsToRemove = HashSet<Int>()

    repeat(M) {
        idsToRemove.add(scanner.nextInt())
    }

    scanner.close()

    val novaFila = fila.filter { it !in idsToRemove }

    println(novaFila.joinToString(" "))
}
