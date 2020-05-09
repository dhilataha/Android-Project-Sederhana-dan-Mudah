package com.example.asus.tugasmobilebab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    Button bCancel, bOk;
    EditText eNama, eNim;
    String tempNama, tempNim, tempRadio, tempSpinner;
    RadioGroup rJenisKelamin;
    RadioButton rFemale, rMale;
    Spinner sAgama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bCancel = (Button) findViewById(R.id.xCancel);
        bCancel.setOnClickListener(this);
        bOk = (Button) findViewById(R.id.xOk);
        bOk.setOnClickListener(this);
        eNama = (EditText) findViewById(R.id.xNama);
        eNim = (EditText) findViewById(R.id.xNim);
        rJenisKelamin = (RadioGroup) findViewById(R.id.xJk);
        rFemale =(RadioButton) findViewById(R.id.xFemale);
        rMale = (RadioButton) findViewById(R.id.xMale);
        sAgama = (Spinner) findViewById(R.id.xListAgama);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.list_agama, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sAgama.setAdapter(adapter);
    }
    public void onClick (View v){
        switch (v.getId()){
            case R.id.xOk:
                int selectedId = rJenisKelamin.getCheckedRadioButtonId();
                if (selectedId == rFemale.getId()){
                    tempRadio = rFemale.getText().toString();
                }else if (selectedId == rMale.getId()){
                    tempRadio = rMale.getText().toString();
                }
                tempNama = eNama.getText().toString();
                tempNim = eNim.getText().toString();
                tempSpinner = sAgama.getSelectedItem().toString();
                Toast.makeText(this, "Nama saya "+tempNama + "\nNim saya "+tempNim +"\njenis kelamin "+tempRadio +"\nagama "+tempSpinner,
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.xCancel:
                AlertDialog.Builder d = new AlertDialog.Builder(this);
                d.setTitle("Konfirmasi Keluar");
                d.setMessage("Anda Yakin Ingin Keluar? ");
                d.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                d.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                d.setCancelable(false);
                d.show();
                break;
        }
    }
}
