public class Elfo{
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    
    public Elfo(String nome){
        //Chamando construtor de baixo.
        this(nome, 42);
    }
    
    public Elfo(String nome, int flechas){
        this.nome = nome;
        arco = new Item("arco", 1);
        flecha = new Item("flechas", flechas);
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
    
    public String toString(){
        boolean flechaNoSingular = this.flecha.getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 1;
        
        return String.format("%s possui %d %s e %s %s de experiência.",
            this.nome,
            this.flecha.getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis");
    }
    
    public void atirarFlechaEmDwarf(Dwarves dwarf){
        if(flecha.getQuantidade() > 0 && dwarf.isVivo() == true){
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
            dwarf.perdeVida();
        }
    }
}