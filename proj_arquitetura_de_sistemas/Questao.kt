import java.util.Scanner

class Questao(
        val enunciado: String,
        val alternativa1: String,
        val alternativa2: String,
        val alternativa3: String,
        val alternativa4: String,
        val resposta: Int
) {
    fun isCorrect(alternativa: Int): Boolean {
        return alternativa == resposta
    }

    fun apresentarQuestao() {
        println(enunciado)
        println("a) $alternativa1")
        println("b) $alternativa2")
        println("c) $alternativa3")
        println("d) $alternativa4")
    }
}

class Prova {
    val questoes: List<Questao>

    init {
        questoes =
                listOf(
                        Questao(
                                "Qual é a capital do Brasil?",
                                "São Paulo",
                                "Rio de Janeiro",
                                "Brasília",
                                "Salvador",
                                3
                        ),
                        Questao("Quanto é 2 + 2?", "3", "4", "5", "6", 2)
                )
    }

    fun realizarProva() {
        val scanner = Scanner(System.`in`)
        for ((index, questao) in questoes.withIndex()) {
            questao.apresentarQuestao()
            println("Digite a letra da alternativa correta para a questão ${index + 1}:")
            val respostaUsuario = receberRespostaUsuario(scanner)
            verificarResposta(questao, respostaUsuario)
        }
    }
}

fun receberRespostaUsuario(scanner: Scanner): Int {
    val respostaUsuario = scanner.nextLine().trim().lowercase()
    return when (respostaUsuario) {
        "a", "1" -> 1
        "b", "2" -> 2
        "c", "3" -> 3
        "d", "4" -> 4
        else -> -1
    }
}

fun verificarResposta(questao: Questao, respostaUsuario: Int) {
    if (questao.isCorrect(respostaUsuario)) {
        println("Resposta correta!\n")
    } else {
        println("Resposta incorreta!\n")
    }
}

fun main() {
    val prova = Prova()
    prova.realizarProva()
}
