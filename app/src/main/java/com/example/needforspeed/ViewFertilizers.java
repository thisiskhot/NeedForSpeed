package com.example.needforspeed;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class ViewFertilizers extends AppCompatActivity {

    TextView fromTextView;
    TextView typeTextView;
    TextView quantityTextView;
    TextView rateTextView;
    TextView descTextView;

    EditText editTextNumber;
    String value, checkvalue;
    int val1,val2;

    Set<String> set = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fertilizers);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        fromTextView = findViewById(R.id.fromTextView);
        typeTextView = findViewById(R.id.typeTextView);
        quantityTextView = findViewById(R.id.quantityTextView);
        rateTextView = findViewById(R.id.rateTextView);
        descTextView = findViewById(R.id.descTextView);

        editTextNumber = findViewById(R.id.EnterQunatityeditTextNumber);

        value = getIntent().getStringExtra("quantity");
        val1 = Integer.valueOf(value);

//            String fName = getIntent().getStringExtra("from");
//            String no = getIntent().getStringExtra("phone");
//            String Name = fName + " (" + no +" )";

        fromTextView.setText(getIntent().getStringExtra("from"));
        //fromTextView.setText(Name);
        typeTextView.setText(getIntent().getStringExtra("type"));
        quantityTextView.setText(getIntent().getStringExtra("quantity"));
        rateTextView.setText(getIntent().getStringExtra("rate"));
        descTextView.setText(getIntent().getStringExtra("description"));

    }

    public void addToCart(View view){

        SharedPreferences hashSetValue = getSharedPreferences("FerT_hashSet_value", 0);
        Set<String>  FertItemSet = hashSetValue.getStringSet("Fert_Final_List", null);

        Log.i("Item Set Value", String.valueOf(FertItemSet));

        checkvalue = editTextNumber.getText().toString();

        Log.i("Value of val1", String.valueOf(val1));
        Log.i("Value of val2", String.valueOf(val2));


        val2 = Integer.valueOf(checkvalue);


        if (val2 <= val1) {

            set.addAll(FertItemSet);

            //Collections.reverse(asList);
            //Log.i("Reversed List Value", String.valueOf(asList));

            String finalItem;

            finalItem = "Item: " + getIntent().getStringExtra("type") + "  Quantity: " + editTextNumber.getText().toString() + "  Rs: " + getIntent().getStringExtra("rate");

            Log.i("Type of XYZ", String.valueOf(finalItem));



            set.add(finalItem);









            Log.i("HashSet Value", String.valueOf(set));

            SharedPreferences hashSetValue5 = getSharedPreferences("FerT_hashSet_value", 0);
            SharedPreferences.Editor editor15 = hashSetValue5.edit();
            editor15.putStringSet("Fert_Final_List", set);
            editor15.commit();




            Toast.makeText(this, "Item Added!", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "Enter less quantity!", Toast.LENGTH_SHORT).show();

        }



    }

    public void DoneRef(View view){


        Intent intent = new Intent(this, farmer_buy_fertilizers.class);
        startActivity(intent);

    }

}