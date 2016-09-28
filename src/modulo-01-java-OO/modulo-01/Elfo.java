public class Elfo{
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    
    public Elfo(String nome){
        this.nome = nome;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", 42);
        experiencia = 0;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Item getFlecha(){
        return flecha;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Item getArco(){
        return arco;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public void atiraFlecha(){
        flecha.setQuantidade(flecha.getQuantidade() - 1);
        experiencia++;
    }
    
    /*public void atirarFlechaRefactory(){
        flecha.setQuantidade(flecha.getQuantidade() -1 );
        experiencia++;
    }*/
}