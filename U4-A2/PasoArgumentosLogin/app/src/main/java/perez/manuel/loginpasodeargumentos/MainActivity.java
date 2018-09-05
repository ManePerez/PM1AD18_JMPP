package perez.manuel.loginpasodeargumentos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static final int LOGIN_INTENT_CODE=30; //Constatnte final
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        loginIntent.putExtra("titulo", "Iniciar Sesión");
        startActivityForResult(loginIntent, LOGIN_INTENT_CODE );//Constante para identificar la activity
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == LOGIN_INTENT_CODE){
            // Programar lo que se debe hacer cuando devuelva usuario y contraseña
            String password= data.getStringExtra("Password");
            String nombreUsu= data.getStringExtra("Usuario");
            Toast.makeText(this,nombreUsu + " " +password, Toast.LENGTH_SHORT).show();

        }
    }
}