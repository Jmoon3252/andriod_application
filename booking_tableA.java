package com.example.homepage;

//following import all important libraries
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


public class booking_tableA extends AppCompatActivity {
    private Button button_meun; //define meun button
    private Button btn_booking;//define booking table button

    //to set datePickerDialog
        private DatePickerDialog datePickerDialog;
        private Button dateButton;
    //to set timePickerDialog
    int hour, minute;//define hour and minute variables
    Button timeButton;

    //define radio button
    private RadioGroup radioGroup;
    private RadioGroup radioGroup1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_booking_tablea);
            button_meun=findViewById(R.id.btn_meun);
            button_meun.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //call function of openbrista
                    openbarista();
                }
            });
            // this section for booking table to display/move to success page
            btn_booking=findViewById(R.id.btn_booking);
            btn_booking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //call function of openbooking success page
                    openbooking_success();
                }
            });

            initDatePicker();// create datapicker function
            dateButton = findViewById(R.id.datePickerButton);//for datapicker
            timeButton = findViewById(R.id.timeButton);//for timepicker
            dateButton.setText(getTodaysDate());// to get the data/text
            radioGroup = findViewById(R.id.radio_group);//for radio options
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                // this to set one option only
                public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
                  //switch-statement
                    switch (checkedButtonId) {//switch conditions
                        //first option which yes
                        case R.id.rb_option_yes:
                            //to show a pop message in same page
                            Toast.makeText(booking_tableA.this, "You select Yes", Toast.LENGTH_SHORT).show();
                            break;
                        //second option which no
                        case R.id.rb_option_no:
                            //to show a pop message in same page
                            Toast.makeText(booking_tableA.this, "You select No", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
            //set to check the radio options and clear the second option
            radioGroup.check(R.id.rb_option_yes);
            radioGroup.clearCheck();
            radioGroup.getCheckedRadioButtonId();

            //this for second group button options
            radioGroup1 = findViewById(R.id.radio_group1);
            radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup1, int checkedButtonId_1) {
                    //switch-statement
                    switch (checkedButtonId_1) {//switch conditions
                        //first option which yes
                        case R.id.btn_yes:
                            //to show a pop message in same page
                            Toast.makeText(booking_tableA.this, "You select Yes", Toast.LENGTH_SHORT).show();
                            break;
                        //second option which no
                        case R.id.btn_no:
                            //to show a pop message in same page
                            Toast.makeText(booking_tableA.this, "You select No", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
            //set to check the radio options and clear the second option
            radioGroup1.check(R.id.btn_yes);
            radioGroup1.clearCheck();
            radioGroup1.getCheckedRadioButtonId();
            }
//create new function for openbrista and link button to open/move brista page
  public void openbarista(){

      Intent intent5=new Intent(this, barista.class);
      startActivity(intent5);

  }
    //create new function for booking successfully and link button to open/move booking success page
    public void openbooking_success(){
        Intent intent6=new Intent(this, booking_success.class);
        startActivity(intent6);
    }
//create a new method to set the date
        private String getTodaysDate() {
            Calendar cal = Calendar.getInstance();//set Calender variable and get the instance function
            int year = cal.get(Calendar.YEAR);//define year variable
            int month = cal.get(Calendar.MONTH);//define year variable
            month = month + 1;//increase month by one
            int day = cal.get(Calendar.DAY_OF_MONTH); //define day variable and get the current day from calender from import library
            return makeDateString(day, month, year);//return the date
        }
//create new function for date picker
        private void initDatePicker() {
            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    month = month + 1;
                    String date = makeDateString(day, month, year);
                    dateButton.setText(date);//to set the date in date variable
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
//date string function
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


        //This timepicker section
    //create new function for time picker and it set to be pop displaying
    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            //set the time and define the variables
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
            }
        };
       int style = AlertDialog.THEME_HOLO_DARK;
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Please Select the Time You want");
        timePickerDialog.show();
    }//end of timepicker section

    }//end the code