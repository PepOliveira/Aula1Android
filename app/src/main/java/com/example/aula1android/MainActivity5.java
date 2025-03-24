package com.example.aula1android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    private CheckBox checkBoxNotificacoes, checkBoxModoEscuro, checkBoxLembrarLogin;
    private Button btnSalvarPreferencias, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5_3checkbox);

        checkBoxNotificacoes = findViewById(R.id.checkBoxNotificacoes);
        checkBoxModoEscuro = findViewById(R.id.checkBoxModoEscuro);
        checkBoxLembrarLogin = findViewById(R.id.checkBoxLembrarLogin);
        btnSalvarPreferencias = findViewById(R.id.btnSalvarPreferencias);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnSalvarPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarPreferencias();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void salvarPreferencias() {

        StringBuilder preferencias = new StringBuilder();

        if (checkBoxNotificacoes.isChecked()) {
            preferencias.append("Receber notificações, ");
        }
        if (checkBoxModoEscuro.isChecked()) {
            preferencias.append("Modo escuro, ");
        }
        if (checkBoxLembrarLogin.isChecked()) {
            preferencias.append("Lembrar login, ");
        }


        if (preferencias.length() > 0) {
            preferencias.setLength(preferencias.length() - 2);

            Toast.makeText(this, "Preferências salvas: " + preferencias.toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Nenhuma preferência foi escolhida", Toast.LENGTH_SHORT).show();
        }
    }
}
