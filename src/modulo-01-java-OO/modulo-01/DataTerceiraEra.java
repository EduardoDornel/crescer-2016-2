public class DataTerceiraEra{
    private int dia, mes, ano;
    
    public DataTerceiraEra(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public boolean ehBissexto(){
        if(ano % 4 != 0)
            return false;
        else if(ano % 100 != 0 || ano % 400 == 0)
            return true;
        return false;
    }
    
    public int getDia(){
        return dia;
    }
    
    public int getMes(){
        return mes;
    }
    
    public int getAno(){
        return ano;
    }
}