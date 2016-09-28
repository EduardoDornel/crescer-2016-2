public class CestoDeLembas{
    private int quantidade;
    
    public CestoDeLembas(int quantidade){
        this.quantidade = quantidade;
    }
    
    public boolean podeDividirEmPares(){
        if(1 <= quantidade && quantidade <= 100 && quantidade % 2 == 0 && quantidade != 2)
            return true;
        return false;
    }
}