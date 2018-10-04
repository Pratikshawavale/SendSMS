package com.example.dell.testexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EmailActivity extends AppCompatActivity {
    private EditText edtTo,edtSubject,edtMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        edtTo = findViewById(R.id.edtTo);
        edtSubject = findViewById(R.id.edtSubject);
        edtMessage = findViewById(R.id.edtMessage);

    ImageView imageSend = findViewById(R.id.imageSend);
        imageSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMail();
            }
        });
        }
        private void SendMail(){
            boolean cancel = false;
            View focusView = null;

            String email = edtTo.getText().toString();
            String[] recipiets = email.split(",");
            String subject = edtSubject.getText().toString();
            String message = edtMessage.getText().toString();

            if (TextUtils.isEmpty(email)) {
                edtTo.setError(getString(R.string.error_field_required));
                focusView = edtTo;
                cancel = true;
            } else if (!isEmailValid(email)) {
                edtTo.setError(getString(R.string.error_invalid_email));
                focusView = edtTo;
                cancel = true;
            }
            if (cancel) {
                focusView.requestFocus();

                // form field with an error.
            }
            Intent intent =  new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL,recipiets);
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,message);
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent,"choose email client"));
            edtTo.setText( " " );
            edtMessage.setText( " " );
            edtSubject.setText( " " );

        }

    private boolean isEmailValid(String email) {
        return email.contains("@");

    }
}
