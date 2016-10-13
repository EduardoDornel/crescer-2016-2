public class Elfo extends Personagem{
    private static int contadorDeElfos;
    {
        vida = 100;
        Elfo.contadorDeElfos++;
    }
    
    public Elfo(String nome){
        //Chamando construtor de baixo.
        this(nome, 42);
    }
    
    public Elfo(String nome, int flechas){
        super(nome);
        inventario.adicionarItem(new Item("arco", 1));
        inventario.adicionarItem(new Item("flechas", flechas >= 0 ? flechas: 42));
    }
    
    protected void finalize() throws Throwable{
        super.finalize();
        Elfo.contadorDeElfos--;
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
    
    public static int getContadorDeElfos(){
        return Elfo.contadorDeElfos;
    }
}