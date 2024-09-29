package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = Controller.getInstance();

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("----- Sistema de Cadastro de Bandas -----");
            System.out.println("1. Cadastrar Banda");
            System.out.println("2. Listar Bandas");
            System.out.println("3. Ver Banda");
            System.out.println("4. Editar Nome de uma Banda");
            System.out.println("5. Deletar Banda");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarBanda();
                    break;
                case 2:
                    controller.listarBandas();
                    break;
                case 3:
                    verBanda();
                    break;
                case 4:
                    editarNomeBanda();
                    break;
                case 5:
                    deletarBanda();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void cadastrarBanda() {
        System.out.print("Nome da banda: ");
        String nome = scanner.nextLine();

        System.out.print("Gênero musical: ");
        String genero = scanner.nextLine();

        List<String> integrantes = new ArrayList<>();
        String integrante;

        System.out.println("Digite o nome dos integrantes (deixe em branco para finalizar):");
        while (true) {
            System.out.print("Integrante: ");
            integrante = scanner.nextLine();
            if (integrante.isEmpty()) {
                break;
            }
            integrantes.add(integrante);
        }

        System.out.print("Ano de formação: ");
        int anoFormacao = scanner.nextInt();
        scanner.nextLine();  // Consumir o newline

        Banda banda = new Banda(controller.getQuantidadeBandas() + 1, nome, genero, integrantes, anoFormacao);
        controller.adicionarBanda(banda);
    }

    private void verBanda() {
        System.out.print("Digite o id da banda: ");
        int id = scanner.nextInt();
        Banda banda = controller.buscarBanda(id);
        if (banda != null) {
            System.out.println(banda);
        } else {
            System.out.println("Banda não encontrada.");
        }
    }

    private void editarNomeBanda() {
        System.out.print("Digite o id da banda que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        Banda banda = controller.buscarBanda(id);
        if (banda != null) {
            System.out.print("Digite o novo nome da banda: ");
            String novoNome = scanner.nextLine();
            controller.editarNomeBanda(banda, novoNome);
        } else {
            System.out.println("Banda não encontrada.");
        }
    }

    private void deletarBanda() {
        System.out.print("Digite o id da banda que deseja deletar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Banda banda = controller.buscarBanda(id);
        if (banda != null) {
            controller.deletarBanda(banda);
        } else {
            System.out.println("Banda não encontrada.");
        }
    }
}
