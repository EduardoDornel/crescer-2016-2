
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ExercitoDeElfosTest
{
    @Test
    public void exercitoDeElfoNasceComArrayListZerado(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        assertEquals(0, exercito.getBatalhao().size());
    }
    
    @Test
    public void alistarElfoVerde()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo green = new ElfoVerde("elfo verde");
        
        exercito.alistarElfo(green);
        
        assertEquals(green, exercito.getBatalhao().get(0));
    }
    
    @Test
    public void alistarElfoNoturno()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo dark = new ElfoNoturno("noturnos");
        
        exercito.alistarElfo(dark);
        
        assertEquals(dark, exercito.getBatalhao().get(0));    
    }
    
    @Test(expected=NaoPodeAlistarException.class)
    public void alistarElfoNormal()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo elfo = new Elfo("elfo");
        
        exercito.alistarElfo(elfo);
        
        assertEquals(0, exercito.getBatalhao().size());    
    }
    
    @Test(expected=NaoPodeAlistarException.class)
    public void alistarMuitosElfos()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo elfo = new Elfo("elfo");
        Elfo dark = new ElfoNoturno("noturnos");
        Elfo green = new ElfoVerde("elfo verde");
        Elfo dark2 = new ElfoNoturno("noturnos2");
        Elfo elfo2 = new Elfo("elfo");
        Elfo green2 = new ElfoVerde("elfo verde2");   
        
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(dark2);   
        exercito.alistarElfo(dark);
        exercito.alistarElfo(green);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(green2);
        
        assertEquals(4, exercito.getBatalhao().size());
    }
    
    @Test(expected=NaoPodeAlistarException.class)
    public void buscarPorNomeExistente()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo elfo = new Elfo("elfo");
        Elfo dark = new ElfoNoturno("noturnos");
        Elfo green = new ElfoVerde("elfo verde");
        Elfo dark2 = new ElfoNoturno("noturnos2");
        Elfo elfo2 = new Elfo("elfo");
        Elfo green2 = new ElfoVerde("elfo verde2");   
        
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(dark2);   
        exercito.alistarElfo(dark);
        exercito.alistarElfo(green);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(green2);
        
        assertEquals(dark, exercito.buscarPeloNome("noturnos"));
        assertEquals(dark2, exercito.buscarPeloNome("noturnos2"));
        assertEquals(green, exercito.buscarPeloNome("elfo verde"));
        assertEquals(green2, exercito.buscarPeloNome("elfo verde2"));
    }
    
    @Test(expected=NaoPodeAlistarException.class)
    public void buscarNomeNaoExistente()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo elfo = new Elfo("elfo");
        Elfo dark = new ElfoNoturno("noturnos");
        Elfo green = new ElfoVerde("elfo verde");
        Elfo dark2 = new ElfoNoturno("noturnos");
        Elfo elfo2 = new Elfo("elfo");
        Elfo green2 = new ElfoVerde("elfo verde");   
        
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(dark2);   
        exercito.alistarElfo(dark);
        exercito.alistarElfo(green);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(green2);
        
        assertNull(exercito.buscarPeloNome("jose"));
    }
    
    @Test(expected=NaoPodeAlistarException.class)
    public void buscarPorStatusVivo()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo elfo = new Elfo("elfo");
        Elfo dark = new ElfoNoturno("noturnos");
        Elfo green = new ElfoVerde("elfo verde");
        Elfo dark2 = new ElfoNoturno("noturnos");
        Elfo elfo2 = new Elfo("elfo");
        Elfo green2 = new ElfoVerde("elfo verde");   
        
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(dark2);   
        exercito.alistarElfo(dark);
        exercito.alistarElfo(green);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(green2);
        
        assertEquals(exercito.getBatalhao(), exercito.buscar(Status.VIVO));
    }
    
    @Test
    public void buscarPorStatusMorto()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo dark = new ElfoNoturno("noturnos", 110);
        Elfo green = new ElfoVerde("elfo verde");
        
        exercito.alistarElfo(dark);
        exercito.alistarElfo(green);
        for(int i = 0; 90 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(dark, exercito.buscar(Status.MORTO).get(0));
    }
    
    @Test
    public void buscarVivoSeSohTemMorto()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo dark = new ElfoNoturno("noturnos", 110);
        exercito.alistarElfo(dark); 
        
        for(int i = 0; 90 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf")); 
            
        assertEquals(0, exercito.buscar(Status.VIVO).size());            
    }
    
    @Test
    public void buscarMortoSeSohTemVivo()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo dark = new ElfoNoturno("noturnos", 110);
        exercito.alistarElfo(dark); 
            
        assertEquals(0, exercito.buscar(Status.MORTO).size()); 
    }
    
    @Test
    public void ordenarAtaqueElfoVerdePrimeiroElfoNoturnoPorUltimoVariosElfos() throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();

        for(int i = 0; i < 20; i++){
            if(i % 2 == 0)
                exercito.alistarElfo(new ElfoVerde("elfo verde"));
            else
                exercito.alistarElfo(new ElfoNoturno("elfo noturno"));                
        }
        
        List<Elfo> exercitoOrdenado = new ArrayList<>();
        
        exercitoOrdenado = exercito.getOrdemDeAtaque(exercito.getBatalhao());
        
        assertTrue(exercitoOrdenado.get(0) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(1) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(2) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(3) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(4) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(5) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(6) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(7) instanceof ElfoVerde);        
        assertTrue(exercitoOrdenado.get(8) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(9) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(10) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(11) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(12) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(13) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(14) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(15) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(16) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(17) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(18) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(19) instanceof ElfoNoturno);
    }
    
    @Test
    public void ordenarAtaqueElfoVerdePrimeiroElfoNoturnoPorUltimoUmElfoPraCadaLado() throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        exercito.alistarElfo(new ElfoNoturno("elfo noturno"));      
        exercito.alistarElfo(new ElfoVerde("elfo verde"));
        
        List<Elfo> exercitoOrdenado = new ArrayList<>();
        
        exercitoOrdenado = exercito.getOrdemDeAtaque(exercito.getBatalhao());
        
        assertTrue(exercitoOrdenado.get(0) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(1) instanceof ElfoNoturno);
    } 
    
    @Test
    public void ordenarAtaqueIntercaladamenteCom4Elfos()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();        
        
        exercito.alistarElfo(new ElfoNoturno("elfo noturno"));      
        exercito.alistarElfo(new ElfoVerde("elfo verde"));
        exercito.alistarElfo(new ElfoNoturno("elfo noturno"));      
        exercito.alistarElfo(new ElfoVerde("elfo verde"));
        
        List<Elfo> exercitoOrdenado = new ArrayList<>();
        exercitoOrdenado = exercito.ataqueIntercalado(exercito.getBatalhao());
        
        assertTrue(exercitoOrdenado.get(0) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(1) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(2) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(3) instanceof ElfoNoturno);        
    }
    
    @Test
    public void ordenarAtaqueIntercaladamenteComVariosElfos()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();        
        

        exercito.alistarElfo(new ElfoVerde("elfo Verde"));  
        exercito.alistarElfo(new ElfoNoturno("elfo Noturno"));        
        exercito.alistarElfo(new ElfoNoturno("elfo noturno"));      
        exercito.alistarElfo(new ElfoVerde("elfo verde"));
        exercito.alistarElfo(new ElfoNoturno("elfo noturno"));      
        exercito.alistarElfo(new ElfoVerde("elfo verde"));
        exercito.alistarElfo(new ElfoNoturno("elfo Noturno"));        
        exercito.alistarElfo(new ElfoNoturno("elfo noturno"));        
        exercito.alistarElfo(new ElfoVerde("elfo Verde"));          
        exercito.alistarElfo(new ElfoVerde("elfo Verde"));          
        exercito.alistarElfo(new ElfoVerde("elfo Verde")); 
        exercito.alistarElfo(new ElfoNoturno("elfo noturno")); 
        exercito.alistarElfo(new ElfoVerde("elfo Verde"));          
        exercito.alistarElfo(new ElfoVerde("elfo Verde"));          
        exercito.alistarElfo(new ElfoVerde("elfo Verde")); 
        exercito.alistarElfo(new ElfoVerde("elfo verde"));
        exercito.alistarElfo(new ElfoNoturno("elfo Noturno"));        
        exercito.alistarElfo(new ElfoNoturno("elfo noturno"));        
        exercito.alistarElfo(new ElfoNoturno("elfo Noturno"));        
        exercito.alistarElfo(new ElfoNoturno("elfo noturno")); 
        
        
        List<Elfo> exercitoOrdenado = new ArrayList<>();
        exercitoOrdenado = exercito.ataqueIntercalado(exercito.getBatalhao());
        
        assertTrue(exercitoOrdenado.get(0) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(1) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(2) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(3) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(4) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(5) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(6) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(7) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(8) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(9) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(10) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(11) instanceof ElfoNoturno);  
        assertTrue(exercitoOrdenado.get(12) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(13) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(14) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(15) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(16) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(17) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(18) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(19) instanceof ElfoNoturno);
    }    
    
    @Test
    public void ordenarAtaqueIntercaladamenteSemElfos()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();        
        
        List<Elfo> exercitoOrdenado = new ArrayList<>();
        exercitoOrdenado = exercito.ataqueIntercalado(exercito.getBatalhao());
        
        assertEquals(0, exercitoOrdenado.size());      
    }
    
    @Test
    public void ordenarAtaqueIntercaladamenteComContigenteDesproporcional()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();        
        
        exercito.alistarElfo(new ElfoNoturno("elfo noturno"));      
        exercito.alistarElfo(new ElfoVerde("elfo verde"));
        exercito.alistarElfo(new ElfoNoturno("elfo noturno"));      
        
        List<Elfo> exercitoOrdenado = new ArrayList<>();
        exercitoOrdenado = exercito.ataqueIntercalado(exercito.getBatalhao());
        
        assertNull(exercitoOrdenado);       
    }    
    
    @Test
    public void ataqueLittleMumuCom3ElfosInaptosE5Aptos()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();                
        
        exercito.alistarElfo(new ElfoNoturno("elfo noturno", 30));      
        exercito.alistarElfo(new ElfoVerde("elfo verde", 10));
        exercito.alistarElfo(new ElfoNoturno("elfo noturno", 20));         
        exercito.alistarElfo(new ElfoVerde("elfo verde",0));      
        exercito.alistarElfo(new ElfoVerde("elfo verde", 10));
        exercito.alistarElfo(new ElfoNoturno("elfo noturno", 20));  
        exercito.alistarElfo(new ElfoVerde("greenElf", 400));
        
        List<Elfo> exercitoOrdenado = new ArrayList<>();
        exercitoOrdenado = exercito.ataqueLittleMumu(exercito.getBatalhao());     
        
        assertEquals(4, exercitoOrdenado.size());
        assertTrue(exercitoOrdenado.get(0) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(1) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(2) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(3) instanceof ElfoVerde);
    }
    
    @Test
    public void ataqueLittleMumuCom6ElfosInaptosE9Aptos()throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();  
        
        exercito.alistarElfo(new ElfoVerde("elfo verde", 10));
        exercito.alistarElfo(new ElfoNoturno("elfo noturno", 30));      
        exercito.alistarElfo(new ElfoVerde("elfo verde", 10));
        exercito.alistarElfo(new ElfoVerde("elfo verde", 50));                
        exercito.alistarElfo(new ElfoNoturno("elfo noturno", 20));         
        exercito.alistarElfo(new ElfoVerde("elfo verde",0));      
        exercito.alistarElfo(new ElfoVerde("elfo verde", 10));
        exercito.alistarElfo(new ElfoNoturno("elfo noturno", 20));  
        exercito.alistarElfo(new ElfoVerde("elfo verde", 400));
        exercito.alistarElfo(new ElfoVerde("elfo verde", 10));        
        exercito.alistarElfo(new ElfoNoturno("elfo noturno",0));      
        exercito.alistarElfo(new ElfoVerde("elfo verde", 10));
        exercito.alistarElfo(new ElfoNoturno("elfo noturno", 20));         
        
        List<Elfo> exercitoOrdenado = new ArrayList<>();
        exercitoOrdenado = exercito.ataqueLittleMumu(exercito.getBatalhao());     
        
        assertEquals(9, exercitoOrdenado.size());
        assertTrue(exercitoOrdenado.get(0) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(1) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(2) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(3) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(4) instanceof ElfoNoturno);
        assertTrue(exercitoOrdenado.get(5) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(6) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(7) instanceof ElfoVerde);
        assertTrue(exercitoOrdenado.get(8) instanceof ElfoNoturno);
    }    
}
    