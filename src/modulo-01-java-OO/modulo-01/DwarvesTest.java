

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarvesTest
{
  
    @Test
    public void criandoDwarf(){
        Dwarves dwarf = new Dwarves();
        
        assertEquals(110, dwarf.getVida());
    }
    
    @Test
    public void dwarfPerdeVida11Vezes(){
        Dwarves dwarf = new Dwarves();
        
        for(int i = 0; 11 > i; i++)
            dwarf.perdeVida();
            
        assertEquals(0, dwarf.getVida());
    }
    
    @Test
    public void dwarfMorreu(){
        Dwarves dwarf = new Dwarves();
        
        for(int i = 0; 15 > i; i++)
            dwarf.perdeVida();
            
        assertEquals(0, dwarf.getVida());
        assertFalse(dwarf.isVivo());
    }
    
    @Test
    public void dwarfPerdeVida5Vezes(){
        Dwarves dwarf = new Dwarves();
        
        for(int i = 0; 5 > i; i++)
            dwarf.perdeVida();
            
        assertEquals(60, dwarf.getVida());
        assertTrue(dwarf.isVivo());
    }
}

