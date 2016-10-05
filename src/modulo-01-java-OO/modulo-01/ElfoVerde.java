public class ElfoVerde extends Elfo{
    
    {
        inventario.getItens().clear();
        inventario.adicionarItem(new Item("Espada de aço valiriano", 1));
        inventario.adicionarItem(new Item("Arco e Flecha de Vidro", 42));
    }
  
    public ElfoVerde(String nome){
        this(nome, 42);
    }
    
    public ElfoVerde(String nome, int flechas){
        super(nome);
        inventario.getItens().get(1).setQuantidade(flechas);
    }
    
    @Override
    public void atirarFlechaEmDwarf(Dwarves dwarf){
        boolean temFlecha = inventario.getItens().get(1).getQuantidade() > 0;
        if(temFlecha){
            super.atirarFlechaEmDwarf(dwarf);
            experiencia++;
        }
            
    }
}