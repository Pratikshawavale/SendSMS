package com.example.dell.testexamples;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BrowserActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        button = findViewById(R.id.button);
        editText =  findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=editText.getText().toString();

                /*if (TextUtils.isEmpty(url)) {

                    Toast.makeText(BrowserActivity.this, " plz enter right url", Toast.LENGTH_LONG).show();

                }*/
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // intent.setData(Uri.parse("http://www.javatpoint.com"));
                startActivity(intent);
                editText.setText( " " );
                }
        });
    }
}
