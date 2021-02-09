/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 52999
 */
public class Parser {
    private CommandWords commands; //Contiene todas las palabras comando validas
    private Scanner reader; //Leector de la consola
    
    /** Inicializa el objeto para la lectura de consola. */
    public Parser(){
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
    
    /**Analiza y devuelve el comando que da el usuario. */
    public Command getCommand(){
        String entrada;
        String palabra1 = null;
        String palabra2 = null;
        
        //Lectura de la entrada.
        System.out.print("> ");
        entrada = reader.nextLine();
        
        //Tokeniza la entrada en busca de la primera y
        //segunda palabra, ignora todas las demás.
        Scanner tokenizer = new Scanner(entrada);
        if(tokenizer.hasNext()) {
            palabra1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                palabra2 = tokenizer.next();
            }
        }
        
        //Verifica si las palabras encontradas son comandos validos.
        if(commands.validarMando(palabra1)) {
            return new Command(palabra1, palabra2);
        }
        else {
            return new Command(null, palabra2); 
        }
    }
}
