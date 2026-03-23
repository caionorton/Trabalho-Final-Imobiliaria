package Imobiliaria;

import java.time.LocalDate;

public class Casa extends Imovel{
    private Integer qtdQuartos;
    private Integer qtdSuites;
    private Integer qtdSalaEstar;
    private Integer qtdSalaJantar;
    private Integer nroVagaGaragem;
    private Double area;
    private Boolean armarioEmbutido;
    private String descricao;

    public Casa(Integer qtdQuartos,
                Integer qtdSuites,
                Integer qtdSalaEstar,
                Integer qtdSalaJantar,
                Integer nroVagaGaragem,
                Double area,
                Boolean armarioEmbutido,
                String descricao,
                StatusImovel status,
                Double valorVendaOuAluguel,
                LocalDate dataConstrucao,
                LocalDate dataColocadoVenda,
                LocalDate dataVendido,
                Endereco endereco) {

        super(status, valorVendaOuAluguel, dataConstrucao, dataColocadoVenda, dataVendido, endereco);

        this.qtdQuartos = qtdQuartos;
        this.qtdSuites = qtdSuites;
        this.qtdSalaEstar = qtdSalaEstar;
        this.qtdSalaJantar = qtdSalaJantar;
        this.nroVagaGaragem = nroVagaGaragem;
        this.area = area;
        this.armarioEmbutido = armarioEmbutido;
        this.descricao = descricao;
    }

}
