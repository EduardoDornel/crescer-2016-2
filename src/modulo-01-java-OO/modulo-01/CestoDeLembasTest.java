

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CestoDeLembasTest
{       
    @Test
    public void podeDividirEm6(){
        CestoDeLembas cs = new CestoDeLembas(6);
        
        assertTrue(cs.podeDividirEmPares());
    }
    
     @Test
    public void naoPodeDividirEm2(){
        CestoDeLembas cs = new CestoDeLembas(2);
        
        assertFalse(cs.podeDividirEmPares());
    }
    
     @Test
    public void naoPodeDividirEm37(){
        CestoDeLembas cs = new CestoDeLembas(37);
        
        assertFalse(cs.podeDividirEmPares());
    }
    
     @Test
    public void podeDividirEm44(){
        CestoDeLembas cs = new CestoDeLembas(44);
        
        assertTrue(cs.podeDividirEmPares());
    }
    
    @Test
    public void dividirCestoComMenos6Paes() {
        CestoDeLembas cesto = new CestoDeLembas(-6);
        
        assertFalse(cesto.podeDividirEmPares());
    }
}
