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
        int pos, mmc;  
        mmc = 1;
           
        if(linha == coluna){  
            mmc = linha;  
               }else{  
                  for (pos=2;((linha > 1) || coluna > 1); pos++) {  
                     while(((linha % pos) == 0) || ((coluna % pos) == 0)){  
                        if((linha % pos) == 0){  
                            linha = linha/pos;      
                        }  
                        if((coluna % pos) == 0){  
                            coluna = coluna/pos;  
                        }  
                        mmc = mmc*pos;  
                    }  
                 }  
               }  
           return mmc;  
    }  
    
}