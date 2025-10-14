import java.time.LocalDate;

public class SistemaPedidos {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Fortrek Teclado Gamer BLACK EAGLE", 50.0);
        Produto produto2 = new Produto("Mouse Pad Preto", 100.00);
        Produto produto3 = new Produto("Mouse Dell sem fio - WM118", 250.0);

        ClientePF cliente1 = new ClientePF("Jaqueline Costa Mole", "jcosta@gmail.com", "20335132");
        ClientePJ cliente2 = new ClientePJ("Ipiranga LTDA", "ipira@gmail.com", "66565115");

        Pedido pedido1 = new Pedido(LocalDate.now(), cliente1);
        pedido1.adicionarItem(produto1, 1000);
        pedido1.adicionarItem(produto2, 1);
        pedido1.setMetodoPagamento(new PagamentoCartaoCredito("5132-5678-9999-0000"));
        System.out.println("Pedido 1 pagamento: " + pedido1.confirmarPedido());

        Pedido pedido2 = new Pedido(LocalDate.now(), cliente2);
        pedido2.adicionarItem(produto3, 2);
        pedido2.setMetodoPagamento(new PagamentoCartaoCredito("9374-7707-6620-55855"));
        System.out.println("Pedido 2 pagamento: " + pedido2.confirmarPedido());

        Pedido pedido3 = new Pedido(LocalDate.now(), cliente1);
        pedido3.adicionarItem(produto3, 3);
        pedido3.adicionarItem(produto1, 1);
        pedido3.setMetodoPagamento(new PagamentoBoleto("5551255126677"));
        System.out.println("Pedido 3 pagamento: " + pedido3.confirmarPedido());

        Pedido pedido4 = new Pedido(LocalDate.now(), cliente2);
        pedido4.adicionarItem(produto3, 6);
        pedido4.setMetodoPagamento(new PagamentoBoleto("5465213235513121"));
        System.out.println("Pedido 4 pagamento: " + pedido4.confirmarPedido());
    }
}
