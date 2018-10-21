package manuel.perez.interfazusuarioflexibleconfragments;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    InicioFragment fragmentInicio;
    SemanalFragment fragmentSemanal;
    MensualFragment fragmentMensual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentInicio = new InicioFragment();
        fragmentSemanal = new SemanalFragment();
        fragmentMensual = new MensualFragment();
        BottomNavigationView toolbarPrincipal = findViewById(R.id.toolbarPrincipal);
        ListView listaMenu= findViewById(R.id.menuListPrincipal);

        if(toolbarPrincipal!=null){
            toolbarPrincipal.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                            switch (menuItem.getItemId()){
                                case R.id.actionInicio:
                                    getSupportFragmentManager()
                                            .beginTransaction()
                                            .replace(R.id.contenedorPrincipal, fragmentInicio)
                                            .addToBackStack(null)
                                            .commit();
                                    // Cambiar a fragment inicio, poner un toast
                                    break;
                                case R.id.actionMensual:
                                    getSupportFragmentManager()
                                            .beginTransaction()
                                            .replace(R.id.contenedorPrincipal, fragmentMensual)
                                            .addToBackStack(null)
                                            .commit();
                                    // Cambiar a fragment mensual
                                    break;
                                case R.id.actionSemanal:
                                    getSupportFragmentManager()
                                            .beginTransaction()
                                            .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)//Opcional
                                            .replace(R.id.contenedorPrincipal, fragmentSemanal)
                                            .addToBackStack(null)
                                            .commit();
                                    // Cambiar a fragment semanal
                                    break;
                            }
                            return false;
                        }
                    }
            );

        }else{
            listaMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch(position){
                        case 0:
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.contenedorPrincipal, fragmentInicio)
                                    .addToBackStack(null)
                                    .commit();
                            // Cambiar a fragment inicio, poner un toast
                            break;
                        case 1:
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.contenedorPrincipal, fragmentMensual)
                                    .addToBackStack(null)
                                    .commit();
                            // Cambiar a fragment mensual
                            break;
                        case 2:
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)//Opcional
                                    .replace(R.id.contenedorPrincipal, fragmentSemanal)
                                    .addToBackStack(null)
                                    .commit();
                            // Cambiar a fragment semanal
                            break;
                    }
                }
            });
        }

    }
}
