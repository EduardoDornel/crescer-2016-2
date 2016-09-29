public class Dwarves{
    private String nome;
    private int vida = 110;
    private DataTerceiraEra dataNascimento;
    private int experiencia;
    
    public Dwarves(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public Dwarves(){
        dataNascimento = new DataTerceiraEra(1, 1, 1);
    }
    
    public double getNumeroSorte(){
        double numeroSorte = 101.0;
        if(dataNascimento.ehBissexto() && vida >= 80 && vida <= 90)
            return numeroSorte * -33;
        else if(nome.equals("Seixas") || nome.equals("Meireles")){
            numeroSorte *= 33;
            return numeroSorte % 100;
        }        
        return numeroSorte;
    }
    
    public void perdeVida(){
        vida -=10;
    }   
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public void setExperiencia(int experiencia){
        this.experiencia = experiencia;
    }
    
    public int getVida(){
        return vida;
    }
    
}