package Classes;

import java.util.List;

public class Novela extends Conteudo{
    private int caps;
    private List<String> dublagens;
    private List<String> legendas;

    public Novela(String nome, String descricao, List<String> genero, int ano, String tipo, String idioma, List<String> dublagens, List<String> legendas, int caps) {
        super(nome, descricao, genero, ano, tipo, idioma, dublagens, legendas);
        this.caps = caps;
    }

    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() + "\nCapítulos: " + this.caps;
    }

    public String exibirPrevia() {
        return descricao;
    }

    @Override
    public double avaliar(Conteudo conteudo) {
        return 0;
    }

    @Override
    public String obterClassificacao(double pontuacao) {
        return "";
    }

    @Override
    public void adicionarComentario(String filme, String comentario) {
    }

    @Override
    public String[] obterComentarios(String filme) {
        return new String[0];
    }

    @Override
    public boolean removerComentario(String filme, String comentario) {
        return false;
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

