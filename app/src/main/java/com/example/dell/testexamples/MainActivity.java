package com.example.dell.testexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendSMS(View view) {
        Intent intent = new Intent(this ,SMSActivity.class);
        startActivity(intent);
    }

    public void Calling(View view) {
        Intent intent = new Intent(this ,CallingActivity.class);
        startActivity(intent);

    }

    public void Google(View view) {
        Intent intent = new Intent(this,BrowserActivity.class);
        startActivity(intent);

    }

    public void Mail(View view) {
        Intent intent = new Intent(this, MailActivity.class);
        startActivity(intent);

    }

    public void Whatsapp(View view) {
        Intent intent = new Intent(this ,WhatsAapActivity.class);
        startActivity(intent);
    }

    public void Facebook(View view) {
        Intent intent = new Intent();
        startActivity(intent);

    }
}
