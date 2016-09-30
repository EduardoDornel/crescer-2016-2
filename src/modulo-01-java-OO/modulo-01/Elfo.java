public class Elfo{
    private String nome;
    private int experiencia;
    private Status status;
    private Inventario inventario = new Inventario();
    
    {
        status = Status.VIVO;
    }
    public Elfo(String nome){
        //Chamando construtor de baixo.
        this(nome, 42);
    }
    
    public Elfo(String nome, int flechas){
        this.nome = nome;
        inventario.adicionarItem(new Item("arco", 1));
        inventario.adicionarItem(new Item("flechas", flechas >= 0 ? flechas: 42));
    }
    
    public Status getStatus(){
        return status;
    }
    
    public void setNome(String nome){
        this.nome = nome;
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
        boolean flechaNoSingular = inventario.getItem(1).getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 1;
        
        return String.format("%s possui %d %s e %s %s de experiência.",
            this.nome,
            inventario.getItem(1).getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis");
    }
    
    /*No método  receberFlecha()  (ou o que você tenha chamado), chame o método  getNumeroSorte() .
     * Caso o resultado seja menor que 0, o  Dwarf  não deverá receber a flecha e ainda ganhará dois pontos de experiência.
     * Senão se o número estiver entre 0 e 100 (incluindo 0 e 100), o  Dwarf  não recebe flechas e não recebe experiência. 
     * Caso contrário, o  Dwarf  receberá a flechada (como está hoje).*/
    
    public void atirarFlechaEmDwarf(Dwarves dwarf){
            dwarf.perdeVida();
        if(inventario.getItem(1).getQuantidade() > 0 && dwarf.getNumeroSorte() > 100 && dwarf.getStatus() != Status.MORTO){
            inventario.getItem(1).setQuantidade(inventario.getItem(1).getQuantidade() - 1);
            experiencia++;
        }
    }
}