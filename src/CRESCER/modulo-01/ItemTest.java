import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void criarItem(){
        Item novoItem = new Item("descricao", 20);
        
        assertEquals("descricao", novoItem.getDescricao());
        assertEquals(20, novoItem.getQuantidade());
    }
    
    @Test
    public void alterarQuantidade(){
        Item novoItem = new Item("descricao", 20);
        novoItem.setQuantidade(300);
        
        assertEquals(300, novoItem.getQuantidade());
    }
    
    @Test
    public void aumentar1000UnidadesItem() {
        Item item = new Item("item", 5);
        item.aumentarUnidades(1000);
        assertEquals(1005, item.getQuantidade());
    }
    
    @Test
    public void aumentar0UnidadesItem() {
        Item item = new Item("item", 5);
        item.aumentarUnidades(0);
        assertEquals(5, item.getQuantidade());
    }
    
    @Test
    public void diminuirUnidadeItem() {
        Item item = new Item("item", 5);
        item.aumentarUnidades(-5);
        assertEquals(0, item.getQuantidade());
    }
}
