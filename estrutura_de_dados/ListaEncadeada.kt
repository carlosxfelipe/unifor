class ListaEncadeadaSimples<T> {
  private var inicio: No<T>? = null
  private var fim: No<T>? = null
  private var tamanho: Int = 0

  constructor() {
    tamanho = 0
    inicio = null
    fim = null
  }

  constructor(valor: T) {
    val novoNo = No(valor)
    inicio = novoNo
    fim = novoNo
    tamanho = 1
  }

  fun retornaValor(posicao: Int): T {
    return retornaNo(posicao).valor
  }

  private fun retornaNo(posicao: Int): No<T> {
    if (inicio == null) {
      throw RuntimeException("Lista está vazia!")
    } else if (posicao < 0 || posicao >= tamanho) {
      throw IndexOutOfBoundsException("posição $posicao está fora dos limites da lista")
    }
    var noAuxiliar = inicio
    for (i in 0 until posicao) {
      noAuxiliar = noAuxiliar?.proximo
    }
    return noAuxiliar!!
  }

  fun inserirInicio(valor: T) {
    val novoNo = No(valor)
    if (inicio == null) {
      inicio = novoNo
      fim = novoNo
    } else {
      novoNo.proximo = inicio
      inicio = novoNo
    }
    tamanho++
  }

  fun inserirFim(valor: T) {
    val novoNo = No(valor)
    if (inicio == null) {
      inicio = novoNo
    } else {
      fim?.proximo = novoNo
    }
    fim = novoNo
    tamanho++
  }

  fun inserirPosicao(posicao: Int, valor: T) {
    if (posicao <= 0) {
      inserirInicio(valor)
    } else if (posicao >= tamanho) {
      inserirFim(valor)
    } else {
      val novoNo = No(valor)
      val noAuxiliar = retornaNo(posicao - 1)
      novoNo.proximo = noAuxiliar.proximo
      noAuxiliar.proximo = novoNo
      tamanho++
    }
  }

  fun exibirLista() {
    print("[")
    var noAuxiliar = inicio
    while (noAuxiliar != null) {
      print(noAuxiliar.valor)
      noAuxiliar = noAuxiliar.proximo
      if (noAuxiliar != null) {
        print(", ")
      }
    }
    println("]")
  }
}

class No<T>(valor: T) {
  var valor: T = valor
  var proximo: No<T>? = null
}

fun main() {
  val lista = ListaEncadeadaSimples<Int>()

  lista.inserirInicio(1)
  lista.inserirFim(2)
  lista.inserirFim(3)
  lista.inserirPosicao(1, 4)

  println("Elemento na posição 2: ${lista.retornaValor(2)}")

  lista.exibirLista()
}
