package com.solomon.eyoel.gradecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateGrade extends AppCompatActivity {

    // Global Variables
    TextView tvCalculatedGrade;
    Button btnClearAll, btnCalculate;
    EditText etAttendance, etProject1,etProject2, etProject3, etMidterm,etFinal;
    double dblAttendance, dblProject1, dblProject2, dblProject3, dblMidterm, dblFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_grade);


        // Assign ID's to TextViews, EditText's and Buttons
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        btnClearAll = (Button) findViewById(R.id.btn_clear_all);
        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        etAttendance = (EditText) findViewById(R.id.et_attendance);
        etProject1 = (EditText) findViewById(R.id.et_project_1);
        etProject2 = (EditText) findViewById(R.id.et_project_2);
        etProject3 = (EditText) findViewById(R.id.et_project_3);
        etMidterm = (EditText) findViewById(R.id.et_midterm);
        etFinal = (EditText) findViewById(R.id.et_final);
        tvCalculatedGrade = (TextView) findViewById(R.id.tv_calculated_grade);


        // Event handlers for the two buttons
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTextFields();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGrades();
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    // Calculates the user inputted grades and assigns a letter grade
    public void calculateGrades() {

        // The validateInput method returns true if the user has entered acceptable info.
        boolean isValidInput = validateInput();

        if (isValidInput) {
            double dblFinalGrade = dblAttendance + (dblProject1 * 0.15) + (dblProject2 * 0.15) +
                                   (dblProject3 * 0.15) + (dblMidterm * 0.20) + (dblFinal * 0.25);

            if (dblFinalGrade >= 94) { tvCalculatedGrade.setText("A"); }
            else if (dblFinalGrade >= 90 && dblFinalGrade < 94) { tvCalculatedGrade.setText("A-"); }
            else if (dblFinalGrade >= 87 && dblFinalGrade < 90) { tvCalculatedGrade.setText("B+"); }
            else if (dblFinalGrade >= 83 && dblFinalGrade < 87) { tvCalculatedGrade.setText("B"); }
            else if (dblFinalGrade >= 80 && dblFinalGrade < 83) { tvCalculatedGrade.setText("B-"); }
            else if (dblFinalGrade >= 77 && dblFinalGrade < 80) { tvCalculatedGrade.setText("C+"); }
            else if (dblFinalGrade >= 70 && dblFinalGrade < 77) { tvCalculatedGrade.setText("C"); }
            else if (dblFinalGrade >= 60 && dblFinalGrade < 70) { tvCalculatedGrade.setText("D"); }
            else { tvCalculatedGrade.setText("F"); }

            tvCalculatedGrade.setTextSize(24);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Method which validates the user info
    public boolean validateInput() {

        // Assign the entered values to string variables
        String attendance, project1, project2, project3, midterm, finalExam;

        attendance = etAttendance.getText().toString();
        project1 = etProject1.getText().toString();
        project2 = etProject2.getText().toString();
        project3 = etProject3.getText().toString();
        midterm = etMidterm.getText().toString();
        finalExam = etFinal.getText().toString();


        if(attendance.isEmpty() || project1.isEmpty() || project2.isEmpty() ||  // if no input was entered
                project3.isEmpty() || midterm.isEmpty() || finalExam.isEmpty())
        {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (Double.parseDouble(attendance) > 10) {  // if values for attendance field > 10
            Toast.makeText(this, "Attendance should be between 0-10", Toast.LENGTH_SHORT).show();
            return false;
        }
        else

            // convert string values to doubles after validation.
            dblAttendance = Double.parseDouble(String.format(attendance, "%.2f"));
            dblProject1 = Double.parseDouble(String.format(project1, "%.2f"));
            dblProject2 = Double.parseDouble(String.format(project2, "%.2f"));
            dblProject3 = Double.parseDouble(String.format(project3, "%.2f"));
            dblMidterm = Double.parseDouble(String.format(midterm, "%.2f"));
            dblFinal = Double.parseDouble(String.format(finalExam, "%.2f"));

            // check if the values entered are greater than max possible score (100)
            if (dblAttendance > 100 || dblProject1 > 100 || dblProject2 > 100 ||
                dblProject3 > 100 || dblMidterm > 100 || dblFinal > 100 )
            {
                Toast.makeText(this, "Please enter values between 0-100", Toast.LENGTH_SHORT).show();
                return false;
            }
            else
                return true;
    }

    // reset textfields to emptu state
    public void clearTextFields() {

        etAttendance.setText("");
        etProject1.setText("");
        etProject2.setText("");
        etProject3.setText("");
        etMidterm.setText("");
        etFinal.setText("");
        tvCalculatedGrade.setText("");

        Toast.makeText(this, "All fields cleared!", Toast.LENGTH_SHORT).show();
    }
}
