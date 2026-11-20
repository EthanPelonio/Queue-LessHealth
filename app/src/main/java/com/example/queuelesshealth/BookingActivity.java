package com.example.queuelesshealth;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity {

    // Patient Information
    private EditText etFullName, etAge, etReason;

    // Spinners
    private Spinner spGender, spPriorityCategory;

    // Patient Type
    private RadioGroup rgPatientType;

    // Buttons
    private MaterialButton btnDate, btnTime;
    private MaterialButton btnSlot9, btnSlot1030, btnSlot2;
    private MaterialButton btnConfirmBooking;

    // Selected Appointment Details
    private String selectedDate = "";
    private String selectedTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_8);

        initViews();
        setupSpinners();
        setupPatientType();
        setupDatePicker();
        setupTimePicker();
        setupTimeSlots();
        setupConfirmButton();
    }

    // 1. INITIALIZE VIEWS
    private void initViews() {

        etFullName = findViewById(R.id.etFullName);
        etAge = findViewById(R.id.etAge);
        etReason = findViewById(R.id.etReason);

        // Ensure text and hints are visible on light backgrounds
        int darkText = Color.parseColor("#111827");
        int hintGray = Color.parseColor("#6B7280");

        etFullName.setTextColor(darkText);
        etFullName.setHintTextColor(hintGray);

        etAge.setTextColor(darkText);
        etAge.setHintTextColor(hintGray);

        etReason.setTextColor(darkText);
        etReason.setHintTextColor(hintGray);

        spGender = findViewById(R.id.spGender);
        spPriorityCategory = findViewById(R.id.spPriorityCategory);

        rgPatientType = findViewById(R.id.rgPatientType);

        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);

        btnSlot9 = findViewById(R.id.btnSlot9);
        btnSlot1030 = findViewById(R.id.btnSlot1030);
        btnSlot2 = findViewById(R.id.btnSlot2);

        btnConfirmBooking = findViewById(R.id.btnConfirmBooking);
    }
