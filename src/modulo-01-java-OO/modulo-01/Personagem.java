public class Personagem{
    protected String nome;
    protected int experiencia;
    protected double vida;
    protected Status status;
    protected Inventario inventario = new Inventario();
    
    {
        this.status = Status.VIVO;
    }
    
    public Personagem(){
        
    }
    
    public Personagem(String nome){
        this.nome = nome;
    }
    
    public void adicionarItem(Item item){
        inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        inventario.removerItem(item);
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Inventario getInventario(){
        return inventario;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public double getVida(){
        return vida;
    }
}