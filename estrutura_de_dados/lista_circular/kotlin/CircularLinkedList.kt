class Node(var data: Int) {
  var next: Node? = null
}

class CircularLinkedList {
  private var head: Node? = null
  private var tail: Node? = null

  fun addToEnd(data: Int) {
      val newNode = Node(data)
      if (head == null) {
          head = newNode
          tail = newNode
      } else {
          tail?.next = newNode
          tail = newNode
      }
      tail?.next = head // Conecta o último elemento ao primeiro para formar o loop.
  }

  fun display() {
      if (head == null) {
          println("A lista está vazia.")
          return
      }
      var current = head
      do {
          print("${current?.data} ")
          current = current?.next
      } while (current != head)
      println()
  }
}

fun main() {
  val list = CircularLinkedList()

  list.addToEnd(1)
  list.addToEnd(2)
  list.addToEnd(3)
  list.addToEnd(4)

  println("Lista circular:")
  list.display()
}
