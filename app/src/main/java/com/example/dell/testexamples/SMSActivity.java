package com.example.dell.testexamples;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {

    private  static final int REQUEST_SMS= 11;

        EditText mobileno,message;
    ImageButton sendsms;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sms);

            mobileno=findViewById(R.id.editText1);
            message=findViewById(R.id.editText2);
            sendsms=findViewById(R.id.button1);
            if(checkPermission(Manifest.permission.SEND_SMS)){
                sendsms.setEnabled(true);
            }else{
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS},REQUEST_SMS);
            }
            sendsms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String msg = message.getText().toString();
                    String no = mobileno.getText().toString();
                    if (!TextUtils.isEmpty(msg) && !TextUtils.isEmpty(no)){
                        if (checkPermission(Manifest.permission.SEND_SMS)){
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(no, null,msg,null, null);
                            message.setText( " " );
                            mobileno.setText( " " );
                            Toast.makeText(SMSActivity.this, "text massge deliverd", Toast.LENGTH_LONG).show();

                        }else {
                            Toast.makeText(SMSActivity.this, "Permmission denied", Toast.LENGTH_LONG).show();
                        }
                        }else{
                        Toast.makeText(SMSActivity.this, "Permmission a message and a phone number", Toast.LENGTH_LONG).show();

                    }
                }
            });
        }
                private  boolean checkPermission(String permmision){
            int checkPermission = ContextCompat.checkSelfPermission(this,permmision);
            return  checkPermission == PackageManager.PERMISSION_GRANTED;
                }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            switch (requestCode){
                case REQUEST_SMS:
                    if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                        sendsms.setEnabled(true);
                    }break;
            }
        /*if (requestCode==REQUEST_SMS){
            if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                makePHoneCall();
            }else{
                Toast.makeText(CallingActivity.this,"Permission Granted",Toast.LENGTH_LONG).show();

            }
        }*/
    }
}
