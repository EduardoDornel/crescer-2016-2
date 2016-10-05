import java.util.*;

public class ExercitoDeElfos{
    ArrayList<Elfo> listaElfos = new ArrayList<>();
    
    public ArrayList<Elfo> getListaElfos(){
        return listaElfos;
    }
    
    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfosVerdes || elfo instanceof ElfosNoturnos)
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