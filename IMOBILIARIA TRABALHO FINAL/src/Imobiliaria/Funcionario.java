package Imobiliaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
    private String telefoneContato;
    private String telefoneCelular;
    private LocalDate dataIngressoImobiliaria;
    private Cargo cargo;
    private Double salarioBase;
    private Double percentualComissao;
    private String usuarioLogin;
    private String senha;
    private List<Transacao> transacoes;

    public Funcionario(String cpf,
                       String nome,
                       Endereco endereco,
                       List<String> telefones,
                       String email,
                       Sexo sexo,
                       EstadoCivil estadoCivil,
                       String profissao,
                       String telefoneContato,
                       String telefoneCelular,
                       LocalDate dataIngressoImobiliaria,
                       Cargo cargo,
                       Double salarioBase,
                       Double percentualComissao,
                       String usuarioLogin,
                       String senha) {
        super(cpf, nome, endereco, telefones, email, sexo, estadoCivil, profissao);
        this.telefoneContato = telefoneContato;
        this.telefoneCelular = telefoneCelular;
        this.dataIngressoImobiliaria = dataIngressoImobiliaria;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.percentualComissao = percentualComissao;
        this.usuarioLogin = usuarioLogin;
        setSenha(senha);
        this.transacoes = new ArrayList<>();
    }

    public void setSenha(String senha) {
        if (senha == null) {
            throw new IllegalArgumentException("Senha não pode ser nula.");
        }
        this.senha = senha;
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public Double getPercentualComissao() {
        return percentualComissao;
    }
}
