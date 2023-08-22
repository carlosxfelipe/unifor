fun main() {
  val listaEstatica = ListaEstatica<Int>(10)
  listaEstatica.inserirFinal(2)
  listaEstatica.exibirLista()
  listaEstatica.inserirFinal(5)
  listaEstatica.exibirLista()
  listaEstatica.inserirInicio(7)
  listaEstatica.exibirLista()
  listaEstatica.inserirPosicao(1, 10)
  listaEstatica.exibirLista()
}

class ListaEstatica<T>(tamanho: Int) : Lista<T> {

  private val lista: Array<Any?>
  private var quantidadeElementos: Int = 0

  init {
      lista = arrayOfNulls<Any?>(tamanho)
  }

  private fun verificarListaCheia() {
      if (quantidadeElementos == lista.size) {
          throw ListaCheiaException("A lista está cheia!")
      }
  }

  override fun estaCheia(): Boolean {
      return quantidadeElementos == lista.size
  }

  override fun estaVazia(): Boolean {
      return quantidadeElementos == 0
  }

  override fun exibirLista() {
      if (estaVazia()) {
          throw ListaVaziaException("A lista está vazia!")
      }
      println("[${lista.filterNotNull().joinToString(", ")}]")
  }

  override fun inserirFinal(valor: T) {
      verificarListaCheia()
      lista[quantidadeElementos] = valor
      quantidadeElementos++
  }

  override fun inserirInicio(valor: T) {
      verificarListaCheia()
      for (i in quantidadeElementos downTo 1) {
          lista[i] = lista[i - 1]
      }
      lista[0] = valor
      quantidadeElementos++
  }

  override fun inserirPosicao(posicao: Int, valor: T) {
      verificarListaCheia()

      when {
          posicao <= 0 -> inserirInicio(valor)
          posicao >= quantidadeElementos -> inserirFinal(valor)
          else -> {
              for (i in quantidadeElementos downTo posicao + 1) {
                  lista[i] = lista[i - 1]
              }
              lista[posicao] = valor
              quantidadeElementos++
          }
      }
  }

  override fun tamanho(): Int {
      return quantidadeElementos
  }
}

interface Lista<T> {
  fun tamanho(): Int
  fun estaVazia(): Boolean
  fun estaCheia(): Boolean
  fun inserirInicio(valor: T)
  fun inserirFinal(valor: T)
  fun inserirPosicao(posicao: Int, valor: T)
  fun exibirLista()
}

class ListaVaziaException(mensagem: String) : RuntimeException(mensagem)
class ListaCheiaException(mensagem: String) : RuntimeException(mensagem)
