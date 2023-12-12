package com.example.lab12_ngotruongvu;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Nhapdulieu extends Activity {

    public static final int REQUEST_CODE_INPUT=113;
    public static final int RESULT_CODE_SAVE1=115;
    public static final int RESULT_CODE_SAVE2=116;
    Button btnInputData;
    ListView lvData;
    ArrayList<Integer>arrData=new ArrayList<Integer>();
    ArrayAdapter<Integer>adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhapdulieu);
        btnInputData =(Button) findViewById(R.id.btnopenactivity);
        btnInputData.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //Mở Activity với REQUEST_CODE_INPUT
                Intent intent=new Intent(Nhapdulieu.this, InputDataActivity.class);
                //gọi startActivityForResult
                startActivityForResult(intent, REQUEST_CODE_INPUT);
            }
        });
        lvData=(ListView) findViewById(R.id.lvdata);
        adapter=new ArrayAdapter<Integer>
                (this,
                        android.R.layout.simple_list_item_1,
                        arrData);
        lvData.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_INPUT)
        {
            switch(resultCode)
            {
                case RESULT_CODE_SAVE1:
                    int v1= data.getIntExtra("data", 0);
                    arrData.add(v1*v1);
                    adapter.notifyDataSetChanged();
                    break;
                case RESULT_CODE_SAVE2:
                    int v2= data.getIntExtra("data", 0);
                    arrData.add(v2);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nhapdulieu, menu);
        return true;
    }

}