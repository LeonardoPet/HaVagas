package com.example.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private EditText nomeEt;
    private EditText emailEt;
    private CheckBox checkBox;
    private EditText numeroEt;
    private RadioGroup telefoneRg;
    private RadioButton comercialRb;
    private Spinner telefoneCelularSp;
    private RadioGroup sexoRg;
    private RadioButton masculinoRb;
    private EditText dataNascEt;
    private Spinner formacaoSp;
    private EditText vagaEt;
    private LinearLayout CelularLl;
    private EditText numeroCelularEt;

    // Fundametal e Medio
    private LinearLayout formacaoMedioLl;
    private EditText anoFormaturaEt;

    //Graduação e Especialização
    private LinearLayout SuperiorLl;
    private EditText anoConclusaoEt;
    private EditText InstituicaoEt;

    //Mestrado e Doutoradao
    private LinearLayout mestradoDoutoradoLl;
    private EditText anoConclusaoMDEt;
    private EditText InstituicaoMDEt;
    private EditText tituloEt;
    private EditText orientadorEt;

    private ArrayList<String> formacaoAcademicaList;
    private ArrayList<String> telefoneCelularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calls();
        // Aparecer o campo Número de celular se clicar na opção "Adicionar Telefone"
        telefoneCelularList = new ArrayList<>((Arrays.asList(getResources().getStringArray(R.array.telefone_celular))));
        ArrayAdapter<String> telefoneCelularAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, telefoneCelularList);
        telefoneCelularSp.setAdapter(telefoneCelularAdapter);

        telefoneCelularSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                String telefoneCelular = ((TextView) view).getText().toString();
                if (telefoneCelularList.get(posicao).equals("Adicionar Telefone")) {
                    CelularLl.setVisibility(View.VISIBLE);
                } else {
                    CelularLl.setVisibility(View.GONE);
                    numeroCelularEt.setText("");

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

            // Aparecer o campo de Formação mediante a formação do usuário

            formacaoAcademicaList = new ArrayList<>((Arrays.asList(getResources().getStringArray(R.array.formacao_academica))));
            ArrayAdapter<String> formacaoAcademicaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, formacaoAcademicaList);
            formacaoSp.setAdapter(formacaoAcademicaAdapter);

            formacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                    String formacaoAcademica = ((TextView) view).getText().toString();
                    if (formacaoAcademicaList.get(posicao).equals("Fundamental") ||formacaoAcademicaList.get(posicao).equals("Medio") ) {
                        formacaoMedioLl.setVisibility(View.VISIBLE);
                    }else if(formacaoAcademicaList.get(posicao).equals("Graduação") ||formacaoAcademicaList.get(posicao).equals("Especialização")){
                        SuperiorLl.setVisibility(View.VISIBLE);
                    } else if(formacaoAcademicaList.get(posicao).equals("Mestrado") ||formacaoAcademicaList.get(posicao).equals("Doutorado")){
                        mestradoDoutoradoLl.setVisibility((View.VISIBLE));
                    }else {
                        formacaoMedioLl.setVisibility(View.GONE);
                        anoFormaturaEt.setText("");
                        SuperiorLl.setVisibility(View.GONE);
                        anoConclusaoEt.setText("");
                        InstituicaoEt.setText("");
                        mestradoDoutoradoLl.setVisibility(View.GONE);
                        anoConclusaoMDEt.setText("");
                        InstituicaoMDEt.setText("");
                        tituloEt.setText("");
                        orientadorEt.setText("");

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }

            });

    }

    //Click dos botões "Salvar" e "Limpar"
    public void onClick(View view){

        StringBuilder sb = new StringBuilder();
        sb.append(nomeEt.getText().toString());
        sb.append("\n");
        sb.append(emailEt.getText().toString());
        sb.append("\n");
        sb.append(checkBox.isChecked() ? "checado" : "não checado");
        sb.append("\n");
        sb.append(numeroEt.getText().toString());
        sb.append("\n");
        sb.append(comercialRb.isChecked() ? "Comercial":"Residencial");
        sb.append("\n");
        sb.append(((TextView)  telefoneCelularSp.getSelectedView()).getText());
        sb.append("\n");
        sb.append(masculinoRb.isChecked() ? "Masculino":"Feminino");
        sb.append("\n");
        sb.append(dataNascEt.getText().toString());
        sb.append("\n");
        sb.append(((TextView) formacaoSp.getSelectedView()).getText());
        sb.append("\n");
        sb.append(vagaEt.getText().toString());



        if(view.getId() == R.id.salvarBt){
            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
        }else{
            if(view.getId() == R.id.limparBt){
                Toast.makeText(this,"Botão limpar foi clicado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void calls(){
        nomeEt = findViewById(R.id.nomeEt);
        emailEt = findViewById(R.id.emailEt);
        checkBox = findViewById(R.id.checkBox);
        numeroEt = findViewById(R.id.numeroEt);
        telefoneRg = findViewById(R.id.telefoneRg);
        comercialRb = findViewById(R.id.comercialRb);
        telefoneCelularSp = findViewById(R.id.telefoneCelularSp);
        sexoRg = findViewById(R.id.sexoRg);
        masculinoRb = findViewById(R.id.masculinoRb);
        dataNascEt = findViewById(R.id.dataNascEt);
        formacaoSp = findViewById(R.id.formacaoSp);
        vagaEt = findViewById(R.id.vagaEt);
        CelularLl = findViewById(R.id.CelularLl);
        numeroCelularEt = findViewById(R.id.numeroCelularEt);
        formacaoMedioLl = findViewById(R.id.formacaoMedioLl);
        SuperiorLl = findViewById(R.id.SuperiorLl);
        mestradoDoutoradoLl = findViewById(R.id.mestradoDoutoradoLl);
        anoFormaturaEt = findViewById(R.id.anoFormaturaEt);
        anoConclusaoEt = findViewById((R.id.anoConclusaoEt));
        InstituicaoEt = findViewById(R.id.InstituicaoEt);
        anoConclusaoMDEt = findViewById(R.id.anoConclusaoMDEt);
        InstituicaoMDEt = findViewById(R.id.InstituicaoMDEt);
        tituloEt = findViewById(R.id.tituloEt);
        orientadorEt = findViewById(R.id.orientadorEt);

    }
}