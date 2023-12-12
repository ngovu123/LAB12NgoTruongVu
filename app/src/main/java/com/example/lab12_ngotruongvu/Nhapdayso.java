package com.example.lab12_ngotruongvu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Nhapdayso extends AppCompatActivity {

    EditText editTextEnterNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhapdayso);

        editTextEnterNumbers = findViewById(R.id.editTextEnterNumbers);

        Button buttonEnter = findViewById(R.id.buttonEnter);
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredNumbers = editTextEnterNumbers.getText().toString();
                // Chia chuỗi thành các số nguyên dựa trên dấu phẩy hoặc khoảng trắng
                String[] numbersArray = enteredNumbers.split("[,\\s]+");

                // Chuyển mảng chuỗi thành List<Integer>
                List<Integer> numbersList = new ArrayList<>();
                for (String number : numbersArray) {
                    try {
                        int num = Integer.parseInt(number.trim());
                        numbersList.add(num);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

                // Gửi dãy số về màn hình chính
                Intent intent = new Intent();
                intent.putIntegerArrayListExtra("enteredNumbers", (ArrayList<Integer>) numbersList);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
