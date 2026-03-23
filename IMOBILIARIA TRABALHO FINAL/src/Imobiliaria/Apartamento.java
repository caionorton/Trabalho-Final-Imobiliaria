package Imobiliaria;

import java.time.LocalDate;

public class Apartamento extends Imovel{
    private Integer qtdQuartos;
    private Integer qtdSuites;
    private Integer qtdSalaEstar;
    private Integer qtdSalaJantar;
    private Integer nroVagaGaragem;
    private Double area;
    private Boolean armarioEmbutido;
    private String descricao;
    private Integer andar;
    private Double valorCondominio;
    private Boolean portaria24h;

    public Apartamento(Integer qtdQuartos,
                       Integer qtdSuites,
                       Integer qtdSalaEstar,
                       Integer qtdSalaJantar,
                       Integer nroVagaGaragem,
                       Double area,
                       Boolean armarioEmbutido,
                       String descricao,
                       Integer andar,
                       Double valorCondominio,
                       Boolean portaria24h,
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
        this.andar = andar;
        this.valorCondominio = valorCondominio;
        this.portaria24h = portaria24h;
    }
}
