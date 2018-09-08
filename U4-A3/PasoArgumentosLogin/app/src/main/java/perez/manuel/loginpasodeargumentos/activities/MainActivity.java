package perez.manuel.loginpasodeargumentos.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
            Boolean resultado = data.getBooleanExtra("Resultado",true);
            if(resultado){
                Toast.makeText(this,"Bienvenido", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Usuario y/o contraseña incorrecta", Toast.LENGTH_SHORT).show();

            }
        }
    }
}