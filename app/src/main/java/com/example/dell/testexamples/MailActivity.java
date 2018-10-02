package com.example.dell.testexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MailActivity extends AppCompatActivity {
    private EditText edtTo,edtSubject,edtMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        edtTo = findViewById(R.id.edtTo);
        edtSubject = findViewById(R.id.edtSubject);
        edtMessage = findViewById(R.id.edtMessage);

    Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMail();
            }
        });
        }
        private void SendMail(){
            String recipietList = edtTo.getText().toString();
            String[] recipiets = recipietList.split(",");
            String subject = edtSubject.getText().toString();
            String message = edtMessage.getText().toString();
            Intent intent =  new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL,recipiets);
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,message);
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent,"choose email client"));
        }
}
