

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoGanha3experciencias(){
        ElfoNoturno dark = new ElfoNoturno("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(3, dark.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoGanha15experciencias(){
        ElfoNoturno dark = new ElfoNoturno("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(15, dark.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoNaoGanhaExperciencia(){
        ElfoNoturno dark = new ElfoNoturno("elfo");
        
        assertEquals(0, dark.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoPerde5PorCentoDeVida(){
        ElfoNoturno dark = new ElfoNoturno("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(95, dark.getVida(), 0.01);
    }
    
    @Test
    public void elfoNoturnoPerde15PorCentoDeVida(){
        ElfoNoturno dark = new ElfoNoturno("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(85.73, dark.getVida(), 0.01);
    }
    
    @Test
    public void elfoNoturnoLanca42Flechas(){
        ElfoNoturno dark = new ElfoNoturno("elfo");
        
        for(int i = 0; 90 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(126, dark.getExperiencia());
        assertEquals(Status.VIVO, dark.getStatus());
    }
    
    @Test
    public void elfoNoturnoMorre(){
        ElfoNoturno dark = new ElfoNoturno("elfo", 100);
        
        for(int i = 0; 90 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(270, dark.getExperiencia());
        assertEquals(Status.MORTO, dark.getStatus());
    }
    
    @Test
    public void elfoNoturnoNaoMorreCom89flechadas(){
        ElfoNoturno dark = new ElfoNoturno("elfo");
        
        for(int i = 0; 89 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(Status.VIVO, dark.getStatus());
    }
}
