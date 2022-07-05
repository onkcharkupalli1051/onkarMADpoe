package com.maverick.onkarmadpoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] myString;
    private EditText ETnumber;
    private Button BTNnext;
    private TextView TVanswer;
    private int num;
    private int index;
    ArrayList<String> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ETnumber = findViewById(R.id.ETnumber);
        BTNnext = findViewById(R.id.ButtonNext);
        TVanswer = findViewById(R.id.TVAnswer);
        myString = new String[100];
        index = 0;

        char X = 'X', Y = 'Y', Z = 'Z';

        BTNnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(ETnumber.getText().toString());
                towerOfHanoi(num, X,Y,Z,array);
//                TVanswer.setText((String) array.get(index));

                TVanswer.setText(TVanswer.getText().toString()+"\n"+array.get(index));
                index++;
            }
        });
    }

    void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod, ArrayList<String> array)
    {
        if (n == 1)
        {
            array.add("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }

        towerOfHanoi(n-1, from_rod, aux_rod, to_rod,array);
        array.add("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod,array);
    }
}