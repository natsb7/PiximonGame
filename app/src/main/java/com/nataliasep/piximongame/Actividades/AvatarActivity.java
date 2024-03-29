package com.nataliasep.piximongame.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nataliasep.piximongame.R;
import com.nataliasep.piximongame.Entidades.Avatar;
import com.nataliasep.piximongame.Entidades.Usuario;
import com.nataliasep.piximongame.Entidades.Adaptadores.AdaptadorAvatar;

import java.util.ArrayList;
import java.util.List;

public class AvatarActivity extends AppCompatActivity {

    private RecyclerView recViewAvatar;
    private AdaptadorAvatar adaptadorAvatar;
    private List<Avatar> listaAvatares;
    private Usuario usuarioLogeado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        //obtenemos el nombre del jugador del intent
        usuarioLogeado = getIntent().getParcelableExtra("usuarioLogeado");

        listaAvatares = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            String rutaImagen = "personaje" + i;
            Log.d("RUTA IMAGEN", "Ruta imagen: " + rutaImagen);
            listaAvatares.add(new Avatar(rutaImagen));
        }


        recViewAvatar = findViewById(R.id.recViewAvatar);
        adaptadorAvatar = new AdaptadorAvatar(listaAvatares, usuarioLogeado);
        recViewAvatar.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        recViewAvatar.setAdapter(adaptadorAvatar);
    }
}