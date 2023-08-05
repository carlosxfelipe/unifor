import 'dart:io';

class Questao {
  String enunciado;
  String alternativa1;
  String alternativa2;
  String alternativa3;
  String alternativa4;
  int resposta;

  Questao(
    this.enunciado,
    this.alternativa1,
    this.alternativa2,
    this.alternativa3,
    this.alternativa4,
    this.resposta,
  );

  bool isCorrect(int alternativa) {
    return alternativa == resposta;
  }

  void apresentarQuestao() {
    print(enunciado);
    print('a) $alternativa1');
    print('b) $alternativa2');
    print('c) $alternativa3');
    print('d) $alternativa4');
  }
}

class Prova {
  late List<Questao> questoes;

  Prova() {
    questoes = [
      Questao(
        "Qual é a capital do Brasil?",
        "São Paulo",
        "Rio de Janeiro",
        "Brasília",
        "Salvador",
        3,
      ),
      Questao(
        "Quanto é 2 + 2?",
        "3",
        "4",
        "5",
        "6",
        2,
      ),
    ];
  }

  void realizarProva() {
    for (var i = 0; i < questoes.length; i++) {
      questoes[i].apresentarQuestao();
      print("Digite a letra da alternativa correta para a questão ${i + 1}:");
      int respostaUsuario = receberRespostaUsuario();
      verificarResposta(questoes[i], respostaUsuario);
    }
  }
}

int receberRespostaUsuario() {
  String respostaUsuario = stdin.readLineSync() ?? '';
  respostaUsuario = respostaUsuario.toLowerCase().trim();

  if (respostaUsuario == 'a' || respostaUsuario == '1') {
    return 1;
  } else if (respostaUsuario == 'b' || respostaUsuario == '2') {
    return 2;
  } else if (respostaUsuario == 'c' || respostaUsuario == '3') {
    return 3;
  } else if (respostaUsuario == 'd' || respostaUsuario == '4') {
    return 4;
  } else {
    return -1;
  }
}

void verificarResposta(Questao questao, int respostaUsuario) {
  if (questao.isCorrect(respostaUsuario)) {
    print("Resposta correta!\n");
  } else {
    print("Resposta incorreta!\n");
  }
}

void main(List<String> args) {
  Prova prova = Prova();
  prova.realizarProva();
}
