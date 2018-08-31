package perez.manuel.appciclodevida;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView miTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miTexto = (TextView) findViewById(R.id.txtState);
        miTexto.setMovementMethod(new ScrollingMovementMethod());
        Toast.makeText(this, "On Create", Toast.LENGTH_SHORT).show();
        Log.d("State", "On Create");
        miTexto.setText(miTexto.getText()+"\n On Create");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT).show();
        Log.d("State", "On Start");
        miTexto.setText(miTexto.getText()+"\n On Start");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
        Log.d("State", "On Resume");
        miTexto.setText(miTexto.getText()+"\n On Resume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT).show();
        Log.d("State", "On Pause");
        miTexto.setText(miTexto.getText()+"\n On Pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "On Stop", Toast.LENGTH_SHORT).show();
        Log.d("State", "On Stop");
        miTexto.setText(miTexto.getText()+"\n On Stop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT).show();
        Log.d("State", "On Destroy");
        miTexto.setText(miTexto.getText()+"\n On Destroy");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "On Restart", Toast.LENGTH_SHORT).show();
        Log.d("State", "On Restart");
        miTexto.setText(miTexto.getText()+"\n On Restart");
    }

}
