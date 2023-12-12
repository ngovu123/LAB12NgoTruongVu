package com.example.lab12_ngotruongvu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Timkiemso extends AppCompatActivity {

    EditText editTextSearchNumber;
    String enteredNumbers; // Dãy số đã nhập từ màn hình nhập dãy số

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiemso);

        editTextSearchNumber = findViewById(R.id.editTextSearchNumber);

        // Lấy dãy số đã nhập từ Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            enteredNumbers = extras.getString("enteredNumbers");
        }

        Button buttonSearchNumber = findViewById(R.id.buttonSearchNumber);
        buttonSearchNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberToSearch = editTextSearchNumber.getText().toString();
                // Xử lý tìm kiếm số trong dãy số đã nhập
                if (enteredNumbers != null && enteredNumbers.contains(numberToSearch)) {
                    Toast.makeText(Timkiemso.this, "Số " + numberToSearch + " có trong dãy số", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Timkiemso.this, "Số " + numberToSearch + " không có trong dãy số", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
