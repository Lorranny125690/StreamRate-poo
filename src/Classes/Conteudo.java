package Classes;

import Interfaces.Exibivel;
import Interfaces.Comunicavel;
import Interfaces.Classificavel;

import java.util.ArrayList;
import java.util.List;

public abstract class Conteudo implements Exibivel, Comunicavel, Classificavel, Comparable<Conteudo> {

    protected String nome;
    protected String descricao;
    protected List<String> genero;  // Alterado para List<String> para suportar múltiplos gêneros
    protected int ano;
    protected String tipo;
    protected String idioma;
    protected List<String> idiomasDublagem;
    protected List<String> idiomasLegenda;
    protected double nota;
    private List<String> comentarios = new ArrayList<>();
    protected double somaNotas = 0;
    protected int quantAvaliacoes = 0;

    public Conteudo(String nome, String descricao, List<String> genero, int ano, String tipo, String idioma, List<String> idiomasDublagem, List<String> idiomasLegenda) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        if (genero == null || genero.isEmpty()) {
            throw new IllegalArgumentException("O gênero não pode ser vazio.");
        }
        if (ano <= 0) {
            throw new IllegalArgumentException("O ano não pode ser negativo.");
        }
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("O tipo não pode ser vazio.");
        }

        this.nome = nome;
        this.descricao = descricao;
        this.genero = genero != null ? genero : new ArrayList<>();
        this.ano = ano;
        this.tipo = tipo;
        this.idiomasDublagem = idiomasDublagem != null ? idiomasDublagem : new ArrayList<>();
        this.idiomasLegenda = idiomasLegenda != null ? idiomasLegenda : new ArrayList<>();
        this.nota = 0.0;
        this.idioma = idioma;
    }

    public void adicionarDublagem(String idioma) {
        if (idioma == null || idioma.trim().isEmpty()) {
            throw new IllegalArgumentException("O idioma da dublagem não pode ser vazio.");
        }
        if (!idiomasDublagem.contains(idioma)) {
            idiomasDublagem.add(idioma);
        }
    }

    public void adicionarLegenda(String idioma) {
        if (idioma == null || idioma.trim().isEmpty()) {
            throw new IllegalArgumentException("O idioma da legenda não pode ser vazio.");
        }
        if (!idiomasLegenda.contains(idioma)) {
            idiomasLegenda.add(idioma);
        }
    }

    public void setSomaNotas(double nota) {
        this.somaNotas += nota;
    }

    public void setQuantAvaliacoes() {
        this.quantAvaliacoes += 1;
    }

    public List<String> getIdiomasDublagem() {
        return idiomasDublagem;
    }

    public List<String> getIdiomasLegenda() {
        return idiomasLegenda;
    }

    public void setNota(double nota) {
        if (nota < 0 || nota > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 5.");
        }
        this.somaNotas += nota;
        this.quantAvaliacoes++;
        this.nota = somaNotas / quantAvaliacoes;
    }

    public void exibirComentarios() {
        if (comentarios.isEmpty()) {
            System.out.println("Nenhum comentário disponível.");
            return;
        }
        comentarios.forEach(c -> {
            System.out.println("------------------------");
            System.out.println(c);
        });
    }

    public void adicionarComentario(String comentario) {
        if (comentario == null || comentario.trim().isEmpty()) {
            throw new IllegalArgumentException("O comentário não pode ser vazio.");
        }
        comentarios.add(comentario);
        System.out.println("Comentário publicado!");
    }

    public double getNota() {
        return nota;
    }

    public String getNome() {
        return nome;
    }

    public String exibirDetalhes() {
        return String.format("Nome: %s\nDescrição: %s\nNota: %.2f\nGênero(s): %s\nAno: %d\nTipo: %s\nDublagens: %s\nLegendas: %s",
                nome, descricao, nota, genero, ano, tipo, idiomasDublagem, idiomasLegenda);
    }

    @Override
    public int compareTo(Conteudo outro) {
        return Double.compare(outro.getNota(), this.nota);
    }
}
