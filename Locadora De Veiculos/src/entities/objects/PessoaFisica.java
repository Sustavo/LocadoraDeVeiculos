package entities.objects;

import java.time.Duration;
import java.util.List;

public class PessoaFisica extends Pessoa {
    private String CPF;

    public PessoaFisica(String nome, String endereco, String telefone, String email, String CPF) {
        super(nome, endereco, telefone, email);
        this.CPF = CPF;
    }

    @Override
    public final void alugarVeiculo(Aluguel aluguel) {
        alugueis.add(aluguel);
        Duration duracao = Duration.between(aluguel.getAlugado(),aluguel.getDevolucao());
        if(duracao.toDays() >= 5) {
            double valorTotalAluguel = (duracao.toDays() * aluguel.getVeiculo().getPrecoPorDia()) * 0.95;
            aluguel.setValorAluguel(valorTotalAluguel);
        } else {
            aluguel.setValorAluguel(duracao.toDays() * aluguel.getVeiculo().getPrecoPorDia());
        }
    }


    public String getCPF() {
        return CPF;
    }

}
