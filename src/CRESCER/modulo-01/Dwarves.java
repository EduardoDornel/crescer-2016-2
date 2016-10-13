import java.util.ArrayList;

public class Dwarves extends Personagem{
    protected final DataTerceiraEra dataNascimento;
    public final static double ALTURA_MAXIMA = 1.32;
    {
        vida = 110;
    }
    public Dwarves(String nome){
        this(nome, new DataTerceiraEra(1, 1, 1));
    }
    
    public Dwarves(String nome, DataTerceiraEra dataNascimento){
        super(nome);
        this.dataNascimento = dataNascimento;
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
            inventario.aumentarUnidadesDosItens(1000);
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
    
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
    }
}