package application.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private static Scanner leitor = new Scanner(System.in);

    public static int lerInt() {
        
        int valor = 0;
        
        while(true) {
            try {       
                valor = leitor.nextInt();
                break;
                
            } catch (InputMismatchException e){ 
                System.out.println("Erro ao tentar ler valor: O valor precisa ser inteiro.");
                System.out.print("Digite novamente: ");
     
            } finally { 
                leitor.nextLine();
            }
        }
        
        return valor;
    }

    public static double lerDouble() {
        
        double valor = 0;
        
        while(true){

            try{
                valor = leitor.nextDouble();
                break;
            
            } catch (InputMismatchException e) {
                
                System.out.println("Erro ao tentar ler valor: o valor precisa ser real.");
                System.out.print("Digite novamente: ");
            
            } finally {
                leitor.nextLine();
            } 
  
        }

        return valor;
    }

    public static String lerString() {
        return leitor.nextLine();
    }


}