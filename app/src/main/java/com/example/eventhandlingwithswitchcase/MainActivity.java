package com.example.eventhandlingwithswitchcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //globally declare
    ListView lv,lv1;
    Spinner sp;
    String[] countries;
    String[] price;
    String[] quantity;
    EditText et;
    double inputPrice;
    double inputQuantity;
    ArrayAdapter<String> adapter,adapter2,adapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id die view find kora
        lv = (ListView) findViewById(R.id.list_item);
        et = (EditText)findViewById(R.id.et_id);
        sp =(Spinner)findViewById(R.id.spinnerId);
        lv1 = (ListView)findViewById(R.id.list_item2);
        //string resource file theke array nie asha
        countries = getResources().getStringArray(R.array.countries);
        price =getResources().getStringArray(R.array.price);
        quantity = getResources().getStringArray(R.array.quantity);

        //listview populate kora
        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,countries);
        adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,price);
        adapter3 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item,quantity);

        lv.setAdapter(adapter);
        lv1.setAdapter(adapter2);
        sp.setAdapter(adapter3);

        //each item er upor click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //list view item er postion ta newa
            String posi = countries[position];

                Toast.makeText(getApplicationContext(),
                        posi,Toast.LENGTH_LONG).show();

                //list view item pawar second way
                String posi2 = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),
                        posi2,Toast.LENGTH_LONG).show();
//3rd way, textview coz listView er item ak akta textview
                TextView tv =(TextView) view;
                String item = tv.getText().toString();
                 et.setText(item);
//                Toast.makeText(getApplicationContext(),
//                       item,Toast.LENGTH_LONG).show();


            }
        });

        //second list view

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv =(TextView) view;
                String item = tv.getText().toString();
                et.setText(item);
                 inputPrice = Double.parseDouble(item);
            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv =(TextView) view;
                String item1 = tv.getText().toString();
                et.setText(item1);
                 inputQuantity = Double.parseDouble(item1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
       });
        (findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = inputPrice*inputQuantity;
                Intent ii = new Intent(MainActivity.this,MainActivity2.class);
                ii.putExtra("key1",Double.toString(result));
                 startActivity(ii);
            }
        });
    }
}