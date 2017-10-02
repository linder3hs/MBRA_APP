package com.linder.mbr_app.repositori;

import com.linder.mbr_app.model.Usuarios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alumno on 28/09/2017.
 */

public class UsuriosRepository {

    private static UsuriosRepository _INSTANCE = null;

    private UsuriosRepository(){}

    public static UsuriosRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new UsuriosRepository();
        return _INSTANCE;
    }

    private List<Usuarios> usuarioses = new ArrayList<>();

    public List<Usuarios> getUsuarioses(){
        return this.usuarioses;
    }
    public void nuevoUsuario(Usuarios usuarios){
        this.usuarioses.add(usuarios);

    }

    public void registroUsuarios(){
        Usuarios use1 = new Usuarios("linder3","linder3","Linder",1);
        Usuarios use2 = new Usuarios("linder4","linder4","Rodolfo",2);
        Usuarios use3 = new Usuarios("linder5","linder5","Maroc",3);
        nuevoUsuario(use1);
        nuevoUsuario(use2);
        nuevoUsuario(use3);
    }



}
