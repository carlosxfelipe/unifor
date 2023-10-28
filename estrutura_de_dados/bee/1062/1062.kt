import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    while (true) {
        val wagons = scanner.nextInt()
        if (wagons == 0) break

        while (true) {
            val stack = LinkedList<Int>()
            var entering = 1
            var failure = false
            var zero = false

            for (i in 0 until wagons) {
                val exiting = scanner.nextInt()
                if (exiting == 0) {
                    zero = true
                    break
                }
                while (true) {
                    if (exiting == entering) {
                        entering++
                        break
                    } else if (exiting > entering) {
                        stack.push(entering)
                        entering++
                    } else {
                        if (stack.isEmpty() || stack.peek() != exiting) {
                            failure = true
                        } else {
                            stack.pop()
                        }
                        break
                    }
                }
            }

            if (!zero) {
                if (!failure) {
                    println("Yes")
                } else {
                    println("No")
                }
            } else {
                break
            }
        }
        println()
    }
}
