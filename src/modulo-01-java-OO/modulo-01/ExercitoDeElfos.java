import java.util.*;

public class ExercitoDeElfos implements Exercito{
    ArrayList<Elfo> listaElfos = new ArrayList<>();
    
    public ArrayList<Elfo> getBatalhao(){
        return listaElfos;
    }
    
    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            listaElfos.add(elfo);
    }
    
    public Elfo buscarPeloNome(String nome){
        for(int i = 0; i < listaElfos.size(); i++){
            if(listaElfos.get(i).getNome().equals(nome))
                return listaElfos.get(i);
        }
        return null;
    }
    
        
    public ArrayList<Elfo> buscar(Status status) {
        ArrayList<Elfo> listaElfosComStatus = new ArrayList<>();
        for(int i = 0; i < listaElfos.size(); i++){
            if(listaElfos.get(i).getStatus() == status)
                listaElfosComStatus.add(listaElfos.get(i));
        }
        return listaElfosComStatus;
    }
}