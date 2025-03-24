package com.example.aula1android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    private EditText editTextNome;
    private Button btnGerarCheckboxes, btnVoltar;
    private LinearLayout linearLayoutCheckboxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_checkbox);

        editTextNome = findViewById(R.id.editTextNome);
        btnGerarCheckboxes = findViewById(R.id.btnGerarCheckboxes);
        linearLayoutCheckboxes = findViewById(R.id.linearLayoutCheckboxes);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnGerarCheckboxes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarCheckboxes();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void gerarCheckboxes() {
        linearLayoutCheckboxes.removeAllViews();

        String nome = editTextNome.getText().toString();

        if (!nome.isEmpty()) {
            for (int i = 0; i < nome.length(); i++) {
                char letra = nome.charAt(i);

                CheckBox checkBox = new CheckBox(this);
                checkBox.setText(String.valueOf(letra));
                checkBox.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));

                linearLayoutCheckboxes.addView(checkBox);
            }
        } else {
            editTextNome.setError("Por favor, digite um nome.");
        }
    }
}
