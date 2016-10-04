
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
        Elfo elfoDoTeste = new Elfo("Elrond");
        
        assertEquals(elfoDoTeste.getInventario().getItens().get(0).getDescricao(), "arco");
        assertEquals(1, elfoDoTeste.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void elfoNasceComFlechas(){
        Item flecha = new Item("flechas", 42);
        
        Elfo elfoDoTeste = new Elfo("exemplo");
        
        assertEquals(flecha.getDescricao(), elfoDoTeste.getInventario().getItens().get(1).getDescricao());
        assertEquals(42, elfoDoTeste.getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void atirarUmaFlechaGanhaExperiencia(){
        Elfo elfoTeste = new Elfo("Exemplo");
        Dwarves dwarf = new Dwarves("dwarf");
        
        elfoTeste.atirarFlechaEmDwarf(dwarf);
        
        assertEquals(41, elfoTeste.getInventario().getItens().get(1).getQuantidade());
        assertEquals(1, elfoTeste.getExperiencia());
    }
    
    @Test
    public void atirarTodasFlechasGanhaExperiencia(){
        Elfo elfoTeste = new Elfo("Exemplo");
        Dwarves dwarf = new Dwarves("dwarf");
        Dwarves dwarf2 = new Dwarves("dwarf");
        Dwarves dwarf3 = new Dwarves("dwarf");
        Dwarves dwarf4 = new Dwarves("dwarf");
        
        for(int i = 0; 42 > i; i++){
             elfoTeste.atirarFlechaEmDwarf(dwarf);
             elfoTeste.atirarFlechaEmDwarf(dwarf2);
             elfoTeste.atirarFlechaEmDwarf(dwarf3);
             elfoTeste.atirarFlechaEmDwarf(dwarf4);
        }
            
        assertEquals(0, elfoTeste.getInventario().getItens().get(1).getQuantidade());
        assertEquals(42, elfoTeste.getExperiencia());
    }
    
    @Test
    public void atirarFlechaNoDwarf(){
        Dwarves dwarf = new Dwarves("dwarf");
        Elfo elfoTeste = new Elfo("Exemplo");        
        elfoTeste.atirarFlechaEmDwarf(dwarf);
        
        assertEquals(100, dwarf.getVida(), 0.01);
        assertEquals(41, elfoTeste.getInventario().getItens().get(1).getQuantidade());
        assertEquals(1, elfoTeste.getExperiencia());
    }
    
    @Test
    public void dwarfSemvida(){
        Dwarves dwarf = new Dwarves("dwarf");
        Elfo elfoTeste = new Elfo("Exemplo");
        for(int i = 0; 11 > i; i++)
             elfoTeste.atirarFlechaEmDwarf(dwarf);
        
        assertEquals(0, dwarf.getVida(), 0.01);
        assertEquals(31, elfoTeste.getInventario().getItens().get(1).getQuantidade());
        assertEquals(11, elfoTeste.getExperiencia());
    }
    
    @Test
    public void atirarFlechasEmVariosDwarves(){
        Dwarves dwarf = new Dwarves("dwarf");
        Dwarves dwarf2 = new Dwarves("dwarf");
        Elfo elfoTeste = new Elfo("Exemplo");
        
        for(int i = 0; 7 > i; i++){
             elfoTeste.atirarFlechaEmDwarf(dwarf);
            if(i < 4)
                elfoTeste.atirarFlechaEmDwarf(dwarf2);
        }
        
        assertEquals(40, dwarf.getVida(), 0.01);
        assertEquals(70, dwarf2.getVida(), 0.01);
        assertEquals(11, elfoTeste.getExperiencia());
        assertEquals(31, elfoTeste.getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void criandoElfoPassandoQuantDeFlechas(){
        Elfo elfoTeste = new Elfo("Eduardo", 30);
        
        assertEquals(30, elfoTeste.getInventario().getItens().get(1).getQuantidade());
        assertEquals("Eduardo", elfoTeste.getNome());
    }
    
    @Test
    public void criandoElfoPassandoFlechasNegativas(){
        Elfo elfoTeste = new Elfo("Eduardo", -30);
        
        assertEquals(42, elfoTeste.getInventario().getItens().get(1).getQuantidade());
        assertEquals("Eduardo", elfoTeste.getNome());
    }
    
       @Test
    public void criandoElfoPassandoFlechasZeradas(){
        Elfo elfoTeste = new Elfo("Eduardo", 0);
        
        assertEquals(0, elfoTeste.getInventario().getItens().get(1).getQuantidade());
        assertEquals("Eduardo", elfoTeste.getNome());
    }
    
    @Test
    public void verificarToString(){
        Elfo elfoTeste = new Elfo("Eduardo");
        
        assertEquals("Eduardo possui 42 flechas e 0 níveis de experiência.", elfoTeste.toString());
    }
    
    @Test
    public void verificarToStringCom41Flechas(){
        Elfo elfoTeste = new Elfo("Eduardo");
        Dwarves dwarf = new Dwarves("dwarf");
        
        elfoTeste.atirarFlechaEmDwarf(dwarf);
        
        assertEquals("Eduardo possui 41 flechas e 1 nível de experiência.", elfoTeste.toString());
    }
    
      @Test
    public void dwarfLeva3Flechadas(){
        Dwarves dwarf = new Dwarves("dwarf");
        Elfo novoElfo = new Elfo("Eduardo");
        
        for(int i = 0; 3 > i; i++)
            novoElfo.atirarFlechaEmDwarf(dwarf);
        
        assertEquals(80, dwarf.getVida(), 0.01);
    }
    
    @Test
    public void dwarfNaoLevaFlechada(){
        Dwarves dwarf = new Dwarves("dwarf");
        Elfo novoElfo = new Elfo("Eduardo");
        
        assertEquals(110, dwarf.getVida(), 0.01);
    }
    
    @Test
    public void elfoNasceVivo(){
        Elfo novoElfo = new Elfo("Eduardo");
        
        assertEquals(Status.VIVO, novoElfo.getStatus());
    }
    
    @Test
    public void matandoUmDwarf(){
        Elfo novoElfo = new Elfo("Eduardo");
        Dwarves dwarf = new Dwarves("dwarf");
        
        for(int i = 0; 15 >= i; i++)
            novoElfo.atirarFlechaEmDwarf(dwarf);
            
        assertEquals(Status.MORTO, dwarf.getStatus());
        assertEquals(0, dwarf.getVida(), 0.01);
        assertEquals(11, novoElfo.getExperiencia());
        assertEquals(31, novoElfo.getInventario().getItens().get(1).getQuantidade());
    }
       
    @Test
    public void atirandoFlechasMasNaoMatandoODwarf(){
        Elfo novoElfo = new Elfo("Eduardo");
        Dwarves dwarf = new Dwarves("dwarf");
        
        for(int i = 0; 5 > i; i++)
            novoElfo.atirarFlechaEmDwarf(dwarf);
            
        assertEquals(Status.VIVO, dwarf.getStatus());
        assertEquals(60, dwarf.getVida(), 0.01);
        assertEquals(5, novoElfo.getExperiencia());
        assertEquals(37, novoElfo.getInventario().getItens().get(1).getQuantidade());
    }    
}
