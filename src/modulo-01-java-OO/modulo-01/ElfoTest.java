
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
    public void atirarUmaFlecha(){
        Elfo elfoTeste = new Elfo("Exemplo");
        elfoTeste.atiraFlecha();
        
        assertEquals(41, elfoTeste.getFlecha().getQuantidade());
        assertEquals(1, elfoTeste.getExperiencia());
    }
    
    @Test
    public void atirarTodasFlechas(){
        Elfo elfoTeste = new Elfo("Exemplo");
        for(int i = 0; 42 > i; i++)
            elfoTeste.atiraFlecha();
            
        assertEquals(0, elfoTeste.getFlecha().getQuantidade());
        assertEquals(42, elfoTeste.getExperiencia());
    }
}
