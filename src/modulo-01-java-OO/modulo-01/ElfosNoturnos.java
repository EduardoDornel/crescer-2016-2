public class ElfosNoturnos extends Elfo{
    
    public ElfosNoturnos(String nome){
        super(nome);
    }
    
    public ElfosNoturnos(String nome, int flechas){
        super(nome, flechas);
    }
    
    public void atirarFlechaEmDwarf(Dwarves dwarf){
        if(vida < 1)
            status = Status.MORTO;
            
        else if(inventario.getItens().get(1).getQuantidade() > 0  && dwarf.getStatus() == Status.VIVO){
            inventario.getItens().get(1).setQuantidade(inventario.getItens().get(1).getQuantidade() -1);
            experiencia +=3;
            vida *= 0.95;
            dwarf.perdeVida();
        }            
    }
}