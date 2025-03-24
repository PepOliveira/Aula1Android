package com.example.aula1android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private EditText editTextNome, editTextIdade, editTextUF, editTextCidade, editTextTelefone, editTextEmail;
    private RadioGroup radioGroupTamanho;
    private CheckBox checkBoxVermelho, checkBoxAzul, checkBoxVerde, checkBoxAmarelo;
    private Button btnCadastrar, btnVoltar;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_roupas);

        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        editTextUF = findViewById(R.id.editTextUF);
        editTextCidade = findViewById(R.id.editTextCidade);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextEmail = findViewById(R.id.editTextEmail);
        radioGroupTamanho = findViewById(R.id.radioGroupTamanho);
        checkBoxVermelho = findViewById(R.id.checkBoxVermelho);
        checkBoxAzul = findViewById(R.id.checkBoxAzul);
        checkBoxVerde = findViewById(R.id.checkBoxVerde);
        checkBoxAmarelo = findViewById(R.id.checkBoxAmarelo);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        textViewResultado = findViewById(R.id.textViewResultado);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void cadastrarUsuario() {
        String nome = editTextNome.getText().toString();
        String idade = editTextIdade.getText().toString();
        String uf = editTextUF.getText().toString();
        String cidade = editTextCidade.getText().toString();
        String telefone = editTextTelefone.getText().toString();
        String email = editTextEmail.getText().toString();

        int selectedTamanhoId = radioGroupTamanho.getCheckedRadioButtonId();
        String tamanho = "Nenhum tamanho selecionado";
        if (selectedTamanhoId != -1) {
            RadioButton selectedTamanho = findViewById(selectedTamanhoId);
            tamanho = selectedTamanho.getText().toString();
        }

        StringBuilder cores = new StringBuilder();
        if (checkBoxVermelho.isChecked()) cores.append("Vermelho, ");
        if (checkBoxAzul.isChecked()) cores.append("Azul, ");
        if (checkBoxVerde.isChecked()) cores.append("Rosa, ");
        if (checkBoxAmarelo.isChecked()) cores.append("Branco, ");
        if (cores.length() > 0) cores.setLength(cores.length() - 2);

        String resultado = "Seu cadastro realizado com sucesso!\n\n" +
                "Nome: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "UF: " + uf + "\n" +
                "Cidade: " + cidade + "\n" +
                "Telefone: " + telefone + "\n" +
                "Email: " + email + "\n" +
                "Tamanho: " + tamanho + "\n" +
                "Cores: " + cores.toString();

        textViewResultado.setText(resultado);
    }
}
