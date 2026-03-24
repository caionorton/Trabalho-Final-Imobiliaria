package Imobiliaria;

import java.util.ArrayList;
import java.util.List;

public class ClienteProprietario extends Pessoa {
    private List<Imovel> imoveis = new ArrayList<>();

    public ClienteProprietario(String cpf,
                               String nome,
                               Endereco endereco,
                               List<String> telefones,
                               String email,
                               Sexo sexo,
                               EstadoCivil estadoCivil,
                               String profissao) {

        super(cpf, nome, endereco, telefones,
                email, sexo, estadoCivil, profissao);
    }

    public void adicionarImovel(Imovel imovel) {
        if (!imoveis.contains(imovel)) {
            imoveis.add(imovel);
        }
    }

}
