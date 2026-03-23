package Imobiliaria;

public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String complemento;

    public Endereco(String rua,
                    String numero,
                    String bairro,
                    String cidade,
                    String estado,
                    String cep,
                    String complemento) {

        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    @Override
    public String toString() {
        return
        ("Endereço:\n")+
        ("Rua: "+rua+", "+"nº "+numero+" ("+complemento+")\n")+
        ("Bairro: "+bairro+"\n")+
        ("Cidade: "+cidade+" - "+estado+"\n")+
        ("CEP: "+cep);

    }
}
