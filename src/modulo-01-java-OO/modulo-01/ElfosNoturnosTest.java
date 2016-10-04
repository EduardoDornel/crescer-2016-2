

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosNoturnosTest
{
    @Test
    public void elfoNoturnoGanha3experciencias(){
        ElfosNoturnos dark = new ElfosNoturnos("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(3, dark.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoGanha15experciencias(){
        ElfosNoturnos dark = new ElfosNoturnos("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(15, dark.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoNaoGanhaExperciencia(){
        ElfosNoturnos dark = new ElfosNoturnos("elfo");
        
        assertEquals(0, dark.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoPerde5PorCentoDeVida(){
        ElfosNoturnos dark = new ElfosNoturnos("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(95, dark.getVida(), 0.01);
    }
    
    @Test
    public void elfoNoturnoPerde15PorCentoDeVida(){
        ElfosNoturnos dark = new ElfosNoturnos("elfo");
        
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));
        
        assertEquals(85.73, dark.getVida(), 0.01);
    }
    
    @Test
    public void elfoNoturnoLanca42Flechas(){
        ElfosNoturnos dark = new ElfosNoturnos("elfo");
        
        for(int i = 0; 90 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(126, dark.getExperiencia());
        assertEquals(Status.VIVO, dark.getStatus());
    }
    
    @Test
    public void elfoNoturnoMorre(){
        ElfosNoturnos dark = new ElfosNoturnos("elfo", 100);
        
        for(int i = 0; 90 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(270, dark.getExperiencia());
        assertEquals(Status.MORTO, dark.getStatus());
    }
    
    @Test
    public void elfoNoturnoNaoMorreCom89flechadas(){
        ElfosNoturnos dark = new ElfosNoturnos("elfo");
        
        for(int i = 0; 89 >= i; i++)
            dark.atirarFlechaEmDwarf(new Dwarves("dwarf"));      
        
        assertEquals(Status.VIVO, dark.getStatus());
    }
}
