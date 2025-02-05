package Classes;

import java.util.ArrayList;
import java.util.List;

public class Filme extends Conteudo {
    private int duracao;
    private List<String> dublagens;
    private List<String> legendas;

    public Filme(String nome, String descricao, List<String> genero, int ano, String tipo, String idioma, List<String> dublagens, List<String> legendas, int duracao) {
        super(nome, descricao, genero, ano, tipo, idioma, dublagens, legendas);
        this.duracao = duracao;
    }

    public void adicionarDublagem(String idioma) {
        if (!dublagens.contains(idioma)) {
            dublagens.add(idioma);
            System.out.println("Dublagem em " + idioma + " adicionada.");
        } else {
            System.out.println("Dublagem já existente.");
        }
    }

    public void adicionarLegenda(String idioma) {
        if (!legendas.contains(idioma)) {
            legendas.add(idioma);
            System.out.println("Legenda em " + idioma + " adicionada.");
        } else {
            System.out.println("Legenda já existente.");
        }
    }

    public List<String> getDublagens() {
        return dublagens;
    }

    public List<String> getLegendas() {
        return legendas;
    }

    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() + "\nDuração: " + this.duracao + " minutos"
                + "\nDublagens disponíveis: " + dublagens
                + "\nLegendas disponíveis: " + legendas;
    }

    public String exibirPrevia() {
        return descricao;
    }

    @Override
    public double avaliar(Conteudo conteudo) {
        return 0; // Implementação a ser feita conforme o comportamento desejado
    }

    @Override
    public String obterClassificacao(double pontuacao) {
        return ""; // Implementação a ser feita conforme o comportamento desejado
    }

    @Override
    public void adicionarComentario(String filme, String comentario) {
        // Implementar a lógica de adicionar comentário, se necessário
    }

    @Override
    public String[] obterComentarios(String filme) {
        return new String[0]; // Implementar a lógica de obter comentários, se necessário
    }

    @Override
    public boolean removerComentario(String filme, String comentario) {
        return false; // Implementar a lógica de remover comentário, se necessário
    }

    @Override
    public String exibirDetalhes(String nome, double nota, String genero, int ano, String tipo, String idioma) {
        return "";
    }

    @Override
    public String exibirPrevia(String descricao) {
        return "";
    }
}
