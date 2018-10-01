package com.example.dell.testexamples;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {


        EditText mobileno,message;
        Button sendsms;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sms);

            mobileno=findViewById(R.id.editText1);
            message=findViewById(R.id.editText2);
            sendsms=findViewById(R.id.button1);
            sendsms.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    String no=mobileno.getText().toString();
                    String msg=message.getText().toString();
                   Intent intent=new Intent(getApplicationContext(),SMSActivity.class);
                   PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                    SmsManager sms= SmsManager.getDefault();
                   // sms.sendTextMessage(no, null, msg, pi,null);
                   Toast.makeText(getApplicationContext(), "Message Sent successfully!",


                           Toast.LENGTH_LONG).show();
                   /* Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("smsto"+mobileno.getText().toString()));
                    intent.putExtra("sms_body:"+message.getText().toString());
                    startActivity(intent);*/


                }
            });
        }

       /* @Override
        public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_SMS, menu);
        return true;
    }*/


}
