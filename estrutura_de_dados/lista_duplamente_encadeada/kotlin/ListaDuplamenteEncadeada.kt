class ListaDuplamenteEncadeada<T> {
    private var inicio: No<T>? = null
    private var fim: No<T>? = null
    var tamanho = 0

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

    fun exibirLista() {
        print("[")
        var noAux = inicio
        while (noAux != null) {
            print(noAux.valor)
            noAux = noAux.proximo
            if (noAux != null) print(", ")
        }
        println("]")
    }

    fun retornarValor(posicao: Int): T {
        return retornarNo(posicao).valor
    }

    private fun retornarNo(posicao: Int): No<T> {
        if (posicao < 0 || posicao >= tamanho) {
            throw IndexOutOfBoundsException("Posição $posicao está fora dos limites!")
        }

        val noAux: No<T>
        noAux = if (posicao < tamanho / 2) {
            var i = 0
            var temp = inicio
            while (i < posicao) {
                temp = temp?.proximo
                i++
            }
            temp!!
        } else {
            var i = tamanho - 1
            var temp = fim
            while (i > posicao) {
                temp = temp?.anterior
                i--
            }
            temp!!
        }
        return noAux
    }

    fun inserirInicio(valor: T) {
        val novoNo = No(valor)

        if (inicio == null) {
            inicio = novoNo
            fim = novoNo
        } else {
            novoNo.proximo = inicio
            inicio!!.anterior = novoNo
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
            novoNo.anterior = fim
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
            val noAux = retornarNo(posicao)
            novoNo.proximo = noAux
            novoNo.anterior = noAux.anterior
            noAux.anterior?.proximo = novoNo
            noAux.anterior = novoNo
            tamanho++
        }
    }

    fun removerInicio() {
        if (inicio == null) throw RuntimeException("Lista vazia!")

        if (tamanho == 1) {
            inicio = null
            fim = null
        } else {
            inicio = inicio?.proximo
            inicio?.anterior?.proximo = null
            inicio?.anterior = null
        }
        tamanho--
    }

    fun removerFim() {
        if (inicio == null) throw RuntimeException("Lista vazia!")

        if (tamanho == 1) {
            inicio = null
            fim = null
        } else {
            fim = fim?.anterior
            fim?.proximo?.anterior = null
            fim?.proximo = null
        }
        tamanho--
    }

    fun removerPosicao(posicao: Int) {
        if (posicao <= 0) {
            removerInicio()
        } else if (posicao >= tamanho - 1) {
            removerFim()
        } else {
            val noAux = retornarNo(posicao)
            noAux.anterior?.proximo = noAux.proximo
            noAux.proximo?.anterior = noAux.anterior
            noAux.proximo = null
            noAux.anterior = null
            tamanho--
        }
    }
}

class No<T>(var valor: T) {
    var proximo: No<T>? = null
    var anterior: No<T>? = null
}

fun main() {
  val lista = ListaDuplamenteEncadeada<Int>()
  
  lista.inserirInicio(1)
  lista.inserirFim(2)
  lista.inserirFim(3)
  lista.inserirPosicao(1, 4)
  
  println("Lista após as inserções:")
  lista.exibirLista()

  lista.removerInicio()
  lista.removerFim()
  lista.removerPosicao(1)
  
  println("\nLista após as remoções:")
  lista.exibirLista()
}

