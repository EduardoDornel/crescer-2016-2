

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
   @Test
   public void elfoVerdeGanhaDuasExperiencias(){
       ElfoVerde green = new ElfoVerde("elfo");
       
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       
       assertEquals(2, green.getExperiencia());
   }
   
   @Test
   public void elfoVerdeGanha10Experiencias(){
       ElfoVerde green = new ElfoVerde("elfo");
       
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       
       assertEquals(10, green.getExperiencia());
   }
   
   @Test
   public void elfoVerdeNaoGanhaExperiencia(){
       ElfoVerde green = new ElfoVerde("elfo");
       
       assertEquals(0, green.getExperiencia());
   }
}
