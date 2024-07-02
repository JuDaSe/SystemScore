package tools;

import java.util.ArrayList;

public class Controlador {
    private static ArrayList<Usuarios> jugadores = new ArrayList<>();


    public Controlador(){
        jugadores = new ArrayList<Usuarios>();
    }

    public void agregarJugador(Usuarios u){
        jugadores.add(u);
    }

    public int size(){
        return jugadores.size();
    }

    public Usuarios getPlayer(int posicion){
        return jugadores.get(posicion);
    }


}

