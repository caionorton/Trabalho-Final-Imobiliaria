package Imobiliaria;

import java.time.LocalDate;

public class Terreno extends Imovel{
    private Double area;
    private Double largura;
    private Double comprimento;
    private Boolean acliveDeclive;

    public Terreno(Double area,
                   Double largura,
                   Double comprimento,
                   Boolean acliveDeclive,
                   StatusImovel status,
                   Double valorVendaOuAluguel,
                   LocalDate dataConstrucao,
                   LocalDate dataColocadoVenda,
                   LocalDate dataVendido,
                   Endereco endereco) {

        super(status, valorVendaOuAluguel, dataConstrucao, dataColocadoVenda, dataVendido, endereco);

        this.area = area;
        this.largura = largura;
        this.comprimento = comprimento;
        this.acliveDeclive = acliveDeclive;
    }
}
