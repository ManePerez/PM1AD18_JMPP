package manuel.perez.interfazusuarioflexibleconfragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MensualFragment extends Fragment {

    private OnSemanaSeleccionada actividadObserver;
    private Button btnSemana1,btnSemana2,btnSemana3,btnSemana4;

    public MensualFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mensual,container, false);
        btnSemana1= view.findViewById(R.id.btnsem_1);
        btnSemana2= view.findViewById(R.id.btnsem_2);
        btnSemana3= view.findViewById(R.id.btnsem_3);
        btnSemana4= view.findViewById(R.id.btnsem_4);

        btnSemana1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actividadObserver.semanaSeleccionada("Sem1");
            }
        });
        btnSemana2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actividadObserver.semanaSeleccionada("Sem2");
            }
        });
        btnSemana3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actividadObserver.semanaSeleccionada("Sem3");
            }
        });
        btnSemana4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actividadObserver.semanaSeleccionada("Sem4");
            }
        });
        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        actividadObserver=(OnSemanaSeleccionada) activity;
        super.onAttach(activity);
    }
    public interface OnSemanaSeleccionada{
        public void semanaSeleccionada(String nombreSemana);
    }
}
