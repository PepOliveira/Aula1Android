package com.example.aula1android;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity1 extends AppCompatActivity {
    private EditText editTextName, editTextAge;
    private Button btnCheck, btnBack;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1_idade);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        btnCheck = findViewById(R.id.btnCheck);
        textViewResult = findViewById(R.id.textViewResult);
        btnBack = findViewById(R.id.btnBack);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString();
                String ageText = editTextAge.getText().toString();

                if (!ageText.isEmpty()) {
                    int age = Integer.parseInt(ageText);

                    if (age >= 18) {
                        textViewResult.setText(name + ",segundo o sistema você é maior de idade!");
                    } else {
                        textViewResult.setText(name + ",segundo o sistema você é menor de idade!");
                    }
                } else {
                    textViewResult.setText("Por favor, insira sua idade.");
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}