import java.util.*;
public class HobbitContador{
    ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> getArrayDePares(){
        return arrayDePares;
    }
    
    public int calculaDiferenca(ArrayList<ArrayList<Integer>> arrayDeArrays){       
       int total = 0;
       for(int i = 0; arrayDeArrays.size() > i; i++){
           int multiplicacao = 1;
           int mmc = 0;
           for(int j = 0; arrayDeArrays.get(i).size() > j; j++){
               multiplicacao *= arrayDeArrays.get(i).get(j);
           }
           mmc = minimoMultiplo(arrayDeArrays.get(i).get(0), arrayDeArrays.get(i).get(1));
           total += (multiplicacao - mmc);
       }
       
       return total;
    }
    public int minimoMultiplo(int linha, int coluna){  
        int i,j;  
        j = 1;
           
        if(linha == coluna){  
            j = linha;  
               }else{  
                  for (i=2;((linha > 1) || coluna > 1); i++) {  
                     while(((linha % i) == 0) || ((coluna % i) == 0)){  
                        if((linha % i) == 0){  
                            linha = linha/i;      
                        }  
                        if((coluna % i) == 0){  
                            coluna = coluna/i;  
                        }  
                        j = j*i;  
                    }  
                 }  
               }  
           return j;  
    }  
    
}