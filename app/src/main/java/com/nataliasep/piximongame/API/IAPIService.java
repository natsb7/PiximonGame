package com.nataliasep.piximongame.API;

import com.nataliasep.piximongame.Entidades.Jugador;
import com.nataliasep.piximongame.Entidades.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IAPIService {
    @POST("" +
            "identificarlogin")
    Call<Jugador> identificarLogin(@Body Jugador jugador);

    //Guardamos el usuario creado en la base de datos
    @POST("/usuarios/guardar")
    Call<Boolean> guardarUsuario(@Body Usuario usuario);

    //Guardamos los 4 jugadores aleatorios
    @POST("/guardarjugadores")
    Call<List<Jugador>> guardarJugadores(@Body List<Jugador> jugadores);

    //Guardamos la ruta de los avatares
    @POST("/guardaravatares")
    Call<List<String>> guardarAvatares(@Body List<String> avatares);

    @GET("/jugadores/getJugadores")
    Call<List<Jugador>> getJugadores();
}
