/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 52999
 */
public class Command {
	
	private String palabraComando;
    private String segundaPalabra;

    /*
     * Función para crear comandos. Ambas palabras deben
     * de ser usadas pero ambas pueden estar vacías
     */
    public Command(String primeraPalabra, String segundaPalabra)
    {
    	palabraComando = primeraPalabra;
        this.segundaPalabra = segundaPalabra;
    }

    /*
		Regresa la primera palabra del comando. Si no se
		entendió el comando, regresará nulo.
     */
    public String getPalabraComando()
    {
        return palabraComando;
    }

    /*
		Regresa la segunda palbara del comando. Si
		no había segunda palabra, regresará nulo
     */
    public String getSegundaPalabra()
    {
        return segundaPalabra;
    }

    /*
     * Regresa Verdadero si la palabra es desconocida
     */
    public boolean esDesconocido()
    {
        return (palabraComando == null);
    }

    /*
     * Regresa verdadero si existe la segunda palabra
     */
    public boolean tieneSegundaPalabra()
    {
        return (segundaPalabra != null);
    }
}
