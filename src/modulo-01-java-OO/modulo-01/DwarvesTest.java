

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarvesTest
{
  
    @Test
    public void VerificarVidaDwarf(){
        Dwarves dwarf = new Dwarves();
        
        assertEquals(110, dwarf.getVida());
    }
}
