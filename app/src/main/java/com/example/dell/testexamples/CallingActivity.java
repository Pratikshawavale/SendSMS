package com.example.dell.testexamples;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CallingActivity extends AppCompatActivity {
    private  static final int REQUEST_CALL= 1;
    private EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);
        editText = findViewById(R.id.editText);

        ImageView imagecall = findViewById(R.id.imageCall);
        imagecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePHoneCall();
            }

        });
    }
            private void makePHoneCall() {
                String no = editText.getText().toString();
                if (no.trim().length() > 0) {
                    if (ContextCompat.checkSelfPermission(CallingActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(CallingActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                    } else {
                        String dail = "tel:" + no;
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dail)));
                    }
                } else {
                    Toast.makeText(CallingActivity.this, "Enter Phone number", Toast.LENGTH_LONG).show();
                }


            }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            if (requestCode==REQUEST_CALL){
                if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    makePHoneCall();
                }else{
                    Toast.makeText(CallingActivity.this,"Permission Granted",Toast.LENGTH_LONG).show();

                }
            }
        }

    }

