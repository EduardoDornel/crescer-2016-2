

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CestoDeLembasTest
{   
    @Test
    public void podeDividirEm6(){
        CestoDeLembas cs = new CestoDeLembas(6);
        
        assertEquals(true, cs.podeDividirEmPares());
    }
    
     @Test
    public void naoPodeDividirEm2(){
        CestoDeLembas cs = new CestoDeLembas(2);
        
        assertEquals(false, cs.podeDividirEmPares());
    }
    
     @Test
    public void naoPodeDividirEm37(){
        CestoDeLembas cs = new CestoDeLembas(37);
        
        assertEquals(false, cs.podeDividirEmPares());
    }
    
     @Test
    public void podeDividirEm44(){
        CestoDeLembas cs = new CestoDeLembas(44);
        
        assertEquals(true, cs.podeDividirEmPares());
    }
}
