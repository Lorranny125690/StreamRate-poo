package Classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String nome;
    private String senha;
    private List<String> historico;
    private Map<String, List<String>> listas; //pra poder ter uma lista com as listas dentro

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        this.historico = new ArrayList<>(); //definindo a lista do histórico
        this.listas = new HashMap<>(); //definindo o hashmap para salvar as listas

    }

    public List<String> getHistorico() {
        return new ArrayList<>(historico);
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.isEmpty()) { //pra verificar se a senha ta vazia, se tiver nao roda
            throw new IllegalArgumentException("A senha não pode ser vazia.");
        }
        this.senha = senha;
    }


    public void adicionarAoHistorico(String pesquisa) {
        historico.add(pesquisa);
    }

    // Retorna o histórico de pesquisas do usuário
    public List<String> getHistoricoUsuario() {
        return new ArrayList<>(historico);
    }

    public void criarLista(String nomeLista) {
        if (!listas.containsKey(nomeLista)) { //verificando se o nome NÃO ta na lista
            listas.put(nomeLista, new ArrayList<>()); //adicionando no hashmap
            System.out.println("Lista '" + nomeLista + "' criada com sucesso!");
        } else {
            System.out.println("Essa lista já existe.");
        }
    }

    // Adicionar conteúdo a uma lista
    public void adicionarConteudo(String nomeLista, String conteudo) {
        if (listas.containsKey(nomeLista)) { //verificando se o nome existe na lista
            listas.get(nomeLista).add(conteudo); //adiciona na lista
            System.out.println("'" + conteudo + "' adicionado à lista '" + nomeLista + "'.");
        } else {
            System.out.println("Lista não encontrada.");
        }
    }

    // Exibir todas as listas do usuário
    public void listarListas() {
        if (listas.isEmpty()) {
            System.out.println("Nenhuma lista criada.");
        } else {
            System.out.println("Suas listas:");
            for (String nomeLista : listas.keySet()) { //um for percorrendo as chaves
                System.out.println("- " + nomeLista);
            }
        }
    }

    // Exibir conteúdos de uma lista específica
    public void exibirLista(String nomeLista) {
        if (listas.containsKey(nomeLista)) {
            List<String> conteudos = listas.get(nomeLista); //coloca o array como o nome da lista digitada
            System.out.println("Conteúdos na lista '" + nomeLista + "':");
            for (String conteudo : conteudos) { //percorre a lista de conteudos
                System.out.println("- " + conteudo);
            }
        } else {
            System.out.println("Lista não encontrada.");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHistorico(List<String> historico) {
        this.historico = historico;
    }

    public Map<String, List<String>> getListas() {
        return listas;
    }

    public void setListas(Map<String, List<String>> listas) {
        this.listas = listas;
    }
}
