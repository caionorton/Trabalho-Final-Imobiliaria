package Imobiliaria;

import java.util.List;

public abstract class Pessoa {
    protected String cpf;
    protected String nome;
    protected Endereco endereco;
    protected List<String> telefones;
    protected String email;
    protected Sexo sexo;
    protected EstadoCivil estadoCivil;
    protected String profissao;

    public Pessoa(String cpf,
                  String nome,
                  Endereco endereco,
                  List<String> telefones,
                  String email,
                  Sexo sexo,
                  EstadoCivil estadoCivil,
                  String profissao) {

        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefones = telefones;
        this.email = email;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

}
