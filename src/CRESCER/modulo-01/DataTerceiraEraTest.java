

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void verificarAnoMesDia(){
        DataTerceiraEra data = new DataTerceiraEra(10, 20, 2000);
        
        assertEquals(10, data.getDia());
        assertEquals(20, data.getMes());
        assertEquals(2000, data.getAno());
    }
    
    @Test
    public void verificarAnoMesDiaDeNovo(){
        DataTerceiraEra fimDaGuerraDoAnel = new DataTerceiraEra(1, 10, 3019);
        
        assertEquals(1, fimDaGuerraDoAnel.getDia());
        assertEquals(10, fimDaGuerraDoAnel.getMes());
        assertEquals(3019, fimDaGuerraDoAnel.getAno());
    }
    
    @Test
    public void verifica2000EhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(10, 20, 2000);
        
        assertTrue(data.ehBissexto());
    }
    
    @Test
    public void verifica400EhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(10, 20, 400);
        
        assertTrue(data.ehBissexto());
    }
    
    @Test
    public void verifica1900EhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(10, 20, 1900);
        
        assertFalse(data.ehBissexto());
    }
    
    @Test
    public void verifica3686EhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(10, 20, 3686);
        
        assertFalse(data.ehBissexto());
    }
}
