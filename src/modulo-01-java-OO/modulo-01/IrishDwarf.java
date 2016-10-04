public class IrishDwarf extends Dwarves{
    public IrishDwarf(String nome){
        this(nome, new DataTerceiraEra(1, 1, 1));
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome);
        this.dataNascimento = dataNascimento;
    }
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){  
            inventario.dwarfComMuitaSorte();
        }
    }
}