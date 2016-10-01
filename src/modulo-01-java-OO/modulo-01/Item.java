public class Item{
    private String descricao;
    private int quantidade;
    
    public Item(String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public void aumentarUnidades(int unidades){
        quantidade += unidades;
    }
    
    public void dwarfComMuitaSorte(){
        int valorDaMultiplicacao = 0;
        for(int i = 0; i <= Math.abs(quantidade); i++)
            valorDaMultiplicacao += i;
        quantidade += 1000 * valorDaMultiplicacao;
    } 
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public String getDescricao(){
        return descricao;
    }
}