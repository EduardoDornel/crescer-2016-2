import java.util.ArrayList;

public class Inventario{
    ArrayList<Item> itens = new ArrayList<>();
    
    public Item getItem(int index){
        return itens.get(index);
    }
    
    public void adicionarItem(Item item){
        itens.add(item);
    }
    
    public void removerItem(Item item){
        itens.remove(item);
    }
}