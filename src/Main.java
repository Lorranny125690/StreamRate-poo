import java.util.*;
import Classes.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Usuario usuario = null;

        List<Conteudo> conteudosCadastrados = new ArrayList<>(); //todos os conteudos cadastrados
        List<Usuario> usuarios = new ArrayList<>(); //todas as contas de usuário

        while (true) { //looping geral que engloba tudo
            boolean running = true; //preparação pro looping terciário
            // Loop de login ou criação de conta
            while (usuario == null) {
                System.out.println("\n");
                System.out.println("⭐⭐ --- StreamRate --- ⭐⭐");
                System.out.println("Bem-vindo(a) ao StreamRate, sua plataforma de avaliações!!");
                System.out.println("[1] - Entrar em conta existente \n[2] - Criar conta \n[3] - Sair");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (option) {
                    case 1:
                        if (!usuarios.isEmpty()){
                            System.out.println("--- ENTRAR EM CONTA EXISTENTE ---");
                            System.out.print("Digite seu nome de usuário: ");
                            String name = scanner.nextLine();
                            System.out.print("Digite sua senha: ");
                            String password = scanner.nextLine();
                            for (Usuario usuario_ : usuarios) {
                                if (usuario_.getNome().equals(name)) { //aqui verifica se o nome digitado é igual ao que tem na lista
                                    if (usuario_.getSenha().equals(password)) { //se o nome for igual, ele verifica a senha
                                        System.out.println("Login bem-sucedido! Bem-vindo, " + usuario_.getNome()); //ai se tudo tiver certo entra
                                        usuario = usuario_; // aqui mantemos a instância original
                                    } else {
                                        System.out.println("Senha incorreta. Tente novamente.");
                                    }
                                } else {
                                    System.out.println("Usuário não encontrado. Verifique o nome e tente novamente.");
                                }
                            }
                        } else {
                            System.out.println("Não existem contas cadastradas.");
                        }

                        break;

                    case 2:
                        System.out.println("--- CRIAR CONTA ---");  //é possível criar duas contas iguais, mas dá problema, ajeitar isso depois
                        System.out.print("Digite seu nome de usuário: ");
                        String nomeNovo = scanner.nextLine();
                        System.out.print("Digite sua senha: ");
                        String senhaNovo = scanner.nextLine();
                        // Verificação de nome ou senha vazios
                        if (nomeNovo.isEmpty() || senhaNovo.isEmpty()) {
                            System.out.println("Nome de usuário ou senha não podem ser vazios. Tente novamente.");
                        } else {
                            if (!usuarios.isEmpty()){
                                for (Usuario usuario_ : usuarios){
                                    if (usuario_.getNome().equals(nomeNovo)){
                                        System.out.println("Impossivel criar conta.");
                                    } else {
                                        usuario = new Usuario(nomeNovo, senhaNovo); //aqui so cria uma nova instância de usuario
                                        System.out.println("Conta criada com sucesso! Seja bem-vindo(a) " + usuario.getNome());
                                        usuarios.add(usuario); //aqui adiciona essa instância na lista geral
                                    }
                                }
                            } else {
                                usuario = new Usuario(nomeNovo, senhaNovo); //aqui so cria uma nova instância de usuario
                                System.out.println("Conta criada com sucesso! Seja bem-vindo(a) " + usuario.getNome());
                                usuarios.add(usuario);
                            }


                        }
                        break;

                    case 3:
                        System.out.println("Muito obrigado pela visita, volte sempre!");
                        System.out.println("Saindo...");
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }

            // Loop de opções para o usuário
            while (running) {
                System.out.println("\n--- MENU ---");
                System.out.println("[1] - Cadastrar conteúdo \n[2] - Procurar conteúdo \n[3] - Criar listas \n[4] - Exibir listas \n[5] - Adicionar conteúdo a uma lista \n[6] - Exibir uma lista \n[7] - Ranking \n[8] - Sair");
                System.out.println("================================================");
                int escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.println("Cadastrando conteúdo...");
                        System.out.println("Digite o título: ");
                        String titulo = scanner.nextLine();
                        System.out.println("Digite a descrição: ");
                        String descricao = scanner.nextLine();
                        System.out.println("Qual o gênero?");
                        String genero = scanner.nextLine();
                        System.out.println("Ano de lançamento: ");
                        int ano = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Qual idioma está?");
                        String idioma = scanner.nextLine();

                        // Pergunta sobre dublagens
                        System.out.println("Quais idiomas de dublagem estão disponíveis? (Digite 'fim' para terminar)");
                        List<String> dublagens = new ArrayList<>();
                        String dublagem;
                        while (true) {
                            dublagem = scanner.nextLine();
                            if (dublagem.equalsIgnoreCase("fim")) {
                                break;
                            }
                            dublagens.add(dublagem);
                        }

                        // Pergunta sobre legendas
                        System.out.println("Quais idiomas de legendas estão disponíveis? (Digite 'fim' para terminar)");
                        List<String> legendas = new ArrayList<>();
                        String legenda;
                        while (true) {
                            legenda = scanner.nextLine();
                            if (legenda.equalsIgnoreCase("fim")) {
                                break;
                            }
                            legendas.add(legenda);
                        }

                        System.out.println("Selecione o tipo: \n[1] - Filme  [2] - Série  [3] - Novela");
                        int tipo = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer
                        Conteudo conteudo = null;  // Instância vazia

                        switch (tipo) {
                            case 1:
                                System.out.println("Qual a duração do filme (em minutos)?");
                                int duracao = scanner.nextInt();
                                scanner.nextLine();
                                conteudo = new Filme(titulo, descricao, Collections.singletonList(genero), ano, "Filme", idioma, dublagens, legendas, duracao);
                                break;
                            case 2:
                                System.out.println("Quantas temporadas tem a série?");
                                int temps = scanner.nextInt();
                                scanner.nextLine();
                                conteudo = new Serie(titulo, descricao, Collections.singletonList(genero), ano, "Serie", idioma, dublagens, legendas, temps);
                                break;
                            case 3:
                                System.out.println("Quantos capítulos tem a novela?");
                                int caps = scanner.nextInt();
                                scanner.nextLine();
                                conteudo = new Novela(titulo, descricao, Collections.singletonList(genero), ano, "Novela", idioma, dublagens, legendas, caps);
                                break;
                        }

                        if (conteudo != null) {
                            conteudosCadastrados.add(conteudo);
                            System.out.println("O conteúdo '" + conteudo.getNome() + "' foi cadastrado!");
                        }
                        break;


                    case 2:
                        System.out.println("Qual conteúdo deseja pesquisar?");
                        String pesquisa = scanner.nextLine();
                        usuario.adicionarAoHistorico(pesquisa); //eu nao to usando o historico, mas se der eu coloco pra mostrar ele
                        boolean encontrado = false; //pra saber se o conteudo foi encontrado ou nao
                        for (Conteudo c : conteudosCadastrados) { //percorre a lista dos conteudos
                            if (c.getNome().equalsIgnoreCase(pesquisa)) { //verifica se o nome ta na lista(ignorando maiusculo e minusculo)
                                encontrado = true;
                                if (encontrado) {
                                    System.out.println("Conteúdo encontrado!");
                                    System.out.println(c.exibirDetalhes());
                                    System.out.println("Deseja avaliar o conteúdo? \n[1]-Sim [2]-Não");
                                    int opc = scanner.nextInt();
                                    Avaliacao avaliacao = new Avaliacao(); //instancia de avaliacao pq ela é uma classe
                                    if (opc == 1) {
                                        System.out.println("Quantas estrelas você dá?(1-5)");
                                        double nota = scanner.nextDouble();
                                        scanner.nextLine();
                                        c.setQuantAvaliacoes(); //soma +1 a quantidade de avaliações
                                        c.setSomaNotas(nota); //adiciona a nota no valor das notas somadas
                                        avaliacao.avaliar(c, nota); //falta eu atribuir a nota aos conteudos, mas faço isso ligeiro
                                        System.out.println("Escreva seu comentário: ");
                                        String comentario = scanner.nextLine();
                                        c.adicionarComentario(comentario);
                                        System.out.println("Ver outros comentarios? \n[1]-Sim [2]-Não");
                                        int option = scanner.nextInt();
                                        scanner.nextLine(); //consumir a quebra de linha
                                        switch ((option)) {
                                            case 1:
                                                c.exibirComentarios();
                                            case 2:
                                                break;
                                        }
                                    } else if (opc == 2) {
                                        break;
                                    }
                                } else if (!encontrado) {
                                    System.out.println("Conteúdo não encontrado");
                                }
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Digite o nome da nova lista: ");
                        String novaLista = scanner.nextLine();
                        usuario.criarLista(novaLista); //aqui cria uma lista de filmes/series/novelas
                        break;

                    case 4:
                        usuario.listarListas(); //lista todas as listas que o usuario tem
                        break;

                    case 5:
                        System.out.print("Digite o nome da lista: ");
                        String listaNome = scanner.nextLine();
                        System.out.print("Digite o conteúdo a ser adicionado: ");
                        String conteudoAdicionado = scanner.nextLine();
                        for (Conteudo c : conteudosCadastrados) {
                            if (c.getNome().equalsIgnoreCase(conteudoAdicionado)) {
                                usuario.adicionarConteudo(listaNome, conteudoAdicionado); //isso é pra verificar se o conteudo q vc quer adicionar existe
                            } else {
                                System.out.println("Esse conteudo nao existe.");
                                break;
                            }
                        }
                        break;

                    case 6:
                        System.out.print("Digite o nome da lista a ser exibida: ");
                        String listaExibir = scanner.nextLine();
                        usuario.exibirLista(listaExibir);
                        break;

                    case 7:
                        System.out.println("RANKING");
                        ArrayList<String> ranking = new ArrayList<>();
                        conteudosCadastrados.sort((c1, c2) -> Double.compare(c2.getNota(), c1.getNota()));
                        int position = 1;

                        for (Conteudo conteudo_ : conteudosCadastrados) {
                            if (position <= 5) {
                                System.out.println(position + "º - " + conteudo_.getNome() + " | Nota: " + conteudo_.getNota());
                                position++;
                            } else {
                                break;
                            }
                        }

                    case 8:
                        System.out.println("Voltando para o menu de login...");
                        running = false; // Sai do loop secundário
                        usuario = null;
                        break; //aqui é pra voltar pro menu de login

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }
}