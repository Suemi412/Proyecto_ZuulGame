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
    //Array que contienen los comandos validos 
    private static final String[] comandosValidos={
        "ir","salir","ayuda"
    }
    //Lo que se hace es checar cuanquier palabra que se de para revisar si es un comando valido
    public boolean validarComando(String palabra){
        for(int i=0; i<ComandosValidos.length;i++){
            if(comandosValidos[i].equals(palabra)){
                return true;
            }
        }
        return false;
    }
                
}
