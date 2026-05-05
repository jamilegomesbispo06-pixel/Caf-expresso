import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SistemaPedidoTeste {
    @Test
    public void criarProduto() {
        Produto p = new Produto("Suco", 8.0);
        assertEquals("Suco", p.getNome());
        assertEquals(8.0, p.getPreco());
    }
    @Test
    public void calcularSubtotalItem() {
        Produto p = new Produto("Hamburguer", 15.0);
        ItemPedido item = new ItemPedido(p, 2);
        double resultado = item.calcularSubtotal();
        assertEquals(30.0, resultado);
    }
    @Test
    public void calcularTotalPedido() {
        Produto p = new Produto("Água", 3.0);
        ItemPedido item = new ItemPedido(p, 5);
        Pedido pedido = new Pedido();
        pedido.adicionarItem(item);
        double total = pedido.calcularTotal();
        assertEquals(15.0, total);
    }
    @Test
    public void fluxoStatusPedido() {
        Pedido pedido = new Pedido();
        // começa pendente
        assertEquals(Pedido.Status.PENDENTE, pedido.getStatus());
        // paga
        pedido.alterarStatus(Pedido.Status.PAGO);
        assertEquals(Pedido.Status.PAGO, pedido.getStatus());
        // preparando
        pedido.alterarStatus(Pedido.Status.EM_PREPARO);
        assertEquals(Pedido.Status.EM_PREPARO, pedido.getStatus());
    // finaliza
        pedido.alterarStatus(Pedido.Status.FINALIZADO);
        assertEquals(Pedido.Status.FINALIZADO, pedido.getStatus());
    }
}
