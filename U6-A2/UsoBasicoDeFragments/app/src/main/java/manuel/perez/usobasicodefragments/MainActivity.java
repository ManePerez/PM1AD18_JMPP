package manuel.perez.usobasicodefragments;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnFragA = (Button) findViewById(R.id.btnFragmentoA);
        final Button btnFragB = (Button) findViewById(R.id.btnFragmentoB);
        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getFragmentManager();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim)
                        .replace(R.id.contenedor, new FragmentA())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getFragmentManager();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim)
                        .replace(R.id.contenedor,new FragmentB())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}

