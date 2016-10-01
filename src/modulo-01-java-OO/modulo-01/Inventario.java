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
    
    public void dwarfComMuitaSorte(){
        for(int i = 0; itens.size() > i; i++)
            itens.get(i).dwarfComMuitaSorte();
    }
    
    public void aumentarUnidadesDosItens(int unidades){
        for(int i = 0; itens.size() > i; i++)
            itens.get(i).aumentarUnidades(unidades);
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
        //return itens.isEmpty() ? null : itens.get(indice);
        return maiorQuantidade;
    }
    
    public void ordenar(TipoOrdenacao tipo){
        ordenarItensAscendente();
        if(tipo == TipoOrdenacao.DESCENDENTE){
            ArrayList<Item> temp = new ArrayList<>();  
          
            for (int i = itens.size() - 1; i >= 0; i--)
                temp.add(itens.get(i));  
                
            itens = temp;  
        }
    }
    
    public void ordenarItensAscendente(){
        Item menorAtual = new Item("", Integer.MAX_VALUE);
        ArrayList<Item> itensOrdenados = new ArrayList<>();        
        int indice = 0;
        
        while(itens.size() != 0){
            for(int j = 0; itens.size() > j; j++){
                if(itens.get(j).getQuantidade() < menorAtual.getQuantidade()){
                    menorAtual = itens.get(j);
                    indice = j;
                }
            }
            itensOrdenados.add(menorAtual);
            menorAtual = new Item("", Integer.MAX_VALUE);
            itens.remove(indice);
            indice = 0;
        }
        itens = itensOrdenados;
    }
}
