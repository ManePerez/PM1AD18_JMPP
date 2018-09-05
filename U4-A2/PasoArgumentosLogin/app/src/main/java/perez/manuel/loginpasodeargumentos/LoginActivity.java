package perez.manuel.loginpasodeargumentos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
    Button btnLog;
    EditText txtUsu,txtPass;
    TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLog = findViewById(R.id.btnLogin);
        txtPass = findViewById(R.id.txtPassword);
        txtUsu = findViewById(R.id.txtUsuario);
        titulo =  findViewById(R.id.txtTitulo);
        titulo.setText(getIntent().getStringExtra("titulo")); //Se establece el titulo que se le manda desde la ventana principal.
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent respuesta = new Intent();
                respuesta.putExtra("Usuario", txtUsu.getText().toString()); // Se le agregan lo que contenga la caja de texto a la variable respuesta
                respuesta.putExtra("Password", txtPass.getText().toString());
                setResult(MainActivity.LOGIN_INTENT_CODE,respuesta); // Se regresan los datos a la pagina principal
                finish();
            }
        });
    }
}
