

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ExercitoDeElfosTest
{
    @Test
    public void exercitoDeElfoNasceComArrayListZerado(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        assertEquals(0, exercito.getListaElfos().size());
    }
    
    @Test
    public void alistarElfoVerde(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo green = new ElfosVerdes("elfo verde");
        
        exercito.alistarElfo(green);
        
        assertEquals(green, exercito.getListaElfos().get(0));
    }
    
    @Test
    public void alistarElfoNoturno(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo dark = new ElfosNoturnos("noturnos");
        
        exercito.alistarElfo(dark);
        
        assertEquals(dark, exercito.getListaElfos().get(0));    
    }
    
    @Test
    public void alistarElfoNormal(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo elfo = new Elfo("elfo");
        
        exercito.alistarElfo(elfo);
        
        assertEquals(0, exercito.getListaElfos().size());    
    }
    
    @Test
    public void alistarMuitosElfos(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo elfo = new Elfo("elfo");
        ElfosNoturnos dark = new ElfosNoturnos("noturnos");
        ElfosVerdes green = new ElfosVerdes("elfo verde");
        ElfosNoturnos dark2 = new ElfosNoturnos("noturnos2");
        Elfo elfo2 = new Elfo("elfo");
        ElfosVerdes green2 = new ElfosVerdes("elfo verde2");   
        
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(dark2);   
        exercito.alistarElfo(dark);
        exercito.alistarElfo(green);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(green2);
        
        assertEquals(4, exercito.getListaElfos().size());
    }
    
    @Test
    public void buscarPorNomeExistente(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo elfo = new Elfo("elfo");
        Elfo dark = new ElfosNoturnos("noturnos");
        Elfo green = new ElfosVerdes("elfo verde");
        Elfo dark2 = new ElfosNoturnos("noturnos2");
        Elfo elfo2 = new Elfo("elfo");
        Elfo green2 = new ElfosVerdes("elfo verde2");   
        
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
    
    @Test
    public void buscarNomeNaoExistente(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo elfo = new Elfo("elfo");
        ElfosNoturnos dark = new ElfosNoturnos("noturnos");
        ElfosVerdes green = new ElfosVerdes("elfo verde");
        ElfosNoturnos dark2 = new ElfosNoturnos("noturnos");
        Elfo elfo2 = new Elfo("elfo");
        ElfosVerdes green2 = new ElfosVerdes("elfo verde");   
        
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(dark2);   
        exercito.alistarElfo(dark);
        exercito.alistarElfo(green);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(green2);
        
        assertNull(exercito.buscarPeloNome("jose"));
    }
    
    @Test
    public void buscarPorStatusVivo(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();       
        Elfo elfo = new Elfo("elfo");
        ElfosNoturnos dark = new ElfosNoturnos("noturnos");
        ElfosVerdes green = new ElfosVerdes("elfo verde");
        ElfosNoturnos dark2 = new ElfosNoturnos("noturnos");
        Elfo elfo2 = new Elfo("elfo");
        ElfosVerdes green2 = new ElfosVerdes("elfo verde");   
        
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(dark2);   
        exercito.alistarElfo(dark);
        exercito.alistarElfo(green);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(green2);
        
        assertEquals(exercito.getListaElfos(), exercito.buscar(Status.VIVO));
    }
    
    @Test
    public void buscarPorStatusMorto(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfosNoturnos dark = new ElfosNoturnos("noturnos", 110);
        ElfosVerdes green = new ElfosVerdes("elfo verde");
        
        exercito.alistarElfo(dark);
        exercito.alistarElfo(green);
        for(int i = 0; 90 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(dark, exercito.buscar(Status.MORTO).get(0));
    }
}
    