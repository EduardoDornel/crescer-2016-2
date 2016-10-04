

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class IrishDwarfTest
{
    @Test
    public void irishDwarfNasceVivo(){
        Dwarves dwarf = new IrishDwarf("ed");
        
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void irishDwarfComSorte() {
        Dwarves dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 5));
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwarfQuantidadeNegativaComSorte() {
        Dwarves dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", -5));
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.tentarSorte();
        assertEquals(14995, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfComZeroQuantidadeDeUmItemComsSorte(){
        Dwarves dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 0));
         dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.tentarSorte();
        assertEquals(0, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwardSemSorte(){
        Dwarves dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 5));
        dwarf.tentarSorte();
        assertEquals(5, dwarf.getInventario().getItens().get(0).getQuantidade());
    }    

    @Test
    public void criandoDwarf(){
        Dwarves dwarf = new IrishDwarf("ed");
        
        assertEquals(110, dwarf.getVida(), 0.01);
    }
    
    @Test
    public void dwarfPerdeVida11Vezes(){
        Dwarves dwarf = new IrishDwarf("ed");
        
        for(int i = 0; 11 > i; i++)
            dwarf.perdeVida();
            
        assertEquals(0, dwarf.getVida(), 0.01);
    }
    
    @Test
    public void dwarfPerdeVida5Vezes(){
        Dwarves dwarf = new IrishDwarf("ed");
        
        for(int i = 0; 5 > i; i++)
            dwarf.perdeVida();
            
        assertEquals(60, dwarf.getVida(), 0.01);
    }
    
    @Test
    public void dwarfNasceComDataNascimento(){
        Dwarves dwarf = new IrishDwarf("", new DataTerceiraEra(1, 1, 2010));
        
        assertEquals(1, dwarf.getDataNascimento().getDia());
        assertEquals(1, dwarf.getDataNascimento().getMes());
        assertEquals(2010, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void numeroSorteRetorna101(){
         Dwarves dwarf = new IrishDwarf("", new DataTerceiraEra(1, 1, 2010));
         
         assertEquals(101.0, dwarf.getNumeroSorte(), 0.001);
    }
    
    @Test
    public void numeroSorteRetorna33(){
         Dwarves dwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1, 1, 2015));
         
         assertEquals(33.0, dwarf.getNumeroSorte(), 0.001);
    }
    
    @Test
    public void numeroSorteRetorna3333Negativo(){
        Dwarves dwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1, 1, 2016));
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        
        assertEquals(-3333.0, dwarf.getNumeroSorte(), 0.001);
    }
    
    @Test
    public void numeroSorteRetorna101DeNovo(){
        Dwarves dwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1, 1, 2016));
        
        assertEquals(101.0, dwarf.getNumeroSorte(), 0.001);
    }
    
    @Test
    public void dwarfNasceVivo(){
        Dwarves dwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1, 1, 2016));
        
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfNasceVivoSemPassarParametros(){
        Dwarves dwarf = new IrishDwarf("ed");
        
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfMorreNaDecimaPrimeiraFlechada(){
        Dwarves dwarf = new IrishDwarf("ed");      
        
        for(int i =0; 11 >= i; i++)
            dwarf.perdeVida();
            
        assertEquals(Status.MORTO, dwarf.getStatus());            
    }
    
        @Test
    public void dwarfGanhaZeroExperiencia(){
        Dwarves dwarf = new IrishDwarf("dwarf", new DataTerceiraEra(1, 1, 1900));
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        
        assertEquals(0, dwarf.getExperiencia());        
    }
    
    @Test
    public void dwarfGanhaDuasExperiencias(){
        Dwarves dwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1, 1, 2016));
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        
        assertEquals(2, dwarf.getExperiencia());        
    }
    
    @Test
    public void dwarfGanhaQuatroExperiencias(){
        Dwarves dwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1, 1, 2016));
        
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        
        assertEquals(4, dwarf.getExperiencia());          
    }
    
    @Test
    public void dwarfNaoGanhaSorte(){
        Dwarves dwarf = new IrishDwarf("dwarf", new DataTerceiraEra(10, 10, 2016));
        dwarf.adicionarItem(new Item("moedas",10));
        dwarf.adicionarItem(new Item("pocao", 3));
        
        dwarf.tentarSorte();
        
        assertEquals(10, dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(3, dwarf.getInventario().getItens().get(1).getQuantidade());
    }    
}
