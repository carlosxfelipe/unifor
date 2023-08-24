interface Stack<T> {
    fun size(): Int
    fun isEmpty(): Boolean
    fun push(value: T)
    fun pop(): T
    fun peek(): T
    fun showElements()
}

interface Queue<T> {
    fun size(): Int
    fun isEmpty(): Boolean
    fun enqueue(value: T)
    fun dequeue(): T
    fun first(): T
    fun showElements()
}

class CustomStack<T> : Stack<T> {
    private val stack = mutableListOf<T>()

    override fun size(): Int = stack.size
    override fun isEmpty(): Boolean = stack.isEmpty()

    override fun push(value: T) {
        stack.add(value)
    }

    override fun pop(): T {
        if (isEmpty()) {
            throw IllegalStateException("A pilha está vazia")
        }
        return stack.removeAt(stack.size - 1)
    }

    override fun peek(): T {
        if (isEmpty()) {
            throw IllegalStateException("A pilha está vazia")
        }
        return stack.last()
    }

    override fun showElements() {
        println(stack.joinToString(", "))
    }
}

class CustomQueue<T> : Queue<T> {
    private val queue = mutableListOf<T>()

    override fun size(): Int = queue.size
    override fun isEmpty(): Boolean = queue.isEmpty()

    override fun enqueue(value: T) {
        queue.add(value)
    }

    override fun dequeue(): T {
        if (isEmpty()) {
            throw IllegalStateException("A fila está vazia")
        }
        return queue.removeAt(0)
    }

    override fun first(): T {
        if (isEmpty()) {
            throw IllegalStateException("A fila está vazia")
        }
        return queue.first()
    }

    override fun showElements() {
        println(queue.joinToString(", "))
    }
}

fun main() {
    val stack: Stack<Int> = CustomStack()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.push(5)
    stack.push(6)

    println("Tamanho da pilha: ${stack.size()}")
    println("Elemento do topo: ${stack.peek()}")
    stack.showElements()

    stack.pop()
    println("Tamanho da pilha após desempilhar: ${stack.size()}")
    stack.showElements()

    println("\n==== Separador entre Pilha e Fila ====\n")

    val queue: Queue<String> = CustomQueue()
    queue.enqueue("A")
    queue.enqueue("B")
    queue.enqueue("C")
    queue.enqueue("D")
    queue.enqueue("E")
    queue.enqueue("F")

    println("Tamanho da fila: ${queue.size()}")
    println("Primeiro elemento: ${queue.first()}")
    queue.showElements()

    queue.dequeue()
    println("Tamanho da fila após desenfileirar: ${queue.size()}")
    queue.showElements()
}
