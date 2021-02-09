/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 52999
 */
public class CommandWords {
    public CommandWords(){
    }
    //Array que contienen los comandos validos.
    private static final String[] mandosValidos = {
        "ir","salir","ayuda"
    };
    //Manda true si el mando que se dio se encuentra y si no es un mando lo que se dio manda false.
    public boolean validarMando(String palabra){
        return encontrarMando(palabra);
    }
    //Compara los mandos validos con el mando dado verificando si este es uno valido.
    private boolean encontrarMando(String palabra){
        for(int i=0; i<mandosValidos.length;i++){
            if(mandosValidos[i].equals(palabra)){
                return true;
            }
        }
        return false;
    }                
}
