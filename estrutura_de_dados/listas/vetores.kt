import java.util.*

fun main() {
  // Exemplo de lista estática (array)
  val meuArray: Array<Any> = arrayOf(10, 20, 30, 40, 50, "sessenta")
  println("Array: ${meuArray.contentToString()}")
  println("-".repeat(40)) // Linha de separação

  // Exemplo de lista imutável (listOf)
  val minhaLista: List<Any> = listOf(5, 10, 15, "vinte")
  // Tente adicionar elementos à lista - Isso resultará em um erro em tempo de compilação
  // minhaLista.add(20)
  println("Lista: ${minhaLista.toTypedArray().contentToString()}")
  // Tente remover elementos da lista - Isso resultará em um erro em tempo de compilação
  // minhaLista.removeAt(1)
  println("-".repeat(40)) // Linha de separação

  // Exemplo de lista mutável (mutableListOf)
  val minhaListaMutavel: MutableList<Int> = mutableListOf(5, 10, 15)
  
  minhaListaMutavel.add(20)
  minhaListaMutavel.add(25)
  minhaListaMutavel.add(30)
  println("minhaListaMutavel: ${minhaListaMutavel.toTypedArray().contentToString()}")
  
  minhaListaMutavel.removeAt(1)
  println("Depois de remover o elemento no índice 1: $minhaListaMutavel")
  println("-".repeat(40)) // Linha de separação

   // Exemplo de Set (Conjunto)
   val meuSet: Set<Any> = setOf(10, 20, 30, 40, 50, "sessenta")
   println("Set: ${meuSet}")
   println("-".repeat(40)) // Linha de separação

   // Exemplo de Map (Mapa)
   val meuMap: Map<String, Any> = mapOf("chave1" to 10, "chave2" to "vinte", "chave3" to 30)
   println("Map: ${meuMap}") 
   println("-".repeat(40)) // Linha de separação

   // Exemplo de HashSet
   val meuHashSet: HashSet<Any> = hashSetOf(10, 20, 30, 40, 50, "sessenta")
   println("HashSet: ${meuHashSet}")
   println("-".repeat(40)) // Linha de separação

   // Exemplo de HashMap
   val meuHashMap: HashMap<String, Any> = hashMapOf("chave1" to 10, "chave2" to "vinte", "chave3" to 30)
   println("HashMap: ${meuHashMap}")
   println("-".repeat(40)) // Linha de separação

   // Exemplo de LinkedHashSet
   val meuLinkedHashSet: LinkedHashSet<Any> = linkedSetOf(10, 20, 30, 40, 50, "sessenta")
   println("LinkedHashSet: ${meuLinkedHashSet}")
   println("-".repeat(40)) // Linha de separação

   // Exemplo de LinkedHashMap
   val meuLinkedHashMap: LinkedHashMap<String, Any> = linkedMapOf("chave1" to 10, "chave2" to "vinte", "chave3" to 30)
   println("LinkedHashMap: ${meuLinkedHashMap}")
   println("-".repeat(40)) // Linha de separação

   // Exemplo de SortedSet
   val meuSortedSet: SortedSet<Any> = sortedSetOf(50, 30, 40, 20, 10)
   println("SortedSet: ${meuSortedSet}")
   println("-".repeat(40)) // Linha de separação

   // Exemplo de SortedMap
   val meuSortedMap: SortedMap<String, Any> = sortedMapOf("chave3" to 30, "chave2" to "vinte", "chave1" to 10)
   println("SortedMap: ${meuSortedMap}")
   println("-".repeat(40)) // Linha de separação
}
