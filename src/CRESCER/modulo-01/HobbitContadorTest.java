
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitContadorTest
{
   @Test
   public void criarHobbitContadorComArraylist(){
       HobbitContador contador = new HobbitContador();
       ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
       
       assertEquals(arrayDePares, contador.getArrayDePares());
    }
    
   @Test
   public void calculaDiferencaValoresBaixos(){
       HobbitContador contador = new HobbitContador();
       contador.getArrayDePares().add(new ArrayList<>(Arrays.asList(15, 18)));   
       contador.getArrayDePares().add(new ArrayList<>(Arrays.asList(4, 5)));
       contador.getArrayDePares().add(new ArrayList<>(Arrays.asList(12, 60)));
       
       assertEquals(840, contador.calculaDiferenca(contador.getArrayDePares()));
    }
   @Test
   public void calculaDiferencaValoresMedios(){
       HobbitContador contador = new HobbitContador();
       contador.getArrayDePares().add(new ArrayList<>(Arrays.asList(34, 17)));   
       contador.getArrayDePares().add(new ArrayList<>(Arrays.asList(59, 28)));
       contador.getArrayDePares().add(new ArrayList<>(Arrays.asList(61, 23)));
       
       assertEquals(544, contador.calculaDiferenca(contador.getArrayDePares()));
    } 
   
   @Test
   public void calculaDiferencaValoresAltos(){
       HobbitContador contador = new HobbitContador();
       contador.getArrayDePares().add(new ArrayList<>(Arrays.asList(372, 129)));   
       contador.getArrayDePares().add(new ArrayList<>(Arrays.asList(840, 220)));
       contador.getArrayDePares().add(new ArrayList<>(Arrays.asList(444, 333)));
       
       assertEquals(354072, contador.calculaDiferenca(contador.getArrayDePares()));
    }
    
    @Test
    public void mmc15e18(){
        HobbitContador contador = new HobbitContador();
        assertEquals(90, contador.minimoMultiplo(15, 18));
    }
    
    @Test
    public void mmc4e5(){
        HobbitContador contador = new HobbitContador();
        assertEquals(20, contador.minimoMultiplo(4, 5));
    }
    
    @Test
    public void mmc12e60(){
        HobbitContador contador = new HobbitContador();
        assertEquals(60, contador.minimoMultiplo(12, 60));
    }
}
