package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import java.util.Calendar;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import java.util.Locale;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class booking_tableB extends AppCompatActivity {
    private Button button_meun; //define meun button
    private Button btn_booking;//define booking table button

    //to set datePickerDialog
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    //to set timePickerDialog
    Button timeButton;
    int hour, minute;
    //define groups_radio button
    private RadioGroup radioGroup;
    private RadioGroup radioGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_tableb);
        button_meun = findViewById(R.id.btn_meun);
        button_meun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmc();
            }
        });
        btn_booking = findViewById(R.id.btn_booking);
        btn_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbooking_success();
            }
        });

        initDatePicker();//datapicker function
        dateButton = findViewById(R.id.datePickerButton);
        timeButton = findViewById(R.id.timeButton);
        dateButton.setText(getTodaysDate());
        radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
                switch (checkedButtonId) {
                    case R.id.rb_option_yes:
                        Toast.makeText(booking_tableB.this, "You select Yes", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_option_no:
                        Toast.makeText(booking_tableB.this, "You select No", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        radioGroup.check(R.id.rb_option_yes);
        radioGroup.clearCheck();
        radioGroup.getCheckedRadioButtonId();

        //this for second group button options
        radioGroup1 = findViewById(R.id.radio_group1);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup1, int checkedButtonId_1) {
                switch (checkedButtonId_1) {
                    case R.id.btn_yes:
                        Toast.makeText(booking_tableB.this, "You select Yes", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn_no:
                        Toast.makeText(booking_tableB.this, "You select No", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        radioGroup1.check(R.id.btn_yes);
        radioGroup1.clearCheck();
        radioGroup1.getCheckedRadioButtonId();
    }

    public void openmc() {
        Intent intent5 = new Intent(this, mc.class);
        startActivity(intent5);

    }

    public void openbooking_success() {
        Intent intent6 = new Intent(this, booking_success.class);
        startActivity(intent6);
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    //months function
    private String getMonthFormat(int month) {
        if(month == 1)
            return "January";
        if(month == 2)
            return "February";
        if(month == 3)
            return "March";
        if(month == 4)
            return "April";
        if(month == 5)
            return "May";
        if(month == 6)
            return "June";
        if(month == 7)
            return "July";
        if(month == 8)
            return "August";
        if(month == 9)
            return "September";
        if(month == 10)
            return "October";
        if(month == 11)
            return "November";
        if(month == 12)
            return "December";

        //default variable as January should never happen
        return "January";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    //coding timepicker
    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
            }
        };
        int style = AlertDialog.THEME_HOLO_DARK;
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Please Select the Time You want");
        timePickerDialog.show();
    }

}