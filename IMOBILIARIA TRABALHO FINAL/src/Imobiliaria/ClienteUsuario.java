package Imobiliaria;

import java.util.ArrayList;
import java.util.List;

public class ClienteUsuario extends Pessoa{
    private List<String> fiadores;
    private List<String> indicacoes;

    public ClienteUsuario(String cpf,
                               String nome,
                               Endereco endereco,
                               List<String> telefones,
                               String email,
                               Sexo sexo,
                               EstadoCivil estadoCivil,
                               String profissao,
                               List<String> fiadores,
                               List<String> indicacoes) {

        super(cpf, nome, endereco, telefones,
                email, sexo, estadoCivil, profissao);

        setFiadores(fiadores);
        setIndicacoes(indicacoes);
    }

    public void setFiadores(List<String> fiadores) {
        if (fiadores == null || fiadores.size() < 1) {
            throw new IllegalArgumentException("Cliente usuario deve ter ao menos 1 fiador.");
        }
        this.fiadores = new ArrayList<>(fiadores);
    }

    public void setIndicacoes(List<String> indicacoes) {
        if (indicacoes == null || indicacoes.size() < 2) {
            throw new IllegalArgumentException("Cliente usuario deve ter ao menos 2 indicacoes.");
        }
        this.indicacoes = new ArrayList<>(indicacoes);
    }

}
