package com.example.lab12_ngotruongvu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cau1intentresult(View view){
        Toast.makeText(getApplicationContext(), "cau1intentresult", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, Nhapdulieu.class);
        startActivity(intent);
    }
    public void cau2dayso(View view){
        Toast.makeText(getApplicationContext(), "cau2dayso", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, Dayso.class);
        startActivity(intent);
    }
}