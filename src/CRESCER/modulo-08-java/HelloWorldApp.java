public class HelloWorldApp {
  public static void main(String[] args) { 
    int valor = Integer.valueOf(args[0]);
	if(valor % 2 == 0){
		System.out.println("PAR");
	}else{
		System.out.println("IMPAR");
	}
	}
}