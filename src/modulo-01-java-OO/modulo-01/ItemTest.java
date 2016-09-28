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
}
