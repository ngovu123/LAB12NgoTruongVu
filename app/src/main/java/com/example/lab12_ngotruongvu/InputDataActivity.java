package com.example.lab12_ngotruongvu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InputDataActivity extends Activity {

    Button btnSave1,btnSave2;
    EditText editNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
        btnSave1=(Button) findViewById(R.id.btnSave1);
        btnSave2=(Button) findViewById(R.id.btnSave2);
        btnSave1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                sendToMain(Nhapdulieu.RESULT_CODE_SAVE1);
            }
        });
        editNumber=(EditText) findViewById(R.id.editNumber);
        btnSave2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                sendToMain(Nhapdulieu.RESULT_CODE_SAVE2);
            }
        });
    }
    /**
     * hàm xử lý gửi kết quả về mainactivity
     * khi hàm này được gọi thì lập tức onActivityResult
     * ở MainActivity sẽ sảy ra đem theo ResultCode và Intent
     * @param resultcode
     */
    public void sendToMain(int resultcode)
    {
        Intent intent=getIntent();
        int value= Integer.parseInt(editNumber.getText()+"");
        intent.putExtra("data", value);
        setResult(resultcode, intent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inputdata, menu);
        return true;
    }
}