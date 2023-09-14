package entities.objects;

import java.time.Duration;

public class PessoaJuridica extends Pessoa {
    private String CNPJ;
    private String tipoEmpresa;

    public PessoaJuridica(String nome, String endereco, String telefone, String email, String CNPJ, String tipoEmpresa) {
        super(nome, endereco, telefone, email);
        this.CNPJ = CNPJ;
        this.tipoEmpresa = tipoEmpresa;
    }

    @Override
    public final void alugarVeiculo(Aluguel aluguel) {
        alugueis.add(aluguel);
        Duration duracao = Duration.between(aluguel.getAlugado(),aluguel.getDevolucao());
        if(duracao.toDays() >= 3) {
            double valorTotalAluguel = (duracao.toDays() * aluguel.getVeiculo().getPrecoPorDia()) * 0.90;
            aluguel.setValorAluguel(valorTotalAluguel);
        } else {
            aluguel.setValorAluguel(duracao.toDays() * aluguel.getVeiculo().getPrecoPorDia());
        }
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }
}
