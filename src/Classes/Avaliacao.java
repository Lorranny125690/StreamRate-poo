package Classes;

public class Avaliacao {

    public double avaliar(Conteudo conteudo, double nota) {
        if (conteudo == null) {
            throw new IllegalArgumentException("O conteúdo fornecido para avaliação não pode ser nulo.");
        }
        if (nota < 0 || nota > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 5.");
        }
        conteudo.setNota(nota);

        Double notaFinal = conteudo.getNota();
        return (notaFinal != null) ? notaFinal : 0.0;
    }

    public String obterClassificacao(double pontuacao) {
        if (pontuacao < 0 || pontuacao > 5) {
            throw new IllegalArgumentException("A pontuação deve estar entre 0 e 5.");
        }
        if (pontuacao >= 4.5) {
            return "Excelente";
        } else if (pontuacao >= 3.5) {
            return "Bom";
        } else if (pontuacao >= 2.5) {
            return "Regular";
        } else {
            return "Ruim";
        }
    }
}
