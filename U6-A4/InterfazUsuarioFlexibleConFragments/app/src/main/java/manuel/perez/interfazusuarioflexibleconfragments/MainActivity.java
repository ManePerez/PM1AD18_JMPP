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

public class MainActivity extends AppCompatActivity implements MensualFragment.OnSemanaSeleccionada{
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
                    switch (position){
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

    @Override
    public void semanaSeleccionada(String nombreSemana) {
        String datosAPasar="";
        // aqui llegaria cuando en el fragment se selecciona una semana
        switch (nombreSemana){
            case "Sem1":
                // TODO: Paso 1- Cargar datos de la semana 1
                datosAPasar= "{sem:1, Semana1, l:300,m:200,mi:100,j:500,v:5}";
                break;
            case "Sem2":
                // TODO: Paso 1- Cargar datos de la semana 2
                datosAPasar= "{sem:2, Semana1, l:100,m:800,mi:700,j:100,v:2}";
                break;
            case "Sem3":
                // TODO: Paso 1- Cargar datos de la semana 3
                datosAPasar= "{sem:3, Semana1, l:600,m:100,mi:900,j:600,v:3}";
                break;
            case "Sem4":
                // TODO: Paso 1- Cargar datos de la semana 4
                datosAPasar= "{sem:4, Semana1, l:500,m:100,mi:300,j:400,v:9}";
                break;
        }
        Bundle bundleDatos= new Bundle();
        bundleDatos.putString("datos", datosAPasar);
        fragmentSemanal.setArguments(bundleDatos);

        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)//Opcional
                .replace(R.id.contenedorPrincipal, fragmentSemanal)
                .addToBackStack(null)
                .commit();
    }
}
