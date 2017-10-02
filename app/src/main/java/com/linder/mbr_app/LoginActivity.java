package com.linder.mbr_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.linder.mbr_app.model.Usuarios;
import com.linder.mbr_app.repositori.UsuriosRepository;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText user, pass;
    private Button login;
    private String usuarioLogin, contraseña;
    private String username;
    private String password;
    private String nombre;
    private int rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        login = (Button) findViewById(R.id.login);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarUsuario();
            }
        });
    }

    protected void validarUsuario(){


        user  = (EditText) findViewById(R.id.user);
        pass  = (EditText) findViewById(R.id.password);

        usuarioLogin = user.getText().toString();
        contraseña = pass.getText().toString();
        UsuriosRepository usuriosRepository = UsuriosRepository.getInstance();
        usuriosRepository.registroUsuarios();

        List<Usuarios> usuarios = usuriosRepository.getUsuarioses();

        for (Usuarios usuario : usuarios) {

            username = usuario.getUsername();
            password = usuario.getPassword();
            nombre = usuario.getNombre();
            rol = usuario.getRol();

            Log.d("Username",username);
            Log.d("pass",password);
            Log.d("inouuseer", username);


            if (username.equals(usuarioLogin) && password.equals((contraseña))){

                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                intent.putExtra("rol",rol);
                intent.putExtra("nombre",nombre);
                intent.putExtra("email",username);
                finish();
                startActivity(intent);

            }
        }
    }
}

