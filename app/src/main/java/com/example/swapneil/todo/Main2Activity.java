package com.example.swapneil.todo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    TextView t1, t2,t3,t4;
    EditText et1;
    Calendar c;
    int day, month, year, hour, minute;
    String s,enteredTitle,enteredDate,enteredTime;
    Switch simpleSwitch;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);

       // databaseReference = FirebaseDatabase.getInstance().getReference();

        //today 17-11-2017
        simpleSwitch = findViewById(R.id.switch1);
        et1=findViewById(R.id.editText);
        t1 = findViewById(R.id.textView3);
        t2 = findViewById(R.id.textView6);
        t3 = findViewById(R.id.textView4);
        t4 = findViewById(R.id.textView7);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button1);

        c = Calendar.getInstance();
        day = c.get(Calendar.DAY_OF_MONTH);
        month = c.get(Calendar.MONTH);
        year = c.get(Calendar.YEAR);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        t1.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE);
        t3.setVisibility(View.INVISIBLE);
        t4.setVisibility(View.INVISIBLE);

        /*final String enteredTitle = et1.getText().toString();
        final String enteredTime = t1.getText().toString();
        final String enteredDate = t2.getText().toString();*/


        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               enteredTitle=et1.getText().toString();
               enteredTime=t1.getText().toString();
               enteredDate=t2.getText().toString();

               if(enteredTitle.isEmpty() || enteredDate.isEmpty() || enteredTime.isEmpty()){
                   Toast.makeText(Main2Activity.this,"some fields are empty",Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(Main2Activity.this,"Success man",Toast.LENGTH_SHORT).show();

               }

               //Toast.makeText(Main2Activity.this,"clicked",Toast.LENGTH_SHORT).show();
            }
        });

        //today 18-11-2017
       // mDatabase = FirebaseDatabase.getInstance().getReference();

        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean on) {
                if (on){
                    //Toast.makeText(getApplicationContext(),"on",Toast.LENGTH_SHORT).show();
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                    t1.setVisibility(View.VISIBLE);
                    t2.setVisibility(View.VISIBLE);
                    t3.setVisibility(View.VISIBLE);
                    t4.setVisibility(View.VISIBLE);
                }
                else{
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                    t1.setVisibility(View.INVISIBLE);
                    t2.setVisibility(View.INVISIBLE);
                    t3.setVisibility(View.INVISIBLE);
                    t4.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    //for date
    public void date(View v) {
        new DatePickerDialog(this, db, day, (month + 1), year).show();
    }

    private DatePickerDialog.OnDateSetListener db = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            t1.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
        }
    };

    //for time
    public void time(View v) {
        new TimePickerDialog(this, tm, hour, minute, true).show();
        if (hour > 12) {
            s = "PM";
            hour = hour - 12;
        }
        else if (hour < 12) {
            s = "AM";
        }
        else {
            hour = 0;
        }
    }

    private TimePickerDialog.OnTimeSetListener tm = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            t2.setText(hourOfDay + " : " + minute + " " + s);
        }

    };


}
