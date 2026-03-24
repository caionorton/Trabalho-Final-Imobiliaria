package Imobiliaria;

import java.time.LocalDate;

public class SalaComercial extends Imovel {
    private Double area;
    private Integer qtdBanheiros;
    private Integer qtdComodos;

    public SalaComercial(Double area,
                         Integer qtdBanheiros,
                         Integer qtdComodos,
                         StatusImovel status,
                         Double valorVendaOuAluguel,
                         LocalDate dataConstrucao,
                         LocalDate dataColocadoVenda,
                         LocalDate dataVendido,
                         Endereco endereco) {

        super(status, valorVendaOuAluguel, dataConstrucao, dataColocadoVenda, dataVendido, endereco);

        this.area = area;
        this.qtdBanheiros = qtdBanheiros;
        this.qtdComodos = qtdComodos;
    }
}
