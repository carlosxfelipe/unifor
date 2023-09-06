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

  fun removerInicio() {
    if (tamanho == 0) throw RuntimeException("A lista está vazia. Não é possível remover o início.")

    if (tamanho == 1) {
      inicio = null
      fim = null
    } else {
      val noAuxiliar = inicio
      inicio = noAuxiliar!!.proximo
      noAuxiliar.proximo = null
    }
    tamanho--
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

  fun removerFim() {
    if (tamanho == 0) throw RuntimeException("A lista está vazia. Não é possível remover o fim.")

    if (tamanho == 1) {
      inicio = null
      fim = null
    } else {
      val noAnterior = retornaNo(tamanho - 2)
      noAnterior.proximo = null
      fim = noAnterior
    }
    tamanho--
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

  fun removerPosicao(posicao: Int) {
    if (posicao < 0 || posicao >= tamanho)
        throw RuntimeException("A posição $posicao está fora dos limites da lista.")
    if (posicao == 0) {
      removerInicio()
    } else if (posicao == tamanho - 1) {
      removerFim()
    } else {
      val noAnterior = retornaNo(posicao - 1)
      val noRemovido = noAnterior.proximo
      noAnterior.proximo = noRemovido?.proximo
      noRemovido?.proximo = null
      tamanho--
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
  lista.removerInicio()
  lista.removerFim()
  lista.removerPosicao(1)

  // println("Elemento na posição 2: ${lista.retornaValor(2)}")

  lista.exibirLista()
}
