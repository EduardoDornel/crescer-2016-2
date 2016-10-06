import java.util.*;

public class BatalhaoDeElfos{
    private HashMap<String, Elfo> batalhao = new HashMap<>();    
        
    public HashMap<String, Elfo> getBatalhao(){
        return batalhao;
    }
    
    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            batalhao.put(elfo.getNome() , elfo);
    }
    
    public Elfo buscar(String nome){
        return batalhao.containsKey(nome) ? batalhao.get(nome) : null;
    }
    
    public HashMap<String, Elfo> buscar(Status status){
        HashMap<String, Elfo> batalhaoComStatus = new HashMap<>();
 
        for (String keyElfo : batalhao.keySet()){
            Elfo elfoComStatus = batalhao.get(keyElfo);
            if(elfoComStatus.getStatus() == status){
                batalhaoComStatus.put(elfoComStatus.getNome(), elfoComStatus);            
            }
        }
        return batalhaoComStatus;
    }
}