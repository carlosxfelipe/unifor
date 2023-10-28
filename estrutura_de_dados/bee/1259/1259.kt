fun main(args: Array<String>) {
  val n = readLine()!!.toInt()
  val evenNumbers = mutableListOf<Int>()
  val oddNumbers = mutableListOf<Int>()

  repeat(n) {
      val number = readLine()!!.toInt()
      if (number % 2 == 0) {
          evenNumbers.add(number)
      } else {
          oddNumbers.add(number)
      }
  }

  evenNumbers.sort()
  oddNumbers.sortDescending()

  evenNumbers.forEach { println(it) }
  oddNumbers.forEach { println(it) }
}
