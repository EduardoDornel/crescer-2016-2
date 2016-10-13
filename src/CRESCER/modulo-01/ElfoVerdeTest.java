

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
   @Test
   public void elfoVerdeGanhaDuasExperiencias(){
       Elfo green = new ElfoVerde("elfo");
       
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       
       assertEquals(2, green.getExperiencia());
   }
   
   @Test
   public void elfoVerdeGanha10Experiencias(){
       Elfo green = new ElfoVerde("elfo");
       
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       
       assertEquals(10, green.getExperiencia());
   }
   
   @Test
   public void elfoVerdeNaoGanhaExperiencia(){
       Elfo green = new ElfoVerde("elfo");
       
       assertEquals(0, green.getExperiencia());
   }
}
