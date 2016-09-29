

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
    public void dwarfPerdeVida5Vezes(){
        Dwarves dwarf = new Dwarves();
        
        for(int i = 0; 5 > i; i++)
            dwarf.perdeVida();
            
        assertEquals(60, dwarf.getVida());
    }
    
    @Test
    public void dwarfNasceComDataNascimento(){
        Dwarves dwarf = new Dwarves("", new DataTerceiraEra(1, 1, 2010));
        
        assertEquals(1, dwarf.getDataNascimento().getDia());
        assertEquals(1, dwarf.getDataNascimento().getMes());
        assertEquals(2010, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void numeroSorteRetorna101(){
         Dwarves dwarf = new Dwarves("", new DataTerceiraEra(1, 1, 2010));
         
         assertEquals(101.0, dwarf.getNumeroSorte(), 0.001);
    }
    
    @Test
    public void numeroSorteRetorna33(){
         Dwarves dwarf = new Dwarves("Seixas", new DataTerceiraEra(1, 1, 2015));
         
         assertEquals(33.0, dwarf.getNumeroSorte(), 0.001);
    }
    
    @Test
    public void numeroSorteRetorna3333Negativo(){
        Dwarves dwarf = new Dwarves("Seixas", new DataTerceiraEra(1, 1, 2016));
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        
        assertEquals(-3333.0, dwarf.getNumeroSorte(), 0.001);
    }
    
    @Test
    public void numeroSorteRetorna101DeNovo(){
        Dwarves dwarf = new Dwarves("Seixas", new DataTerceiraEra(1, 1, 2016));
        
        assertEquals(101.0, dwarf.getNumeroSorte(), 0.001);
    }
    
    @Test
    public void dwarfNasceVivo(){
        Dwarves dwarf = new Dwarves("Seixas", new DataTerceiraEra(1, 1, 2016));
        
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfNasceVivoSemPassarParametros(){
        Dwarves dwarf = new Dwarves();
        
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfMorreNaDecimaPrimeiraFlechada(){
        Dwarves dwarf = new Dwarves();      
        
        for(int i =0; 11 >= i; i++)
            dwarf.perdeVida();
            
        assertEquals(Status.MORTO, dwarf.getStatus());            
    }
    
    @Test
    public void dwarfGanhaDuasExperiencias(){
        Dwarves dwarf = new Dwarves("Seixas", new DataTerceiraEra(1, 1, 2016));
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        
        assertEquals(2, dwarf.getExperiencia());        
    }
    
    @Test
    public void dwarfGanhaQuatroExperiencias(){
        Dwarves dwarf = new Dwarves("Seixas", new DataTerceiraEra(1, 1, 2016));
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        
        assertEquals(4, dwarf.getExperiencia());          
    }
}

