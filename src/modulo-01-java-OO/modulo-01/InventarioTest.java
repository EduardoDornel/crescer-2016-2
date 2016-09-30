

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void adcItemNaPrimeiraPosicao(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("mosquete", 1));
        
        assertEquals("mosquete", inventario.getItens().get(0).getDescricao());
        assertEquals(1, inventario.getItens().get(0).getQuantidade());
    }
    
    @Test
    public void adcItemNaTerceiraPosicao(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("pistola", 3));
        inventario.adicionarItem(new Item("revolver", 5));
        inventario.adicionarItem(new Item("mosquete", 1));
        
        assertEquals("mosquete", inventario.getItens().get(2).getDescricao());
        assertEquals(1, inventario.getItens().get(2).getQuantidade());
    }
    
    @Test
    public void removeItem(){
        Inventario inventario = new Inventario();
        Item pistola = new Item("pistola", 3);
        inventario.adicionarItem(pistola);
        
        assertEquals(pistola, inventario.getItens().get(0));
        
        inventario.removerItem(pistola);
        Item bomba = new Item("bomba", 10);
        inventario.adicionarItem(bomba);
        assertEquals(bomba, inventario.getItens().get(0));
    }
    
    @Test
    public void pegarDescricoesDosItens(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("pistola", 3));
        inventario.adicionarItem(new Item("revolver", 5));
        inventario.adicionarItem(new Item("mosquete", 1));
        
        assertEquals("pistola, revolver, mosquete.", inventario.getDescricoesItens());
    }
    
    @Test
    public void retornaItemComMaiorQuantidade(){
        Inventario inventario = new Inventario();        
        Item pistola = new Item("pistola", 3);
        Item bomba = new Item("bomba", 5);
        Item revolver = new Item("revolver", 6);
        Item mosquete = new Item("mosquete", 7);
        Item metralhadora = new Item("metralhadora", 8);
        inventario.adicionarItem(pistola);
        inventario.adicionarItem(bomba);        
        inventario.adicionarItem(revolver);
        inventario.adicionarItem(mosquete);
        inventario.adicionarItem(metralhadora);    
        
        assertEquals(metralhadora, inventario.itemMaiorQuantidade());
    }
    
    
}
