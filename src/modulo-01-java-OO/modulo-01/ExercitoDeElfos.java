import java.util.*;

public class ExercitoDeElfos implements Exercito, EstrategiasDeAtaque{
    ArrayList<Elfo> listaElfos = new ArrayList<>();
    
    public ArrayList<Elfo> getBatalhao(){
        return listaElfos;
    }
  
    public void alistarElfo(Elfo elfo) throws NaoPodeAlistarException {
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            listaElfos.add(elfo);
        else
            throw new NaoPodeAlistarException();
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
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        List<Elfo> atacantesOrdenados = new ArrayList<>();
        ArrayList<Elfo> atacantesParametro = (ArrayList)atacantes;
        for(int i = 0; i < atacantes.size(); i++){
            if(atacantesParametro.get(i).getStatus() != Status.VIVO)
                atacantesParametro.remove(i);            
            else if(atacantesParametro.get(i) instanceof ElfoVerde){
                atacantesOrdenados.add(atacantesParametro.get(i));                
                atacantesParametro.remove(i);
            }
        }
        atacantesOrdenados.addAll(atacantesParametro);
        return atacantesOrdenados;        
    }
}