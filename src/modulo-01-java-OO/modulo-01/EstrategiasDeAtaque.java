import java.util.*;

public interface EstrategiasDeAtaque
{
    List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes)throws ContingenteDesproporcionalException;
    List<Elfo> ataqueIntercalado(List<Elfo> atacantes)throws ContingenteDesproporcionalException;
    List<Elfo> ataqueLittleMumu(List<Elfo> atacantes)throws ContingenteDesproporcionalException;
}
