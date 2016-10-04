public class ElfosVerdes extends Elfo{
  
    public ElfosVerdes(String nome){
        super(nome);
    }
    
    public void atirarFlechaEmDwarf(Dwarves dwarf){
        int vidaDoElfo = dwarf.getVida();
        super.atirarFlechaEmDwarf(dwarf);
        if(vidaDoElfo-10 == dwarf.getVida())
            experiencia++;
    }
}