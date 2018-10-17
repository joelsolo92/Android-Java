package com.solomon.eyoel.palindrome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PalindromeActivity extends AppCompatActivity {

    Button btnSubmit;
    Button btnClear;
    Button btnQuit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);

        btnSubmit = findViewById(R.id.btn_submit);
        btnClear = findViewById(R.id.btn_clear);
        btnQuit = findViewById(R.id.btn_quit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();
            }
        });

    }

    public void getValues() {

        String text = "";
        text = btnSubmit.getText().toString();

        if (text == ""){
            Toast.makeText(this, "Fieid can not be empty.", Toast.LENGTH_SHORT).show();
        }
    }
}
