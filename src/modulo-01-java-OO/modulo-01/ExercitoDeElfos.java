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
        List<Elfo> atacantesOrdenadoss = new ArrayList<>();
        for(int i = 0; i < atacantes.size(); i++){
            if(atacantes.get(i).getStatus() != Status.VIVO){
                atacantes.remove(i); 
                i--;
            }
            else if(atacantes.get(i) instanceof ElfoVerde){
                atacantesOrdenadoss.add(atacantes.get(i));                
                atacantes.remove(i);
                i--;
            }
        }
        atacantesOrdenadoss.addAll(atacantes);
        return atacantesOrdenadoss;        
    }
    
    public List<Elfo> ataqueIntercalado(List<Elfo> atacantes){
        List<Elfo> atacantesOrdenados = new ArrayList<>();
        List<Elfo> atacantesParametro = getOrdemDeAtaque(atacantes);
        int contaElfoVerde = 0, contaElfoNoturno = 0;
        for(int i = 0; i < atacantesParametro.size(); i++){
            if(atacantesParametro.get(i).getStatus() != Status.VIVO)
                atacantesParametro.remove(i);       
            else if(atacantesParametro.get(i) instanceof ElfoVerde)
                contaElfoVerde++;
            else if(atacantesParametro.get(i) instanceof ElfoNoturno)
                contaElfoNoturno++;
        }     
        if(contaElfoVerde == contaElfoNoturno){
            int tamanhoDaLista = atacantesParametro.size() / 2;
            int comecoDaLista = 0;
            int finalDaLista = atacantesParametro.size() - 1;
            while(tamanhoDaLista != 0){
                atacantesOrdenados.add(atacantesParametro.get(comecoDaLista));
                atacantesOrdenados.add(atacantesParametro.get(finalDaLista));
                comecoDaLista++;
                finalDaLista--;
                tamanhoDaLista--;
            }
        }else
            return null;        
        return atacantesOrdenados;
        }
        
    public List<Elfo> ataqueLittleMumu(List<Elfo> atacantes){
        List<Elfo> atacantesOrdenados = new LinkedList<>();
        int contaElfosNoturnos = 0;
        for(int i = 0; i < atacantes.size(); i++){
            if(atacantes.get(i).getInventario().getItens().get(1).getQuantidade() > 0 && atacantes.get(i).getStatus() == Status.VIVO && (atacantes.get(i) instanceof ElfoNoturno || atacantes.get(i) instanceof ElfoVerde)){
                atacantesOrdenados.add(atacantes.get(i));
                if(atacantes.get(i) instanceof ElfoNoturno)
                    contaElfosNoturnos ++;
            }
        }
        int j = 0;
        while(atacantesOrdenados.size() * 0.3 < contaElfosNoturnos){
            int quantidadeAMais = contaElfosNoturnos - (int)(atacantesOrdenados.size()*0.3);
            if(atacantesOrdenados.get(j) instanceof ElfoNoturno){
                atacantesOrdenados.remove(j);              
                j = atacantesOrdenados.size();           
            }
            j++;
        }
        return atacantesOrdenados;
    }
}   