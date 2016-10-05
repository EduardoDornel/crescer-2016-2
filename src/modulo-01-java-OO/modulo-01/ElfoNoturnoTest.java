

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoGanha3experciencias(){
        Elfo dark = new ElfoNoturno("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(3, dark.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoGanha15experciencias(){
        Elfo dark = new ElfoNoturno("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(15, dark.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoNaoGanhaExperciencia(){
        Elfo dark = new ElfoNoturno("elfo");
        
        assertEquals(0, dark.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoPerde5PorCentoDeVida(){
        Elfo dark = new ElfoNoturno("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(95, dark.getVida(), 0.01);
    }
    
    @Test
    public void elfoNoturnoPerde15PorCentoDeVida(){
        Elfo dark = new ElfoNoturno("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(85.73, dark.getVida(), 0.01);
    }
    
    @Test
    public void elfoNoturnoLanca42Flechas(){
        Elfo dark = new ElfoNoturno("elfo");
        
        for(int i = 0; 90 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(126, dark.getExperiencia());
        assertEquals(Status.VIVO, dark.getStatus());
    }
    
    @Test
    public void elfoNoturnoMorre(){
        Elfo dark = new ElfoNoturno("elfo", 100);
        
        for(int i = 0; 90 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(270, dark.getExperiencia());
        assertEquals(Status.MORTO, dark.getStatus());
    }
    
    @Test
    public void elfoNoturnoNaoMorreCom89flechadas(){
        Elfo dark = new ElfoNoturno("elfo");
        
        for(int i = 0; 89 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(Status.VIVO, dark.getStatus());
    }
}
