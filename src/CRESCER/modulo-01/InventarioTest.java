

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
    public void adicionarCincoItensNoInventario() {
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z", 1);
        Item item = new Item("Iron Boots", 1);
        inventario.adicionarItem(espadaZ);
        inventario.adicionarItem(item);
        inventario.adicionarItem(item);
        inventario.adicionarItem(item);
        inventario.adicionarItem(item);
        assertTrue(inventario.getItens().contains(espadaZ));
        assertTrue(inventario.getItens().contains(item));
        assertEquals(5, inventario.getItens().size());
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
    public void inventarioSemAdicionarItem() {
        Inventario inventario = new Inventario();
        Item item = new Item("Espada Z", 1);
        assertFalse(inventario.getItens().contains(item));
    }
    
    @Test
    public void pegarDescricoesDosItens(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("pistola", 3));
        inventario.adicionarItem(new Item("revolver", 5));
        inventario.adicionarItem(new Item("mosquete", 1));
        
        assertEquals("pistola, revolver, mosquete", inventario.getDescricoesItens());
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
    
    @Test
    public void adicionarDoisItensERemoverUm() {
        Inventario inventario = new Inventario();
        Item item = new Item("item", 1);
        Item item2 = new Item("item2", 1);
        inventario.adicionarItem(item);
        inventario.adicionarItem(item2);
        inventario.removerItem(item);
        assertFalse(inventario.getItens().contains(item));
        assertTrue(inventario.getItens().contains(item2));
    }
    
    @Test
    public void removerItemSemTerAdicionalo(){
        Inventario inventario = new Inventario();
        Item item = new Item("item", 1);
        inventario.removerItem(item);
        assertFalse(inventario.getItens().contains(item));
    }    
    
    @Test
    public void getDescricoesItensComVariosItens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 14));
        inventario.adicionarItem(new Item("Escudo", 2));
        inventario.adicionarItem(new Item("Bracelete", 56));
        assertEquals("Adaga, Escudo, Bracelete", inventario.getDescricoesItens());
    }
    
    @Test
    public void getDescricoesItensComApenasUmItem() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Bracelete", 30));
        assertEquals("Bracelete", inventario.getDescricoesItens());
    }
    
    @Test
    public void getDescricoesItensSemItens() {
        Inventario inventario = new Inventario();
        assertEquals("", inventario.getDescricoesItens());
    }
    
    @Test
    public void aumentarUnidadeSemItens() {
        Inventario inventario = new Inventario();
        inventario.aumentarUnidadesDosItens(1000);
        assertEquals(0, inventario.getItens().size());
    }
    
    @Test
    public void itemComMaiorQuantidadeCom3ItensDeQuantidadesIguais() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 2));
        inventario.adicionarItem(new Item("Poção polissuco", 2));
        inventario.adicionarItem(new Item("Lucky egg", 2));
        Item item = inventario.itemMaiorQuantidade();
        assertEquals("Espada de aço", item.getDescricao());
        assertEquals(2, item.getQuantidade());
    }
    
    @Test
    public void ordenarDescendente2Itens(){
        Elfo novoElfo = new Elfo("ed");
        
        novoElfo.getInventario().ordenar(TipoOrdenacao.DESCENDENTE);
        
        assertEquals(42, novoElfo.getInventario().getItens().get(0).getQuantidade());
        assertEquals(1, novoElfo.getInventario().getItens().get(1).getQuantidade());
    }
    
        @Test
    public void ordenarDescendente4Itens(){
        Elfo novoElfo = new Elfo("ed");
        
        novoElfo.adicionarItem(new Item("Pistola", 20));
        novoElfo.adicionarItem(new Item("Revólver", 38));
                
        novoElfo.getInventario().ordenar(TipoOrdenacao.DESCENDENTE);
        
        assertEquals(42, novoElfo.getInventario().getItens().get(0).getQuantidade());
        assertEquals(38, novoElfo.getInventario().getItens().get(1).getQuantidade());
        assertEquals(20, novoElfo.getInventario().getItens().get(2).getQuantidade());
        assertEquals(1, novoElfo.getInventario().getItens().get(3).getQuantidade());
    }
    
        @Test
    public void ordenarDescendenteVariosItens(){
        Elfo novoElfo = new Elfo("ed");
        
        novoElfo.adicionarItem(new Item("Pistola", 200));
        novoElfo.adicionarItem(new Item("Revólver", 300));
        novoElfo.adicionarItem(new Item("Pistola", 600));
        novoElfo.adicionarItem(new Item("Revólver", 500));
        novoElfo.adicionarItem(new Item("Pistola", 100));
        novoElfo.adicionarItem(new Item("Revólver", 400));
        novoElfo.adicionarItem(new Item("Pistola", 50));
        novoElfo.adicionarItem(new Item("Revólver", 800));
        novoElfo.adicionarItem(new Item("Pistola", 900));
        novoElfo.adicionarItem(new Item("Revólver", 700));
        
        novoElfo.getInventario().ordenar(TipoOrdenacao.DESCENDENTE);
        
        assertEquals(1, novoElfo.getInventario().getItens().get(11).getQuantidade());
        assertEquals(42, novoElfo.getInventario().getItens().get(10).getQuantidade());
        assertEquals(50, novoElfo.getInventario().getItens().get(9).getQuantidade());
        assertEquals(100, novoElfo.getInventario().getItens().get(8).getQuantidade());
        assertEquals(200, novoElfo.getInventario().getItens().get(7).getQuantidade());
        assertEquals(300, novoElfo.getInventario().getItens().get(6).getQuantidade());
        assertEquals(400, novoElfo.getInventario().getItens().get(5).getQuantidade());
        assertEquals(500, novoElfo.getInventario().getItens().get(4).getQuantidade());
        assertEquals(600, novoElfo.getInventario().getItens().get(3).getQuantidade());
        assertEquals(700, novoElfo.getInventario().getItens().get(2).getQuantidade());
        assertEquals(800, novoElfo.getInventario().getItens().get(1).getQuantidade());
        assertEquals(900, novoElfo.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void ordenarAscendente4Itens(){
        Elfo novoElfo = new Elfo("ed");
        
        novoElfo.adicionarItem(new Item("Pistola", 20));
        novoElfo.adicionarItem(new Item("Revólver", 38));
                
        novoElfo.getInventario().ordenar(TipoOrdenacao.ASCENDENTE);
        
        assertEquals(1, novoElfo.getInventario().getItens().get(0).getQuantidade());
        assertEquals(20, novoElfo.getInventario().getItens().get(1).getQuantidade());
        assertEquals(38, novoElfo.getInventario().getItens().get(2).getQuantidade());
        assertEquals(42, novoElfo.getInventario().getItens().get(3).getQuantidade());
    }
    
    @Test
    public void ordenarAscendenteMuitosItens(){
        Elfo novoElfo = new Elfo("ed");
        
        novoElfo.adicionarItem(new Item("Pistola", 20));
        novoElfo.adicionarItem(new Item("Revólver", 38));
        novoElfo.adicionarItem(new Item("Pistola", 200));
        novoElfo.adicionarItem(new Item("Revólver", 300));
        novoElfo.adicionarItem(new Item("Pistola", 600));
        novoElfo.adicionarItem(new Item("Revólver", 500));
        novoElfo.adicionarItem(new Item("Pistola", 100));
        novoElfo.adicionarItem(new Item("Revólver", 400));
        novoElfo.adicionarItem(new Item("Pistola", 50));
        novoElfo.adicionarItem(new Item("Revólver", 800));
        novoElfo.adicionarItem(new Item("Pistola", 900));
        novoElfo.adicionarItem(new Item("Revólver", 700));
        
        novoElfo.getInventario().ordenar(TipoOrdenacao.ASCENDENTE);
        
        assertEquals(1, novoElfo.getInventario().getItens().get(0).getQuantidade());
        assertEquals(20, novoElfo.getInventario().getItens().get(1).getQuantidade());
        assertEquals(38, novoElfo.getInventario().getItens().get(2).getQuantidade());
        assertEquals(42, novoElfo.getInventario().getItens().get(3).getQuantidade());
        assertEquals(50, novoElfo.getInventario().getItens().get(4).getQuantidade());
        assertEquals(100, novoElfo.getInventario().getItens().get(5).getQuantidade());
        assertEquals(200, novoElfo.getInventario().getItens().get(6).getQuantidade());
        assertEquals(300, novoElfo.getInventario().getItens().get(7).getQuantidade());
        assertEquals(400, novoElfo.getInventario().getItens().get(8).getQuantidade());
        assertEquals(500, novoElfo.getInventario().getItens().get(9).getQuantidade());
        assertEquals(600, novoElfo.getInventario().getItens().get(10).getQuantidade());
        assertEquals(700, novoElfo.getInventario().getItens().get(11).getQuantidade());
        assertEquals(800, novoElfo.getInventario().getItens().get(12).getQuantidade());
        assertEquals(900, novoElfo.getInventario().getItens().get(13).getQuantidade());
    }
}
