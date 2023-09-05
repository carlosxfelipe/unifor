import ListaDinamica.ListaEncadeadaSimples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    ListaEncadeadaSimples<Integer> lista = new ListaEncadeadaSimples<>();

    lista.inserirInicio(1);
    lista.inserirFim(2);
    lista.inserirFim(3);
    lista.inserirPosicao(1, 4);
    lista.removerInicio();
    lista.removerFim();
    lista.removerPosicao(1);

    // System.out.println("Elemento na posição 2: " + lista.retornaValor(2));

    lista.exibirLista();

    // Substituindo os métodos personalizados por métodos já existentes na linguagem Java
    List<Integer> lista2 = new ArrayList<>();

    lista2.add(1); // inserir no início
    lista2.add(2); // inserir no fim
    lista2.add(3); // inserir no fim
    lista2.add(1, 4); // inserir na posição 1
    lista2.remove(0); // remover do início
    lista2.remove(lista2.size() - 1); // remover do fim
    lista2.remove(1); // remover da posição 1

    System.out.println(Arrays.toString(lista2.toArray()));
  }
}
