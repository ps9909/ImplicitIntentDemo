package com.example.implicitintentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.editTextTextMultiLine);
        et2=findViewById(R.id.editTextTextPersonName2);
        et3=findViewById(R.id.editTextTextPersonName3);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String to =  et1.getText().toString();
               String subject =  et2.getText().toString();
               String message =  et3.getText().toString();

               Intent intent=new Intent(Intent.ACTION_SEND);

               intent.putExtra(Intent.EXTRA_EMAIL, new String[] {to});
               intent.putExtra(Intent.EXTRA_SUBJECT, subject);
               intent.putExtra(Intent.EXTRA_TEXT, message);

               intent.setType("message/rfc822");

               startActivity(Intent.createChooser(intent, "Choose your Client :"));
            }
        });
    }
}