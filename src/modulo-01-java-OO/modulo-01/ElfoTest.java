
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome(){
        //Arrange
        String nomeEsperado = "Bruce Wayne";
        //Act
        Elfo elfoDoTeste = new Elfo(nomeEsperado);
        //Assert
        assertEquals(nomeEsperado, elfoDoTeste.getNome());
    }
    
    @Test
    public void elfoNasceComArco(){
        Item arco = new Item("Arco", 1);
        
        Elfo elfoDoTeste = new Elfo("Elrond");
        
        assertEquals(arco.getDescricao(), elfoDoTeste.getArco().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }
    
    @Test
    public void elfoNasceComFlechas(){
        Item flecha = new Item("Flechas", 42);
        
        Elfo elfoDoTeste = new Elfo("exemplo");
        
        assertEquals(flecha.getDescricao(), elfoDoTeste.getFlecha().getDescricao());
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void atirarUmaFlechaGanhaExperiencia(){
        Elfo elfoTeste = new Elfo("Exemplo");
        
        elfoTeste.atiraFlecha();
        
        assertEquals(41, elfoTeste.getFlecha().getQuantidade());
        assertEquals(1, elfoTeste.getExperiencia());
    }
    
    @Test
    public void atirarTodasFlechasGanhaExperiencia(){
        Elfo elfoTeste = new Elfo("Exemplo");
        for(int i = 0; 42 > i; i++)
            elfoTeste.atiraFlecha();
            
        assertEquals(0, elfoTeste.getFlecha().getQuantidade());
        assertEquals(42, elfoTeste.getExperiencia());
    }
    
    @Test
    public void tentarAtirarFlechasZerado(){
        Elfo elfoTeste = new Elfo("Exemplo");
        for(int i = 0; 45 > i; i++)
            elfoTeste.atiraFlecha();
            
        assertEquals(0, elfoTeste.getFlecha().getQuantidade());
        assertEquals(42, elfoTeste.getExperiencia());
    }
    
    @Test
    public void atirarFlechaNoDwarf(){
        Dwarves dwarf = new Dwarves();
        Elfo elfoTeste = new Elfo("Exemplo");        
        elfoTeste.atirarFlechaEmAnao(dwarf);
        
        assertEquals(100, dwarf.getVida());
        assertEquals(41, elfoTeste.getFlecha().getQuantidade());
        assertEquals(1, elfoTeste.getExperiencia());
    }
    
    @Test
    public void dwarfSemvida(){
        Dwarves dwarf = new Dwarves();
        Elfo elfoTeste = new Elfo("Exemplo");
        for(int i = 0; 11 > i; i++)
            elfoTeste.atirarFlechaEmAnao(dwarf);
        
        assertEquals(0, dwarf.getVida());
        assertEquals(31, elfoTeste.getFlecha().getQuantidade());
        assertEquals(11, elfoTeste.getExperiencia());
    }
    
    @Test
    public void atirarFlechasEmVariosDwarves(){
        Dwarves dwarf = new Dwarves();
        Dwarves dwarf2 = new Dwarves();
        Elfo elfoTeste = new Elfo("Exemplo");
        
        for(int i = 0; 7 > i; i++){
            elfoTeste.atirarFlechaEmAnao(dwarf);
            if(i < 4)
                elfoTeste.atirarFlechaEmAnao(dwarf2);
        }
        
        assertEquals(40, dwarf.getVida());
        assertEquals(70, dwarf2.getVida());
        assertEquals(11, elfoTeste.getExperiencia());
        assertEquals(31, elfoTeste.getFlecha().getQuantidade());
    }
}