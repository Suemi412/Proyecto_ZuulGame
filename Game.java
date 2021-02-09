/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 52999
 */
public class Game {
    private Parser parser;
    private Room habitacionActual;
    
    public Game(){
        crearHabitaciones();
        parser=new Parser();
    }
    
    private void crearHabitaciones() {
        Room afuera,teatro,pub,laboratorio,oficina;
        afuera= new Room("fuera de la entrada principal de la universidad");
        teatro= new Room("en una sala de conferencias");
        pub= new Room("en el pub del campus");
        laboratorio= new Room("en un laboratorio de computación");
        oficina=new Room("en la oficina de administración informática");
        
        afuera.setSalidas(null, teatro, laboratorio, pub);
        teatro.setSalidas(null, null, null, afuera);
        pub.setSalidas(null, afuera, null, null);
        laboratorio.setSalidas(afuera, oficina, null, null);
        oficina.setSalidas(null, null, null, laboratorio);
    }
    //Ejecuta el juego hasta que el usuario decida salirse.
    public void jugar(){
        imprimirBienvenida();
        boolean fin=false;
        while(!fin){
            Command command=parser.getCommand();
            fin=comandoProceso(command);
        }
        System.out.println("Gracias por jugar hasta luego.");
    }
    private void imprimirBienvenida() {
        System.out.println();
        System.out.println("¡Bienvenido a World of Zuul!");
        System.out.println("World of Zuul es un juego de aventuras nuevo e increíblemente aburrido.");
        System.out.println("Escriba 'help' si necesita ayuda.");
        System.out.println();
        System.out.println("Usted está " + habitacionActual.getDescripcion());
        System.out.print("Salidas: ");
        if(habitacionActual.salidaNorte != null) {
            System.out.print("norte ");
        }
        if(habitacionActual.salidaEste != null) {
            System.out.print("este ");
        }
        if(habitacionActual.salidaSur != null) {
            System.out.print("sur ");
        }
        if(habitacionActual.salidaOeste != null) {
            System.out.print("oeste ");
        }
        System.out.println();
    }
    /*Tomando el mando que se coloco lo procesa para 
    revisar si el usuario no quiere salirse del juego, 
    si el usuario quiere salirse manda un true y sino un false
    y mandar a sus respectivas funciones si el usuario puso otra mando.
    */
    private boolean comandoProceso(Command command) {
        boolean quiereSalir=false;
        if(command.esDesconocido()){
            System.out.println("No entiendo lo que quisiste decir");
            return false;
        }
        String palabraMando=command.getPalabraComando();
        if(palabraMando.equals("ayuda")){
            imprimirAyuda();
        }else{
            if(palabraMando.equals("ir")){
                irHabitacion(command);
            }else{
                if(palabraMando.equals("salir")){
                    quiereSalir=salir(command);
                }
            }
        }
        return quiereSalir;
    }

    private void imprimirAyuda() {
        System.out.println("Estás perdido. Estás solo. Vagas");
        System.out.println("por la universidad.");
        System.out.println();
        System.out.println("Tus palabras de mando son:");
        System.out.println("   ir salir ayudar");
    }

    private void irHabitacion(Command command) {
        if(!command.tieneSegundaPalabra()){
            System.out.println("¿Ir a donde?");
            return;
        }
        String direccion=command.getSegundaPalabra();
        
        Room SigHabitacion=null;
        if(direccion.equals("norte")) {
            SigHabitacion = habitacionActual.salidaNorte;
        }
        if(direccion.equals("este")) {
            SigHabitacion = habitacionActual.salidaEste;
        }
        if(direccion.equals("sur")) {
            SigHabitacion = habitacionActual.salidaSur;
        }
        if(direccion.equals("oeste")) {
            SigHabitacion = habitacionActual.salidaOeste;
        }
        
        if (SigHabitacion == null) {
            System.out.println("¡No hay puerta!");
        }else{
            habitacionActual=SigHabitacion;
            System.out.println("Usted está " + habitacionActual.getDescripcion());
            System.out.println("Salidas:");
            if(habitacionActual.salidaNorte != null) {
                System.out.print("norte ");
            }
            if(habitacionActual.salidaEste != null) {
                System.out.print("este ");
            }
            if(habitacionActual.salidaSur != null) {
                System.out.print("sur ");
            }
            if(habitacionActual.salidaOeste != null) {
                System.out.print("oeste ");
            }
            System.out.println();
        }
    }

    private boolean salir(Command command) {
        if(command.tieneSegundaPalabra()) {
            System.out.println("¿Salir qué?");
            return false;
        }else {
            return true;  
        }
    }
    public static void main(String args[]){
        new Game().jugar();
    }
}
