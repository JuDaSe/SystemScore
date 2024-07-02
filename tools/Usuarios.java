package tools;

public class Usuarios {
   private String nombreJugador;
    private int dineroJugador;
    private int puntajeJugador;

    public Usuarios(String nombreJugador, int dineroJugador, int puntajeJugador){
        this.nombreJugador = nombreJugador;
        this.dineroJugador = dineroJugador;
        this.puntajeJugador = puntajeJugador;

    }

    public String getNombre(){
        return nombreJugador;
    }

    public double getDineroJugador(){
        return dineroJugador;
    }

    public void setDinero(int dineroJugador){
        this.dineroJugador = dineroJugador;
    }

    public int getPuntaje(){
        return puntajeJugador;
    }
    
}
