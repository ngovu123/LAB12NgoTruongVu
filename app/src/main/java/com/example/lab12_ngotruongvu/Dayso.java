package com.example.lab12_ngotruongvu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dayso extends AppCompatActivity {

    TextView textViewNumbers;
    List<Integer> enteredNumbers = new ArrayList<>();
    boolean sorted = false;

    private static final int ENTER_NUMBERS_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dayso);

        textViewNumbers = findViewById(R.id.textViewNumbers);

        Button buttonEnterNumbers = findViewById(R.id.buttonEnterNumbers);
        buttonEnterNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dayso.this, Nhapdayso.class);
                startActivityForResult(intent, ENTER_NUMBERS_REQUEST_CODE);
            }
        });

        Button buttonSort = findViewById(R.id.buttonSort);
        buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!enteredNumbers.isEmpty() && !sorted) {
                    Collections.sort(enteredNumbers);
                    sorted = true;
                    updateTextView();
                } else if (sorted) {
                    Toast.makeText(Dayso.this, "Dãy số đã được sắp xếp!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Dayso.this, "Vui lòng nhập dãy số trước khi sắp xếp", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonSearch = findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dayso.this, Timkiemso.class);
                intent.putExtra("enteredNumbers", convertListToString(enteredNumbers));
                startActivity(intent);
            }
        });

        Button buttonClose = findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Xử lý kết quả từ màn hình nhập dãy số
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ENTER_NUMBERS_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                enteredNumbers = data.getIntegerArrayListExtra("enteredNumbers");
                sorted = false;
                if (enteredNumbers != null && !enteredNumbers.isEmpty()) {
                    updateTextView();
                }
            }
        }
    }


    private void updateTextView() {
        StringBuilder sb = new StringBuilder("Dãy số: ");
        for (int i = 0; i < enteredNumbers.size(); i++) {
            sb.append(enteredNumbers.get(i));
            if (i < enteredNumbers.size() - 1) {
                sb.append(", ");
            }
        }
        textViewNumbers.setText(sb.toString());
    }


    private List<Integer> convertStringToList(String numbers) {
        List<Integer> list = new ArrayList<>();
        String[] numberArray = numbers.split("[,\\s]+");
        for (String number : numberArray) {
            try {
                list.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    private String convertListToString(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
