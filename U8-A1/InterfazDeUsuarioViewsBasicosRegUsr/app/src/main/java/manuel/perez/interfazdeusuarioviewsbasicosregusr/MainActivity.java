package manuel.perez.interfazdeusuarioviewsbasicosregusr;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class MainActivity extends AppCompatActivity {

    public static TextView txtHoraNacimiento, txtFechaNacimiento;
    public TextView txtUserName, txtPassword, txtNombrePila;
    public CheckBox chkJava, chkDotNet, chkPhyton;
    public RadioButton rdbMasculino, rdbFemenino;
    public Switch swNotificaciones;
    public ToggleButton tbPublicidad;
    public Spinner spOrigen;

    public ImageButton btnHoraNacimiento,btnFechaNacimiento;
    public Button btnGuardar;
    public static int year, month, date, hrs, min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserName = (EditText) findViewById(R.id.et_username);
        txtPassword = (EditText) findViewById(R.id.et_password);
        txtNombrePila = (EditText) findViewById(R.id.et_nombrePila);
        chkDotNet = (CheckBox) findViewById(R.id.cb_dotnet);
        chkJava = (CheckBox) findViewById(R.id.cb_java);
        chkPhyton = (CheckBox) findViewById(R.id.cb_phyton);
        rdbFemenino = (RadioButton) findViewById(R.id.rd_femenino);
        rdbMasculino = (RadioButton) findViewById(R.id.rd_masculino);
        swNotificaciones = (Switch) findViewById(R.id.sw_notificaciones);
        tbPublicidad = (ToggleButton) findViewById(R.id.tg_publicidad);
        spOrigen = (Spinner) findViewById(R.id.sp_origen);

        btnHoraNacimiento = (ImageButton)findViewById(R.id.ib_horaFechaNacimiento);
        btnFechaNacimiento = (ImageButton)findViewById(R.id.ib_calenFechaNacimiento);
        txtHoraNacimiento = (TextView) findViewById(R.id.tv_horaNacimiento);
        txtFechaNacimiento = (TextView) findViewById(R.id.tv_fechaNacimiento);
        btnGuardar = (Button) findViewById(R.id.btn_guardar);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Bajar todos los valores de los GUI Widgets a un pojo
                // Add the buttons
                builder.setTitle("Guardar");
                builder.setMessage("¿Esta seguro de que quiere guardar los datos?");
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        Usuario objUsr = new Usuario();
                        objUsr.setUsername(txtUserName.getText().toString());
                        objUsr.setPassword(txtPassword.getText().toString());
                        objUsr.setNombrePila(txtNombrePila.getText().toString());

                        String tecnologias = "";
                        tecnologias += (chkDotNet.isChecked())? ".NET;" : "";
                        tecnologias += (chkJava.isChecked())? "JAVA;" : "";
                        tecnologias += (chkPhyton.isChecked())? "PHYTON;":"";
                        objUsr.setTecnologias(tecnologias );

                        objUsr.setGenero((rdbFemenino.isChecked())?"FEMENINO":"MASCULINO");
                        objUsr.setNotificaciones(swNotificaciones.isChecked());
                        objUsr.setPublicidad(tbPublicidad.isChecked());
                        objUsr.setIes_origen(spOrigen.getSelectedItem().toString() );
                        objUsr.setFechaHoraNacimiento(new Date(year, month, date, hrs, min));

                        Toast.makeText(MainActivity.this, "Se guardó el usuario: "
                                + objUsr.toString(), Toast.LENGTH_LONG).show();
                        // Guardar un archivo
                        String FILENAME = "Usuario_file";
                        String datos= objUsr.toString();
                        try{
                            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                            OutputStreamWriter write = new OutputStreamWriter(fos);
                            BufferedWriter bw = new BufferedWriter(write);
                            PrintWriter pw= new PrintWriter(write);
                            pw.println(datos);
                            write.close();
                            Toast.makeText(MainActivity.this,"Datos escritos correctamente", Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this,"Error al escribir datos", Toast.LENGTH_SHORT).show();
                        }

                        // Leer un archivo
                        try{
                            FileInputStream fis = openFileInput(FILENAME);
                            InputStreamReader reader = new InputStreamReader(fis);
                            BufferedReader br = new BufferedReader(reader);
                            String datosFile= br.readLine();
                            fis.close();
                            reader.close();
                            Toast.makeText(MainActivity.this,datosFile,Toast.LENGTH_SHORT).show();
                        }catch (Exception e){

                        }
                        Toast.makeText(MainActivity.this, "Datos agregados",Toast.LENGTH_SHORT).show();
                    }

                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this,"Ha elegido no guardar el registro",Toast.LENGTH_LONG).show();
                    }
                });
// Set other dialog properties

// Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });



        btnHoraNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");
            }
        });
        btnFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });

    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            //Programar nuestro código en respuesta a que se seleccionó hora
            hrs = hourOfDay;
            min = minute;
            txtHoraNacimiento.setText("Hora:" + hourOfDay + " Minuto:" + minute);
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);

        }

        public void onDateSet(DatePicker view, int y, int m, int d) {
            // Do something with the date chosen by the user
            year = y;
            month = m+1;
            date = d;
            txtFechaNacimiento.setText("Día:" + date +
                    " Mes:" + month +
                    " Año:" + year);

        }
    }

}
