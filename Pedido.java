import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private LocalDate data;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private IPagamento metodoPagamento;
    private StatusPedido statusPedido;

    public Pedido(LocalDate data, Cliente cliente) {
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.statusPedido = StatusPedido.PENDENTE;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        for (ItemPedido item : itens) {
            if (item.getProduto().equals(produto)) {
                // soma a quantidade se já existir
                int novaQuantidade = item.getQuantidade() + quantidade;
                itens.remove(item);
                itens.add(new ItemPedido(produto, novaQuantidade));
                System.out.println("Quantidade atualizada para o produto " + produto.getNome());
                return;
            }
        }
        itens.add(new ItemPedido(produto, quantidade));
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void aplicarDesconto(double desconto) {
        double totalAntes = calcularTotal();
        double totalDepois = totalAntes - desconto;
        System.out.println("Desconto aplicado de " + desconto + ". Total anterior: " + totalAntes + ", total com desconto: " + totalDepois);
    }

    public boolean confirmarPedido() {
        if (statusPedido != StatusPedido.PENDENTE) {
            System.out.println("Pedido não está pendente. Status atual: " + statusPedido);
            return false;
        }

        if (metodoPagamento == null) {
            System.out.println("Nenhum método de pagamento definido!");
            return false;
        }

        boolean pagamentoAprovado = metodoPagamento.processarPagamento(this.calcularTotal());

        if (pagamentoAprovado) {
            this.statusPedido = StatusPedido.PROCESSANDO;
            System.out.println("Pedido confirmado e em processamento.");
        } else {
            System.out.println("Falha ao processar pagamento. Pedido permanece pendente.");
        }

        return pagamentoAprovado;
    }

    public void setMetodoPagamento(IPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return statusPedido;
    }
}
