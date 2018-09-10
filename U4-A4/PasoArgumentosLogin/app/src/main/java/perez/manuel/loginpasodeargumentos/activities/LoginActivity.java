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
                Usuario usua = new Usuario();
                Bundle res = new Bundle();

                usua = dao.usuExist(new Usuario(txtUsu.getText().toString(),txtPass.getText().toString()));
                if (usua !=null){

                    Intent respuesta = getIntent();
                    Usuario obj = new Usuario(usua.getUsuario(),usua.getPassword(),usua.getApellidoP(),usua.getApellidoM(),usua.getEmail());

                    respuesta.putExtra("objeto",obj);
                    setResult(MainActivity.LOGIN_INTENT_CODE,respuesta);
                    finish();

                }else{
                    titulo.setText("Usuario no encontrado");
                }
            }
        });
    }
    // Metodo para deshabilitar el back
    @Override
    public void onBackPressed() {

    }
}
