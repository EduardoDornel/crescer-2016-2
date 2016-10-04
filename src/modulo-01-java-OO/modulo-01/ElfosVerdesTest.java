

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosVerdesTest
{
   @Test
   public void elfoVerdeGanhaDuasExperiencias(){
       ElfosVerdes green = new ElfosVerdes("elfo");
       
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       
       assertEquals(2, green.getExperiencia());
   }
   
   @Test
   public void elfoVerdeGanha10Experiencias(){
       ElfosVerdes green = new ElfosVerdes("elfo");
       
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       green.atirarFlechaEmDwarf(new Dwarves("dwarf"));
       
       assertEquals(10, green.getExperiencia());
   }
   
   @Test
   public void elfoVerdeNaoGanhaExperiencia(){
       ElfosVerdes green = new ElfosVerdes("elfo");
       
       assertEquals(0, green.getExperiencia());
   }
}
