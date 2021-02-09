/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 52999
 */
public class Room {
    public String descripcion;
    public Room salidaNorte;
    public Room salidaSur;
    public Room salidaEste;
    public Room salidaOeste;
    
    /**Crea una habitación con una descripción, del estilo con
    datos del estilo "Una cocina" o "Un espacio abierto".
    Al inicializar el cuarto, no tiene salidas.*/
    public Room(String descripcion){
        this.descripcion = descripcion;
    }
    
    /**Recibe de parámetros los cuartos a los que dirigen las salidas,
    recibe null si no hay habitación en esa salida, y de ser el caso
    permanece null el atributo.*/
    public void setSalidas(Room norte, Room sur, Room este, Room oeste){
        putRoom(norte, 0);
        putRoom(sur, 1);
        putRoom(este, 2);
        putRoom(oeste, 3);
    }
    
    private void putRoom(Room room, int i){
        if(room != null){
            switch(i){
                case 0 -> salidaNorte = room;
                case 1 -> salidaSur = room;
                case 2 -> salidaEste = room;
                case 3 -> salidaOeste = room;
            }
        }
    }
    
    public String getDescripcion(){
        return descripcion;
    }
}
