package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public static void main(String[] args) {
    AgendaContatos agendaContatos = new AgendaContatos();

    agendaContatos.adicionarContato("Camila", 123456);
    agendaContatos.adicionarContato("Camilla", 5665);
    agendaContatos.adicionarContato("Camila Cavalcante", 1111111);
    agendaContatos.adicionarContato("Camila DIO", 654987);
    agendaContatos.adicionarContato("Maria Silva", 1111111);
    agendaContatos.adicionarContato("Camila", 44444);

    agendaContatos.exibirContatos();

    agendaContatos.removerContato("Maria");
    agendaContatos.exibirContatos();

    String nomePesquisa = "João";
    Integer numeroPesquisa = agendaContatos.pesquisarPorNome("João");
    System.out.println("Número de telefone de " + nomePesquisa + ": " + numeroPesquisa);

    String nomePesquisaNaoExistente = "Paula";
    Integer numeroPesquisaNaoExistente = agendaContatos.pesquisarPorNome(nomePesquisaNaoExistente);
    System.out.println("Número de telefone de " + nomePesquisaNaoExistente + ": " + numeroPesquisaNaoExistente);
}

    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome = null;
        if(agendaContatoMap.isEmpty()){
           numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

}


