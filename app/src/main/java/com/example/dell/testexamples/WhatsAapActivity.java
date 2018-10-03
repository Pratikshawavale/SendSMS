package com.example.dell.testexamples;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WhatsAapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_aap);

        final ImageView image = findViewById(R.id.image);
        ImageView imagetext = findViewById(R.id.imagetext);
        ImageView Shareimage = findViewById(R.id.Shareimage);

        imagetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Write ur subject");
                intent.putExtra(Intent.EXTRA_TEXT,"text");
                startActivity(Intent.createChooser(intent, "share text "));

            }
        });
        Shareimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = image.getDrawable();
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                //shareing image
                try {
                    File file = new File(WhatsAapActivity.this.getExternalCacheDir(), "phote.jpg");
                    FileOutputStream fout = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 80,fout);
                    fout.flush();
                    fout.flush();
                    file.setReadable(true,false);
                    //shareing intent
                    Intent intent = new  Intent(Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                    intent.setType("image/png");
                    startActivity(Intent.createChooser(intent, "share image "));

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText(WhatsAapActivity.this, "file not found", Toast.LENGTH_LONG).show();

                }catch (IOException e){
                    e.printStackTrace();
                    }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
