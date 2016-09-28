public class Dwarves{
    private int vida = 110;
    private boolean vivo = true;
    
    public void perdeVida(){
        if(vida >= 10)
            vida -=10;
        else
            vivo = false;
    }   
    
    public int getVida(){
        return vida;
    }
    
    public boolean isVivo(){
        return vivo;
    }
}