import java.time.LocalDate;

public class PagamentoBoleto implements IPagamento {
    private String codigoBarras;
    private LocalDate dataVencimento;
    private double valor;
    private StatusPagamento statusPagamento;

    public PagamentoBoleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
        this.statusPagamento = StatusPagamento.PENDENTE;
    }

    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Gerando boleto...");
        this.statusPagamento = StatusPagamento.APROVADO;
        this.valor = valor;
        System.out.println("Boleto gerado com sucesso; valor: " + valor);
        return true;
    }

    @Override
    public StatusPagamento getStatus() {
        return statusPagamento;
    }
}
