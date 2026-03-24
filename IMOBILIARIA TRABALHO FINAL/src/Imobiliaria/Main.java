package Imobiliaria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        List<Imovel> imoveis = new ArrayList<>();
        List<ClienteProprietario> proprietarios = new ArrayList<>();
        List<ClienteUsuario> usuarios = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Transacao> transacoes = new ArrayList<>();

        int opcao;
        do {
            mostrarMenu();
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarClienteProprietario(sc, proprietarios);
                    break;
                case 2:
                    cadastrarClienteUsuario(sc, usuarios);
                    break;
                case 3:
                    cadastrarFuncionario(sc, funcionarios);
                    break;
                case 4:
                    cadastrarImovel(sc, imoveis);
                    break;
                case 5:
                    associarProprietarioAoImovel(sc, proprietarios, imoveis);
                    break;
                case 6:
                    listarImoveis(imoveis);
                    break;
                case 7:
                    consultarStatusImovel(sc, imoveis);
                    break;
                case 8:
                    buscarImoveisPorBairro(sc, imoveis);
                    break;
                case 9:
                    realizarTransacao(sc, imoveis, usuarios, funcionarios, transacoes);
                    break;
                case 10:
                    listarTransacoes(transacoes);
                    break;
                case 11:
                    listarClientesProprietarios(proprietarios);
                    break;
                case 12:
                    listarClientesUsuarios(usuarios);
                    break;
                case 13:
                    listarFuncionarios(funcionarios);
                    break;
                case 0:
                    System.out.println("Encerrando sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

    }

    private static void mostrarMenu() {
        System.out.println("\n========== IMOBILIARIA ==========");
        System.out.println("1 - Cadastrar cliente proprietario");
        System.out.println("2 - Cadastrar cliente usuario");
        System.out.println("3 - Cadastrar funcionario");
        System.out.println("4 - Cadastrar imovel");
        System.out.println("5 - Associar proprietario ao imovel");
        System.out.println("6 - Listar imoveis");
        System.out.println("7 - Consultar status do imovel");
        System.out.println("8 - Buscar imoveis por bairro");
        System.out.println("9 - Realizar transacao (venda/aluguel)");
        System.out.println("10 - Listar transacoes");
        System.out.println("11 - Listar clientes proprietarios");
        System.out.println("12 - Listar clientes usuarios");
        System.out.println("13 - Listar funcionarios");
        System.out.println("0 - Sair");
        System.out.println("================================");
    }

    private static void cadastrarClienteProprietario(Scanner sc, List<ClienteProprietario> proprietarios) {
        System.out.println("\nCadastro de cliente proprietario");
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Rua: ");
        String rua = sc.nextLine();
        System.out.print("Numero: ");
        String numero = sc.nextLine();
        System.out.print("Bairro: ");
        String bairro = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        System.out.print("CEP: ");
        String cep = sc.nextLine();
        System.out.print("Complemento: ");
        String complemento = sc.nextLine();
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep, complemento);

        System.out.print("Quantidade de telefone(s): ");
        int qtdTelefones = sc.nextInt();
        sc.nextLine();
        List<String> telefones = new ArrayList<>();
        for (int i = 0; i < qtdTelefones; i++) {
            System.out.print("telefone " + (i + 1) + ": ");
            telefones.add(sc.nextLine());
        }

        System.out.print("Email: ");
        String email = sc.nextLine();
        Sexo sexo = escolherSexo(sc);
        EstadoCivil estadoCivil = escolherEstadoCivil(sc);
        System.out.print("Profissao: ");
        String profissao = sc.nextLine();

        ClienteProprietario cliente = new ClienteProprietario(
                cpf, nome, endereco, telefones, email, sexo, estadoCivil, profissao
        );
        proprietarios.add(cliente);
        System.out.println("Cliente proprietario cadastrado.");
    }

    private static void cadastrarClienteUsuario(Scanner sc, List<ClienteUsuario> usuarios) {
        System.out.println("\nCadastro de cliente usuario");
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Rua: ");
        String rua = sc.nextLine();
        System.out.print("Numero: ");
        String numero = sc.nextLine();
        System.out.print("Bairro: ");
        String bairro = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        System.out.print("CEP: ");
        String cep = sc.nextLine();
        System.out.print("Complemento: ");
        String complemento = sc.nextLine();
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep, complemento);

        System.out.print("Quantidade de telefone(s): ");
        int qtdTelefones = sc.nextInt();
        sc.nextLine();
        List<String> telefones = new ArrayList<>();
        for (int i = 0; i < qtdTelefones; i++) {
            System.out.print("telefone " + (i + 1) + ": ");
            telefones.add(sc.nextLine());
        }

        System.out.print("Email: ");
        String email = sc.nextLine();
        Sexo sexo = escolherSexo(sc);
        EstadoCivil estadoCivil = escolherEstadoCivil(sc);
        System.out.print("Profissao: ");
        String profissao = sc.nextLine();

        int qtdFiadores;
        do {
            System.out.print("Quantidade de fiador(es) (minimo 1): ");
            qtdFiadores = sc.nextInt();
            sc.nextLine();
        } while (qtdFiadores < 1);
        List<String> fiadores = new ArrayList<>();
        for (int i = 0; i < qtdFiadores; i++) {
            System.out.print("fiador " + (i + 1) + ": ");
            fiadores.add(sc.nextLine());
        }

        int qtdIndicacoes;
        do {
            System.out.print("Quantidade de indicacao(oes) (minimo 2): ");
            qtdIndicacoes = sc.nextInt();
            sc.nextLine();
        } while (qtdIndicacoes < 2);
        List<String> indicacoes = new ArrayList<>();
        for (int i = 0; i < qtdIndicacoes; i++) {
            System.out.print("indicacao " + (i + 1) + ": ");
            indicacoes.add(sc.nextLine());
        }

        ClienteUsuario cliente = new ClienteUsuario(
                cpf, nome, endereco, telefones, email, sexo, estadoCivil, profissao, fiadores, indicacoes
        );
        usuarios.add(cliente);
        System.out.println("Cliente usuario cadastrado.");
    }

    private static void cadastrarFuncionario(Scanner sc, List<Funcionario> funcionarios) {
        System.out.println("\nCadastro de funcionario");
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Rua: ");
        String rua = sc.nextLine();
        System.out.print("Numero: ");
        String numero = sc.nextLine();
        System.out.print("Bairro: ");
        String bairro = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        System.out.print("CEP: ");
        String cep = sc.nextLine();
        System.out.print("Complemento: ");
        String complemento = sc.nextLine();
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep, complemento);

        System.out.print("Quantidade de telefone(s): ");
        int qtdTelefones = sc.nextInt();
        sc.nextLine();
        List<String> telefones = new ArrayList<>();
        for (int i = 0; i < qtdTelefones; i++) {
            System.out.print("telefone " + (i + 1) + ": ");
            telefones.add(sc.nextLine());
        }

        System.out.print("Email: ");
        String email = sc.nextLine();
        Sexo sexo = escolherSexo(sc);
        EstadoCivil estadoCivil = escolherEstadoCivil(sc);
        System.out.print("Profissao: ");
        String profissao = sc.nextLine();
        System.out.print("Telefone de contato: ");
        String telefoneContato = sc.nextLine();
        System.out.print("Telefone celular: ");
        String telefoneCelular = sc.nextLine();
        System.out.print("Data de ingresso (dd/MM/yyyy): ");
        LocalDate dataIngresso = LocalDate.parse(sc.nextLine(), FORMATO_DATA);
        Cargo cargo = escolherCargo(sc);
        System.out.print("Salario base: ");
        double salarioBase = sc.nextDouble();
        sc.nextLine();
        System.out.print("Percentual de comissao (ex 0.05 para 5%): ");
        double percentualComissao = sc.nextDouble();
        sc.nextLine();
        System.out.print("Usuario de login: ");
        String usuarioLogin = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Funcionario funcionario = new Funcionario(
                cpf, nome, endereco, telefones, email, sexo, estadoCivil, profissao,
                telefoneContato, telefoneCelular, dataIngresso, cargo,
                salarioBase, percentualComissao, usuarioLogin, senha
        );
        funcionarios.add(funcionario);
        System.out.println("Funcionario cadastrado.");
    }

    private static void cadastrarImovel(Scanner sc, List<Imovel> imoveis) {
        System.out.println("\nCadastro de imovel");
        System.out.println("1 - Casa");
        System.out.println("2 - Apartamento");
        System.out.println("3 - Terreno");
        System.out.println("4 - Sala comercial");
        System.out.print("Tipo: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        StatusImovel status = escolherStatusDisponivel(sc);
        System.out.print("Valor sugerido para venda/aluguel: ");
        double valor = sc.nextDouble();
        sc.nextLine();
        System.out.print("Data de construcao (dd/MM/yyyy): ");
        LocalDate dataConstrucao = LocalDate.parse(sc.nextLine(), FORMATO_DATA);

        System.out.print("Rua: ");
        String rua = sc.nextLine();
        System.out.print("Numero: ");
        String numero = sc.nextLine();
        System.out.print("Bairro: ");
        String bairro = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        System.out.print("CEP: ");
        String cep = sc.nextLine();
        System.out.print("Complemento: ");
        String complemento = sc.nextLine();
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep, complemento);

        Imovel imovel;
        if (tipo == 1) {
            System.out.print("Quantidade de quartos: ");
            int qtdQuartos = sc.nextInt();
            sc.nextLine();
            System.out.print("Quantidade de suites: ");
            int qtdSuites = sc.nextInt();
            sc.nextLine();
            System.out.print("Quantidade de salas de estar: ");
            int qtdSalaEstar = sc.nextInt();
            sc.nextLine();
            System.out.print("Quantidade de salas de jantar: ");
            int qtdSalaJantar = sc.nextInt();
            sc.nextLine();
            System.out.print("Numero de vagas na garagem: ");
            int vagas = sc.nextInt();
            sc.nextLine();
            System.out.print("Area em m2: ");
            double area = sc.nextDouble();
            sc.nextLine();
            System.out.print("Possui armario embutido (s/n): ");
            String armarioTexto = sc.nextLine().trim().toLowerCase();
            boolean armario = armarioTexto.equals("s") || armarioTexto.equals("sim");
            System.out.print("Descricao: ");
            String descricao = sc.nextLine();
            imovel = new Casa(
                    qtdQuartos, qtdSuites, qtdSalaEstar, qtdSalaJantar, vagas, area, armario, descricao,
                    status, valor, dataConstrucao, LocalDate.now(), null, endereco
            );
        } else if (tipo == 2) {
            System.out.print("Quantidade de quartos: ");
            int qtdQuartos = sc.nextInt();
            sc.nextLine();
            System.out.print("Quantidade de suites: ");
            int qtdSuites = sc.nextInt();
            sc.nextLine();
            System.out.print("Quantidade de salas de estar: ");
            int qtdSalaEstar = sc.nextInt();
            sc.nextLine();
            System.out.print("Quantidade de salas de jantar: ");
            int qtdSalaJantar = sc.nextInt();
            sc.nextLine();
            System.out.print("Numero de vagas na garagem: ");
            int vagas = sc.nextInt();
            sc.nextLine();
            System.out.print("Area em m2: ");
            double area = sc.nextDouble();
            sc.nextLine();
            System.out.print("Possui armario embutido (s/n): ");
            String armarioTexto = sc.nextLine().trim().toLowerCase();
            boolean armario = armarioTexto.equals("s") || armarioTexto.equals("sim");
            System.out.print("Descricao: ");
            String descricao = sc.nextLine();
            System.out.print("Andar: ");
            int andar = sc.nextInt();
            sc.nextLine();
            System.out.print("Valor do condominio: ");
            double valorCondominio = sc.nextDouble();
            sc.nextLine();
            System.out.print("Possui portaria 24h (s/n): ");
            String portariaTexto = sc.nextLine().trim().toLowerCase();
            boolean portaria24h = portariaTexto.equals("s") || portariaTexto.equals("sim");
            imovel = new Apartamento(
                    qtdQuartos, qtdSuites, qtdSalaEstar, qtdSalaJantar, vagas, area, armario, descricao,
                    andar, valorCondominio, portaria24h,
                    status, valor, dataConstrucao, LocalDate.now(), null, endereco
            );
        } else if (tipo == 3) {
            System.out.print("Area em m2: ");
            double area = sc.nextDouble();
            sc.nextLine();
            System.out.print("Largura: ");
            double largura = sc.nextDouble();
            sc.nextLine();
            System.out.print("Comprimento: ");
            double comprimento = sc.nextDouble();
            sc.nextLine();
            System.out.print("Possui aclive/declive (s/n): ");
            String acliveTexto = sc.nextLine().trim().toLowerCase();
            boolean acliveDeclive = acliveTexto.equals("s") || acliveTexto.equals("sim");
            imovel = new Terreno(
                    area, largura, comprimento, acliveDeclive,
                    status, valor, dataConstrucao, LocalDate.now(), null, endereco
            );
        } else if (tipo == 4) {
            System.out.print("Area em m2: ");
            double area = sc.nextDouble();
            sc.nextLine();
            System.out.print("Quantidade de banheiros: ");
            int qtdBanheiros = sc.nextInt();
            sc.nextLine();
            System.out.print("Quantidade de comodos: ");
            int qtdComodos = sc.nextInt();
            sc.nextLine();
            imovel = new SalaComercial(
                    area, qtdBanheiros, qtdComodos,
                    status, valor, dataConstrucao, LocalDate.now(), null, endereco
            );
        } else {
            System.out.println("Tipo invalido.");
            return;
        }

        imoveis.add(imovel);
        System.out.println("Imovel cadastrado.");
    }

    private static void associarProprietarioAoImovel(Scanner sc, List<ClienteProprietario> proprietarios, List<Imovel> imoveis) {
        if (proprietarios.isEmpty() || imoveis.isEmpty()) {
            System.out.println("Cadastre ao menos 1 proprietario e 1 imovel antes.");
            return;
        }

        int indiceProprietario = escolherProprietario(sc, proprietarios);
        int indiceImovel = escolherImovel(sc, imoveis);
        if (indiceProprietario < 0 || indiceImovel < 0) {
            return;
        }

        ClienteProprietario proprietario = proprietarios.get(indiceProprietario);
        Imovel imovel = imoveis.get(indiceImovel);
        imovel.associarProprietario(proprietario);
        System.out.println("Proprietario associado ao imovel.");
    }

    private static void listarImoveis(List<Imovel> imoveis) {
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imovel cadastrado.");
            return;
        }

        for (int i = 0; i < imoveis.size(); i++) {
            Imovel imovel = imoveis.get(i);
            System.out.println("\n[" + i + "] " + imovel.getClass().getSimpleName());
            System.out.println(imovel);
        }
    }

    private static void consultarStatusImovel(Scanner sc, List<Imovel> imoveis) {
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imovel cadastrado.");
            return;
        }

        int indice = escolherImovel(sc, imoveis);
        if (indice < 0) {
            return;
        }

        Imovel imovel = imoveis.get(indice);
        System.out.println("Status atual: " + imovel.getStatus());
        System.out.println("Tipo: " + imovel.getClass().getSimpleName());
        System.out.println("Endereco: " + imovel.getEndereco());
    }

    private static void buscarImoveisPorBairro(Scanner sc, List<Imovel> imoveis) {
        System.out.print("Digite o bairro: ");
        String bairro = sc.nextLine();
        boolean encontrou = false;

        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().getBairro().equalsIgnoreCase(bairro)) {
                System.out.println("\n" + imovel.getClass().getSimpleName());
                System.out.println(imovel);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum imovel encontrado nesse bairro.");
        }
    }

    private static void realizarTransacao(Scanner sc,
                                          List<Imovel> imoveis,
                                          List<ClienteUsuario> usuarios,
                                          List<Funcionario> funcionarios,
                                          List<Transacao> transacoes) {
        if (imoveis.isEmpty() || usuarios.isEmpty() || funcionarios.isEmpty()) {
            System.out.println("Cadastre imovel, cliente usuario e funcionario antes.");
            return;
        }

        int indiceImovel = escolherImovel(sc, imoveis);
        if (indiceImovel < 0) {
            return;
        }
        Imovel imovel = imoveis.get(indiceImovel);
        if (imovel.getStatus() != StatusImovel.DISPONIVEL_VENDA && imovel.getStatus() != StatusImovel.DISPONIVEL_LOCACAO) {
            System.out.println("Esse imovel nao esta disponivel para transacao.");
            return;
        }

        int indiceUsuario = escolherClienteUsuario(sc, usuarios);
        int indiceFuncionario = escolherFuncionario(sc, funcionarios);
        if (indiceUsuario < 0 || indiceFuncionario < 0) {
            return;
        }

        FormaPagamento formaPagamento = escolherFormaPagamento(sc);
        System.out.print("Valor real da transacao: ");
        double valorReal = sc.nextDouble();
        sc.nextLine();
        Funcionario funcionario = funcionarios.get(indiceFuncionario);
        double comissao = valorReal * funcionario.getPercentualComissao();

        Transacao transacao = new Transacao(
                LocalDate.now(),
                formaPagamento,
                imovel,
                usuarios.get(indiceUsuario),
                funcionario,
                valorReal,
                comissao
        );
        transacoes.add(transacao);
        System.out.println("Comissao do funcionario: R$ " + transacao.getValorComissaoFuncionario());
        System.out.println("Comissao da imobiliaria (5% venda / 1% locacao): R$ " + transacao.getValorComissaoImobiliaria());
        System.out.println("Transacao registrada com sucesso.");
    }

    private static void listarTransacoes(List<Transacao> transacoes) {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transacao registrada.");
            return;
        }

        for (int i = 0; i < transacoes.size(); i++) {
            System.out.println("\n[" + i + "]");
            System.out.println(transacoes.get(i));
        }
    }

    private static void listarClientesProprietarios(List<ClienteProprietario> proprietarios) {
        if (proprietarios.isEmpty()) {
            System.out.println("Nenhum cliente proprietario cadastrado.");
            return;
        }

        for (int i = 0; i < proprietarios.size(); i++) {
            ClienteProprietario cliente = proprietarios.get(i);
            System.out.println("[" + i + "] Nome: " + cliente.getNome() + " | CPF: " + cliente.getCpf());
        }
    }

    private static void listarClientesUsuarios(List<ClienteUsuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum cliente usuario cadastrado.");
            return;
        }

        for (int i = 0; i < usuarios.size(); i++) {
            ClienteUsuario cliente = usuarios.get(i);
            System.out.println("[" + i + "] Nome: " + cliente.getNome() + " | CPF: " + cliente.getCpf());
        }
    }

    private static void listarFuncionarios(List<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
            return;
        }

        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            System.out.println("[" + i + "] Nome: " + funcionario.getNome() + " | CPF: " + funcionario.getCpf());
        }
    }

    private static Sexo escolherSexo(Scanner sc) {
        System.out.println("Sexo: 1-HOMEM 2-MULHER 3-OUTROS");
        System.out.print("Escolha: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        if (opcao == 1) {
            return Sexo.HOMEM;
        } else if (opcao == 2) {
            return Sexo.MULHER;
        }
        return Sexo.OUTROS;
    }

    private static EstadoCivil escolherEstadoCivil(Scanner sc) {
        System.out.println("Estado civil: 1-SOLTEIRO 2-CASADO");
        System.out.print("Escolha: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        if (opcao == 2) {
            return EstadoCivil.CASADO;
        }
        return EstadoCivil.SOLTEIRO;
    }

    private static Cargo escolherCargo(Scanner sc) {
        System.out.println("Cargo: 1-CORRETOR 2-GERENTE 3-ADMINISTRATIVO");
        System.out.print("Escolha: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        if (opcao == 2) {
            return Cargo.GERENTE;
        } else if (opcao == 3) {
            return Cargo.ADMINISTRATIVO;
        }
        return Cargo.CORRETOR;
    }

    private static StatusImovel escolherStatusDisponivel(Scanner sc) {
        System.out.println("Status inicial: 1-DISPONIVEL_VENDA 2-DISPONIVEL_LOCACAO");
        System.out.print("Escolha: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        if (opcao == 2) {
            return StatusImovel.DISPONIVEL_LOCACAO;
        }
        return StatusImovel.DISPONIVEL_VENDA;
    }

    private static FormaPagamento escolherFormaPagamento(Scanner sc) {
        System.out.println("Forma de pagamento:");
        System.out.println("1-DINHEIRO 2-PIX 3-CARTAO 4-BOLETO");
        System.out.print("Escolha: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        if (opcao == 1) {
            return FormaPagamento.DINHEIRO;
        } else if (opcao == 2) {
            return FormaPagamento.PIX;
        } else if (opcao == 3) {
            return FormaPagamento.CARTAO;
        }
        return FormaPagamento.BOLETO;
    }

    private static int escolherImovel(Scanner sc, List<Imovel> imoveis) {
        for (int i = 0; i < imoveis.size(); i++) {
            Imovel imovel = imoveis.get(i);
            System.out.println("[" + i + "] " + imovel.getClass().getSimpleName() +
                    " - Bairro: " + imovel.getEndereco().getBairro() +
                    " - Status: " + imovel.getStatus());
        }
        System.out.print("Escolha o indice do imovel: ");
        int indice = sc.nextInt();
        sc.nextLine();
        if (indice < 0 || indice >= imoveis.size()) {
            System.out.println("Indice invalido.");
            return -1;
        }
        return indice;
    }

    private static int escolherProprietario(Scanner sc, List<ClienteProprietario> proprietarios) {
        for (int i = 0; i < proprietarios.size(); i++) {
            ClienteProprietario cliente = proprietarios.get(i);
            System.out.println("[" + i + "] " + cliente.getNome() + " - CPF: " + cliente.getCpf());
        }
        System.out.print("Escolha o indice do proprietario: ");
        int indice = sc.nextInt();
        sc.nextLine();
        if (indice < 0 || indice >= proprietarios.size()) {
            System.out.println("Indice invalido.");
            return -1;
        }
        return indice;
    }

    private static int escolherClienteUsuario(Scanner sc, List<ClienteUsuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            ClienteUsuario cliente = usuarios.get(i);
            System.out.println("[" + i + "] " + cliente.getNome() + " - CPF: " + cliente.getCpf());
        }
        System.out.print("Escolha o indice do cliente usuario: ");
        int indice = sc.nextInt();
        sc.nextLine();
        if (indice < 0 || indice >= usuarios.size()) {
            System.out.println("Indice invalido.");
            return -1;
        }
        return indice;
    }

    private static int escolherFuncionario(Scanner sc, List<Funcionario> funcionarios) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            System.out.println("[" + i + "] " + funcionario.getNome() + " - CPF: " + funcionario.getCpf());
        }
        System.out.print("Escolha o indice do funcionario: ");
        int indice = sc.nextInt();
        sc.nextLine();
        if (indice < 0 || indice >= funcionarios.size()) {
            System.out.println("Indice invalido.");
            return -1;
        }
        return indice;
    }
}
