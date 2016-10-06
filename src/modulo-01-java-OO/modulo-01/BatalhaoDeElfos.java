import java.util.*;

public class BatalhaoDeElfos{
    private HashMap<String, Elfo> batalhao = new HashMap<>();    
        
    public HashMap<String, Elfo> getBatalhao(){
        return batalhao;
    }
    
    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            batalhao.put("Elfo " + batalhao.size(), elfo);
    }
    
    public Elfo buscar(String nome){
        return batalhao.containsKey(nome) ? batalhao.get(nome) : null;
    }
    
    public HashMap<String, Elfo> buscar(Status status){
        HashMap<String, Elfo> batalhaoComStatus = new HashMap<>();
        for(int i = 0; i < batalhao.size(); i++){
            if(batalhao.get(i).getStatus() == status)
                batalhaoComStatus.put("batalhao " + batalhaoComStatus.size(), batalhao.get(i));
        }
        return batalhaoComStatus;
    }
}