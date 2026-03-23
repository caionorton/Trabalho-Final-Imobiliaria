package Imobiliaria;

import java.time.LocalDate;

public class Transacao {
    private static int proximoNumeroContrato = 1;
    private static final double TAXA_COMISSAO_IMOBILIARIA_VENDA = 0.05;
    private static final double TAXA_COMISSAO_IMOBILIARIA_LOCACAO = 0.01;

    private LocalDate dataTransacao;
    private int numeroContrato;
    private FormaPagamento formaPagamento;
    private Imovel imovel;
    private ClienteUsuario clienteUsuario;
    private Funcionario funcionario;
    private Double valorRealTransacao;
    private Double valorComissaoFuncionario;
    private Double valorComissaoImobiliaria;

    public Transacao(LocalDate dataTransacao,
                     FormaPagamento formaPagamento,
                     Imovel imovel,
                     ClienteUsuario clienteUsuario,
                     Funcionario funcionario,
                     Double valorRealTransacao,
                     Double valorComissaoFuncionario) {
        this.dataTransacao = dataTransacao;
        this.numeroContrato = proximoNumeroContrato++;
        this.formaPagamento = formaPagamento;
        this.imovel = imovel;
        this.clienteUsuario = clienteUsuario;
        this.funcionario = funcionario;
        this.valorRealTransacao = valorRealTransacao;
        this.valorComissaoFuncionario = valorComissaoFuncionario;

        if (imovel.getStatus() == StatusImovel.DISPONIVEL_VENDA) {
            this.valorComissaoImobiliaria = valorRealTransacao * TAXA_COMISSAO_IMOBILIARIA_VENDA;
        } else if (imovel.getStatus() == StatusImovel.DISPONIVEL_LOCACAO) {
            this.valorComissaoImobiliaria = valorRealTransacao * TAXA_COMISSAO_IMOBILIARIA_LOCACAO;
        } else {
            this.valorComissaoImobiliaria = 0.0;
        }

        imovel.finalizarTransacao(clienteUsuario);
        funcionario.adicionarTransacao(this);
    }

    public Double getValorComissaoFuncionario() {
        return valorComissaoFuncionario;
    }

    public Double getValorComissaoImobiliaria() {
        return valorComissaoImobiliaria;
    }

    @Override
    public String toString() {
        return "Contrato #" + numeroContrato +
                "\nData: " + dataTransacao +
                "\nForma pagamento: " + formaPagamento +
                "\nValor real: R$ " + valorRealTransacao +
                "\nComissao funcionario: R$ " + valorComissaoFuncionario +
                "\nComissao imobiliaria: R$ " + valorComissaoImobiliaria +
                "\nFuncionario: " + funcionario.getNome() +
                "\nCliente usuario: " + clienteUsuario.getNome() +
                "\nImovel: " + imovel.getEndereco();
    }
}
