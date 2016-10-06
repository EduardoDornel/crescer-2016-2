
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class BatalhaoDeElfosTest
{
    @Test
    public void obterHashMapDeElfos(){
        HashMap<String, Elfo> mapElfos = new HashMap<>();
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        assertEquals(mapElfos, batalhao.getBatalhao());
    }
    
    @Test
    public void alistarUmElfo(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        Elfo greenElf = new ElfoVerde("josefino");
        
        batalhao.alistarElfo(greenElf);
        
        assertTrue(batalhao.getBatalhao().containsValue(greenElf));
        assertEquals(1, batalhao.getBatalhao().size());
    }
    
    @Test
    public void alistarDoisElfos(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        Elfo greenElf = new ElfoVerde("josefino");
        Elfo darkElf = new ElfoNoturno("josias");
        
        batalhao.alistarElfo(greenElf);
        batalhao.alistarElfo(darkElf);
        assertTrue(batalhao.getBatalhao().containsValue(greenElf));
        assertTrue(batalhao.getBatalhao().containsValue(darkElf));        
        assertEquals(2, batalhao.getBatalhao().size());
    }    
    
    @Test
    public void elfoNormalNaoSeraAlistado(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        Elfo elfo = new Elfo("normal elfo");        
        
        batalhao.alistarElfo(elfo);
        
        assertFalse(batalhao.getBatalhao().containsValue(elfo));
        assertTrue(batalhao.getBatalhao().isEmpty());
        assertEquals(0, batalhao.getBatalhao().size());    
    }
    
    @Test
    public void buscarNomeExistente(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        Elfo greenElf = new ElfoVerde("josefino");
        
        batalhao.alistarElfo(greenElf);
        
        assertEquals(greenElf, batalhao.buscar("josefino"));    
    }
    
    @Test
    public void alistarNomeIgualSobrescreve(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        Elfo greenElf = new ElfoVerde("josefino", 30);
        Elfo greenElf2 = new ElfoVerde("josefino", 45);
        
        batalhao.alistarElfo(greenElf);
        batalhao.alistarElfo(greenElf2);
        
        assertEquals(greenElf2, batalhao.buscar("josefino"));    
        assertEquals(45, batalhao.buscar("josefino").getInventario().getItens().get(1).getQuantidade());            
    } 
    
    @Test
    public void buscarNomeNaoExistente(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        
        assertEquals(null, batalhao.buscar("josefino"));       
    }
    
    @Test
    public void buscarElfoPorStatusVivo(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        Elfo greenElf = new ElfoVerde("josefino");
        Elfo darkElf = new ElfoNoturno("josias");
        
        batalhao.alistarElfo(greenElf);
        batalhao.alistarElfo(darkElf);
        
        HashMap<String, Elfo> batalhaoDeVivos = batalhao.buscar(Status.VIVO);    
        assertEquals(2, batalhaoDeVivos.size());
    }
    
    @Test
    public void buscarElfoPorStatusMorto(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        Elfo darkElf = new ElfoNoturno("josefino", 100);
            
        batalhao.alistarElfo(darkElf);
                
        for(int i = 0; 90 >= i; i++)
            darkElf.atirarFlechaEmDwarf(new Dwarves("dwarf"));  
        
        HashMap<String, Elfo> batalhaoDeVivos = batalhao.buscar(Status.MORTO);    
        assertEquals(1, batalhaoDeVivos.size());
    } 
    
    @Test
    public void buscarElfoSeNaoTemElfo(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        
        HashMap<String, Elfo> batalhaoDeVivos = batalhao.buscar(Status.VIVO);    
        assertTrue(batalhaoDeVivos.isEmpty());
    }     
}
