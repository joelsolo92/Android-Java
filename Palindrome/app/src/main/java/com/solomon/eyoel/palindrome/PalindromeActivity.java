package com.solomon.eyoel.palindrome;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class PalindromeActivity extends AppCompatActivity {

    Button mSubmit;
    Button mClear;
    Button mQuit;
    EditText mValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);

        mSubmit = findViewById(R.id.btn_submit);
        mClear = findViewById(R.id.btn_clear);
        mQuit = findViewById(R.id.btn_quit);
        mValue = findViewById(R.id.edit_user_entry);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();
            }
        });
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue.setText("");
            }
        });
        mQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
<<<<<<< HEAD




=======
>>>>>>> cee260fa71315d6f6ff9df19206037be11269928
    }

    public void getValues() {

        String text = "";
        String regex = "[^a-zA-Z0-9]";
        String reversedText = "";
        text = mValue.getText().toString();

        if (text.isEmpty()) {
            Toast.makeText(this, "Fieid can not be empty.", Toast.LENGTH_SHORT).show();
            Log.e("this tag", "error");
        }else {
            String newText = text.replaceAll(regex, "");

            if (newText.length() < 3) {
                  Toast.makeText(this, "Your entry must contain atleast 3 letters / numbers", Toast.LENGTH_SHORT).show();
            }
            else {

                Log.e("tag", newText);

                Stack stack = new Stack();

                for (int x = 0; x < newText.length(); x++) {
                    stack.push(newText.charAt(x));
                }

                while (!stack.isEmpty()) {
                    reversedText = reversedText + stack.pop();
                }
                Log.e("tag", reversedText);
                if (newText.toLowerCase().equals(reversedText.toLowerCase()))
                    Toast.makeText(this, "\"" + text + "\" is a Palindrome", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "\"" + text + "\" is not a Palindrome", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
