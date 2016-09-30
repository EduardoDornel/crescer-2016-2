import java.util.ArrayList;

public class Inventario{
    ArrayList<Item> itens = new ArrayList<>();
    
    public ArrayList<Item> getItens(){
        return itens;
    }
    
    public void adicionarItem(Item item){
        itens.add(item);
    }
    
    public void removerItem(Item item){
        itens.remove(item);
    }
    
    public String getDescricoesItens(){
        String descricoes = "";
        for(int i = 0; itens.size() > i; i++){
            descricoes += itens.get(i).getDescricao();
            if(i + 1 != itens.size())
                descricoes += ", ";
        }
        // return descricoes isEmpty() ? descricoes : descricoes.substring(0, resultado.length() -1);
        return descricoes;
    }
    
    public Item itemMaiorQuantidade(){
        Item maiorQuantidade = new Item("",0);
        for(int i = 0; itens.size() > i; i++){
            if(itens.get(i).getQuantidade() > maiorQuantidade.getQuantidade())
                maiorQuantidade = itens.get(i);
        }
        return maiorQuantidade;
    }
}