package perez.manuel.loginpasodeargumentos.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import perez.manuel.loginpasodeargumentos.R;
import perez.manuel.loginpasodeargumentos.daos.UsuariosDao;
import perez.manuel.loginpasodeargumentos.models.Usuario;

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
        titulo.setText(getIntent().getStringExtra("titulo"));
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsuariosDao dao = new UsuariosDao();
                boolean resultado = dao.usuExist(new Usuario(txtUsu.getText().toString(),txtPass.getText().toString()));

                Intent respuesta = new Intent();
                respuesta.putExtra("Resultado",resultado);
                setResult(MainActivity.LOGIN_INTENT_CODE,respuesta);
                finish();
            }
        });
    }
    // Metodo para deshabilitar el back
    @Override
    public void onBackPressed() {

    }
}
