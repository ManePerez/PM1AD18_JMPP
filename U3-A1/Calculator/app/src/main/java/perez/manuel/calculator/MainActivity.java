package perez.manuel.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    Boolean sum=false,divic=false,res=false,multiplica=false;
    double operando1, operando2,resu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button suma = (Button) findViewById(R.id.btnSuma);
        Button resta = (Button) findViewById(R.id.btnResta);
        Button div = (Button) findViewById(R.id.btnDiv);
        Button mult = (Button) findViewById(R.id.btnMult);
        Button uno = (Button) findViewById(R.id.btnUno);
        Button dos = (Button) findViewById(R.id.btnDos);
        Button tres = (Button) findViewById(R.id.btnTres);
        Button cuatro = (Button) findViewById(R.id.btnCuatro);
        Button cinco = (Button) findViewById(R.id.btnCinco);
        Button seis = (Button) findViewById(R.id.btnSeis);
        Button siete = (Button) findViewById(R.id.btnSiete);
        Button ocho = (Button) findViewById(R.id.btnOcho);
        Button nueve = (Button) findViewById(R.id.btnNueve);
        Button cero = (Button) findViewById(R.id.btnCero);
        Button igual = (Button) findViewById(R.id.btnIgual);
        final TextView miTexto = (TextView) findViewById(R.id.txtTexto);
        Button clean = (Button)findViewById(R.id.btnClean);
        Button punto = (Button) findViewById(R.id.btnPunto);
        final TextView miResultado = (TextView) findViewById(R.id.txtResultado);

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miTexto.setText("");
                operando2=0;
                operando1=0;
                sum=false;
                res=false;
                divic=false;
                multiplica=false;
                miResultado.setText("");
            }
        });
        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    miResultado.setText("");
                    if(sum==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1+operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=true;
                        res=false;
                        divic=false;
                        multiplica=false;
                    }else if(res==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1-operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=true;
                        res=false;
                        divic=false;
                        multiplica=false;
                    }else if(divic==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1/operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=true;
                        res=false;
                        divic=false;
                        multiplica=false;
                    }else if(multiplica==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1*operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=true;
                        res=false;
                        divic=false;
                        multiplica=false;
                    }else{
                        miResultado.setText("");
                        operando1=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        sum=true;
                        res=false;
                        divic=false;
                        multiplica=false;
                    }
                }catch (Exception e){
                    Toast.makeText( MainActivity.this, "Operación no valida", Toast.LENGTH_SHORT).show();
                }

            }
        });
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    miResultado.setText("");
                    if(sum==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1+operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=true;
                        divic=false;
                        multiplica=false;
                    }else if(res==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1-operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=true;
                        divic=false;
                        multiplica=false;
                    }else if(divic==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1/operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=true;
                        divic=false;
                        multiplica=false;
                    }else if(multiplica==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1*operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=true;
                        divic=false;
                        multiplica=false;
                    }else{
                        miResultado.setText("");
                        operando1=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        res=true;
                        sum=false;
                        divic=false;
                        multiplica=false;
                    }
                }catch (Exception e){
                    Toast.makeText( MainActivity.this, "Operación no valida", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                try{
                    if(sum==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1+operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=false;
                        divic=false;
                        multiplica=true;
                    }else if(res==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1-operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=false;
                        divic=false;
                        multiplica=true;
                    }else if(divic==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1/operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=false;
                        divic=false;
                        multiplica=true;
                    }else if(multiplica==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1*operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=false;
                        divic=false;
                        multiplica=true;
                    }else{
                        miResultado.setText("");
                        operando1=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        res=false;
                        sum=false;
                        divic=false;
                        multiplica=true;
                    }
                }catch (Exception e){
                    Toast.makeText( MainActivity.this, "Operación no valida", Toast.LENGTH_SHORT).show();
                }

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    miResultado.setText("");
                    if(sum==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1+operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=false;
                        divic=true;
                        multiplica=false;
                    }else if(res==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1-operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=false;
                        divic=true;
                        multiplica=false;
                    }else if(divic==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1/operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=false;
                        divic=true;
                        multiplica=false;
                    }else if(multiplica==true){
                        miResultado.setText("");
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        resu=operando1*operando2;
                        miResultado.setText(resu+"");
                        operando1=resu;
                        operando2=0;
                        sum=false;
                        res=false;
                        divic=true;
                        multiplica=false;
                    }else{
                        miResultado.setText("");
                        operando1=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText("");
                        res=false;
                        sum=false;
                        divic=true;
                        multiplica=false;
                    }
                }catch (Exception e){
                    Toast.makeText( MainActivity.this, "Operación no valida", Toast.LENGTH_SHORT).show();
                }

            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    miResultado.setText("");
                    if(sum==true){
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText((operando1+operando2)+"");
                        sum=false;
                        res=false;
                        divic=false;
                        multiplica=false;
                    }else if(res==true){
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText((operando1-operando2)+"");
                        sum=false;
                        res=false;
                        divic=false;
                        multiplica=false;
                    }else if(multiplica==true){
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText((operando1*operando2)+"");
                        sum=false;
                        res=false;
                        divic=false;
                        multiplica=false;
                    }else if(divic==true){
                        operando2=Double.parseDouble(miTexto.getText().toString());
                        miTexto.setText((operando1/operando2)+"");
                        operando1=Double.parseDouble(miTexto.getText().toString());
                        sum=false;
                        res=false;
                        divic=false;
                        multiplica=false;
                    }else{
                        Toast.makeText( MainActivity.this, "Operación no valida", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText( MainActivity.this, "Operación no valida", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+"0";
                miTexto.setText(cadena);
            }
        });
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+"1";
                miTexto.setText(cadena);
            }
        });
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+"2";
                miTexto.setText(cadena);
            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+"3";
                miTexto.setText(cadena);
            }
        });
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+"4";
                miTexto.setText(cadena);
            }
        });
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+"5";
                miTexto.setText(cadena);
            }
        });
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+"6";
                miTexto.setText(cadena);
            }
        });
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+"7";
                miTexto.setText(cadena);
            }
        });
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+"8";
                miTexto.setText(cadena);
            }
        });
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+"9";
                miTexto.setText(cadena);
            }
        });

        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miResultado.setText("");
                String cadena=miTexto.getText()+".";
                miTexto.setText(cadena);
            }
        });

    }
}
