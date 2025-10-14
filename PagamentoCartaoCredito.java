import java.time.LocalDate;

public class PagamentoCartaoCredito implements IPagamento {
    private String numeroCartao;
    private String nomeTitular;
    private LocalDate dataValidade;
    private StatusPagamento statusPagamento;

    public PagamentoCartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
        this.statusPagamento = StatusPagamento.PENDENTE;
    }

    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento com cartão de crédito...");
        if (valor < 5000.0) {
            this.statusPagamento = StatusPagamento.APROVADO;
            System.out.println("Pagamento aprovado; valor: " + valor);
            return true;
        } else {
            this.statusPagamento = StatusPagamento.RECUSADO;
            System.out.println("Pagamento recusado; valor: " + valor);
            return false;
        }
    }

    @Override
    public StatusPagamento getStatus() {
        return statusPagamento;
    }
}
