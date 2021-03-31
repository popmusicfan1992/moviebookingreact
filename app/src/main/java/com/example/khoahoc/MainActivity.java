package com.example.khoahoc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.khoahoc.model.Country;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> listData;
    private ArrayAdapter<String> adapter;
    private Context context;
    private Button button,btnCapNhat;
    private EditText editText;
    private int vitri = -1;
    private ArrayList<Country> arrayList;
    CountryAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.hocandroid);
        context = this;

        listView = (ListView) findViewById(R.id.lv);
        button = (Button) findViewById(R.id.btn);
        editText = (EditText) findViewById(R.id.edittext);
        btnCapNhat = (Button) findViewById(R.id.btn_update);
       // listData = context.getResources().getStringArray(R.array.listVideo);

        listData = new ArrayList<>();
        listData.add("Bài 1");
        listData.add("Bài 2");
        listData.add("Bài 3");


        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(context,listData.get(position),Toast.LENGTH_SHORT).show();
                editText.setText(listData.get(position));
                vitri = position;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listData.set(vitri,editText.getText().toString().trim());
                adapter.notifyDataSetChanged();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editText.getText().toString().trim();
                if(TextUtils.isEmpty(item)){
                    Toast.makeText(context,"Bạn chưa nhập dữ liệu",Toast.LENGTH_SHORT).show();
                    return;
                }
                listData.add(item);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Xác nhận");
                dialog.setMessage("Bạn có đồng ý xóa ko");
                dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listData.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });

    }

}