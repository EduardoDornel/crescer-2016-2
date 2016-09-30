public class Elfo{
    private String nome;
    private int experiencia;
    private Status status;
    private Inventario inventario = new Inventario();
    
    {
        inventario.adicionarItem(new Item("arco", 1));
        status = Status.VIVO;
    }
    public Elfo(String nome){
        //Chamando construtor de baixo.
        this(nome, 42);
    }
    
    public Elfo(String nome, int flechas){
        this.nome = nome;
        inventario.adicionarItem(new Item("flechas", flechas >= 0 ? flechas: 42));
    }
    
    public Status getStatus(){
        return status;
    }
   
    public String getNome(){
        return nome;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public Inventario getInventario(){
        return inventario;
    }
    
    public String toString(){
        boolean flechaNoSingular = inventario.getItens().get(1).getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 1;
        
        return String.format("%s possui %d %s e %s %s de experiência.",
            this.nome,
            inventario.getItens().get(1).getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis");
    }

    public void atirarFlechaEmDwarf(Dwarves dwarf){
            dwarf.perdeVida();
        if(inventario.getItens().get(1).getQuantidade() > 0 && dwarf.getNumeroSorte() > 100 && dwarf.getStatus() != Status.MORTO){
            inventario.getItens().get(1).setQuantidade(inventario.getItens().get(1).getQuantidade() - 1);
            experiencia++;
        }
    }
}