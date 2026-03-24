package Imobiliaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Imovel {
    protected StatusImovel status;
    protected Double valorVendaOuAluguel;
    protected LocalDate dataConstrucao;
    protected LocalDate dataColocadoVendaOuAluguel;
    protected LocalDate dataVendidoOuAlugado;
    protected Endereco endereco;
    protected List<ClienteProprietario> proprietarios;
    protected ClienteUsuario clienteUsuario;

    public Imovel(StatusImovel status,
                  Double valorVendaOuAluguel,
                  LocalDate dataConstrucao,
                  LocalDate dataColocadoVendaOuAluguel,
                  LocalDate dataVendidoOuAlugado,
                  Endereco endereco) {
        this.status = status;
        this.valorVendaOuAluguel = valorVendaOuAluguel;
        this.dataConstrucao = dataConstrucao;
        this.dataColocadoVendaOuAluguel = dataColocadoVendaOuAluguel;
        this.dataVendidoOuAlugado = dataVendidoOuAlugado;
        this.endereco = endereco;
        this.proprietarios = new ArrayList<>();
    }

    public StatusImovel getStatus() {
        return status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void associarProprietario(ClienteProprietario proprietario) {
        if (!proprietarios.contains(proprietario)) {
            proprietarios.add(proprietario);
            proprietario.adicionarImovel(this);
        }
    }

    public void finalizarTransacao(ClienteUsuario clienteUsuario) {
        this.dataVendidoOuAlugado = LocalDate.now();
        this.clienteUsuario = clienteUsuario;
        if (status == StatusImovel.DISPONIVEL_VENDA) {
            status = StatusImovel.VENDIDO;
        } else if (status == StatusImovel.DISPONIVEL_LOCACAO) {
            status = StatusImovel.LOCADO;
        }
    }

    @Override
    public String toString() {
        return "Status: " + status +
                "\nValor sugerido: R$ " + valorVendaOuAluguel +
                "\nData construcao: " + dataConstrucao +
                "\nData anuncio: " + dataColocadoVendaOuAluguel +
                "\n" + endereco;
    }
}
