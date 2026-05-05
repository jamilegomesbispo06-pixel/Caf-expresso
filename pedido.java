import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ControlePedidoTeste {
    @Test
    public void testarCriacaoProduto() {
        Produto produto = new Produto("Suco", 8.0);
        assertEquals("Suco", produto.getNome());
        assertEquals(8.0, produto.getPreco());
    }
    @Test
    public void testarSubtotalItem() {
        Produto produto = new Produto("Pizza", 20.0);
        ItemPedido item = new ItemPedido(produto, 2);
        double subtotal = item.calcularSubtotal();
        assertEquals(40.0, subtotal);
    }
    @Test
    public void testarTotalPedido() {
        Produto produto = new Produto("Refrigerante", 5.0);
        ItemPedido item = new ItemPedido(produto, 3);
        ControlePedido pedido = new ControlePedido();
        pedido.incluirItem(item);
        double total = pedido.obterTotal();
        assertEquals(15.0, total);
    }
    @Test
    public void testarFluxoSituacao() {
        ControlePedido pedido = new ControlePedido();
        // início
        assertEquals(ControlePedido.Situacao.PENDENTE, pedido.getSituacao());
        // pagamento
        pedido.atualizarSituacao(ControlePedido.Situacao.PAGO);
        assertEquals(ControlePedido.Situacao.PAGO, pedido.getSituacao());
        // preparando
        pedido.atualizarSituacao(ControlePedido.Situacao.PREPARANDO);
        assertEquals(ControlePedido.Situacao.PREPARANDO, pedido.getSituacao());
        // concluído
        pedido.atualizarSituacao(ControlePedido.Situacao.CONCLUIDO);
        assertEquals(ControlePedido.Situacao.CONCLUIDO, pedido.getSituacao());
    }
}
