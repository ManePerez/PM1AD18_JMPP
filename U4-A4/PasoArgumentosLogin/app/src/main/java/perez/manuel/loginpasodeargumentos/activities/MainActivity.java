package perez.manuel.loginpasodeargumentos.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import perez.manuel.loginpasodeargumentos.R;
import perez.manuel.loginpasodeargumentos.models.Usuario;

public class MainActivity extends Activity{
    public static final int LOGIN_INTENT_CODE=30; //Constatnte final
    TextView txtUser,txtPass,txtApeP,txtApeM,txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser=(TextView) findViewById(R.id.textView3);
        txtPass= (TextView)findViewById(R.id.textView4);
        txtApeP=(TextView)findViewById(R.id.textView5);
        txtApeM=(TextView)findViewById(R.id.textView6);
        txtEmail=(TextView)findViewById(R.id.textView7);
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        loginIntent.putExtra("titulo", "Iniciar Sesión");
        startActivityForResult(loginIntent, LOGIN_INTENT_CODE );//Constante para identificar la activity
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == LOGIN_INTENT_CODE){
            try{
                Intent i= data;
                Bundle b=i.getExtras();
                Usuario u= (Usuario) b.getSerializable("objeto");
                Toast.makeText(this,u.getUsuario()+" "+u.getApellidoP()+" "+u.getApellidoM()+" "+u.getPassword()+" "+u.getEmail(),Toast.LENGTH_LONG).show();
                txtUser.setText("Usuario : "+u.getUsuario().toString());
                txtPass.setText("Password : "+u.getPassword().toString());
                txtApeP.setText("Apellido P : "+u.getApellidoP().toString());
                txtApeM.setText("Apellido M : "+u.getApellidoM().toString());
                txtEmail.setText("Email : "+u.getEmail().toString());
            }catch (Exception e){
                Toast.makeText(this,e+"",Toast.LENGTH_LONG).show();
            }

        }
    }
}