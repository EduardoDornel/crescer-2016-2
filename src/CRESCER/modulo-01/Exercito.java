import java.util.*;
public interface Exercito{
    ArrayList<Elfo> getBatalhao();
    void alistarElfo(Elfo elfo)throws NaoPodeAlistarException ;
    Elfo buscarPeloNome(String nome);
    ArrayList<Elfo> buscar(Status status);
}