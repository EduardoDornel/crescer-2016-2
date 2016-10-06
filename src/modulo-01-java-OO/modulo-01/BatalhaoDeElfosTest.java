
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
        Elfo greenElf = new ElfoVerde("josefino");
        Elfo elfo = new Elfo("normal elfo");        
        Elfo darkElf = new ElfoNoturno("josias");
        
        batalhao.alistarElfo(greenElf);
        batalhao.alistarElfo(elfo);
        batalhao.alistarElfo(darkElf);
        
        assertFalse(batalhao.getBatalhao().containsValue(elfo));
        assertTrue(batalhao.getBatalhao().containsValue(greenElf));
        assertTrue(batalhao.getBatalhao().containsValue(darkElf));        
        assertEquals(2, batalhao.getBatalhao().size());    
    }
    
    public void buscarNomeExistente(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        Elfo greenElf = new ElfoVerde("josefino");
        
        batalhao.alistarElfo(greenElf);
        
        assertEquals(greenElf, batalhao.buscar("josefino 0"));    
    }
    
    public void alistarNomeIgualNaoSobrescreve(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        Elfo greenElf = new ElfoVerde("josefino");
        Elfo greenElf2 = new ElfoVerde("josefino");
        
        batalhao.alistarElfo(greenElf);
        batalhao.alistarElfo(greenElf2);
        
        assertEquals(greenElf, batalhao.buscar("josefino 0"));    
        assertEquals(greenElf2, batalhao.buscar("josefino 1"));            
    } 
    
    public void buscarNomeNaoExistente(){
        BatalhaoDeElfos batalhao = new BatalhaoDeElfos();
        
        assertEquals(null, batalhao.buscar("josefino 0"));       
    }
}
