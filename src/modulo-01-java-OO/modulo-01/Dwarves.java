import java.util.ArrayList;

public class Dwarves{
    private String nome;
    private int vida = 110;
    private DataTerceiraEra dataNascimento;
    private int experiencia;
    private Status status;
    private Inventario inventario = new Inventario();
    
    {
        status = Status.VIVO;
    }
    public Dwarves(){
        dataNascimento = new DataTerceiraEra(1, 1, 1);
    }
    
    public Dwarves(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void adicionarItem(Item item){
        inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        inventario.removerItem(item);
    }
    
    public double getNumeroSorte(){
        double numeroSorte = 101.0;
        if(dataNascimento.ehBissexto() && vida >= 80 && vida <= 90)
            numeroSorte *= -33.0;
        else if(!dataNascimento.ehBissexto() && ("Seixas".equals(this.nome) || "Meireles".equals(this.nome))){
            numeroSorte = numeroSorte * 33 % 100;
        }       
        return numeroSorte;
    }
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            for(int i = 0; inventario.getItens().size() > i; i++)   
                inventario.getItem(i).setQuantidade(inventario.getItem(i).getQuantidade() + 1000);
        }
    }
    
    public void perdeVida(){
        double numero = this.getNumeroSorte();
        if(vida == 0)
            status = Status.MORTO;
        if(numero < 0)
            experiencia += 2;
        else if(status != Status.MORTO && numero > 100){
            vida -=10;
        }
    }   
    
    public Inventario getInventario(){
        return inventario;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
    }
    
    public int getVida(){
        return vida;
    }
    
}