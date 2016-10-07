public class NaoPodeAlistarException extends Exception{    
    
    public NaoPodeAlistarException(){
        super("Não foi possivel alistr o Elfo, pois apenas verdes e noturnos são válidos.");
    }
    
    public NaoPodeAlistarException(String erro){
        super(erro);
    }
}