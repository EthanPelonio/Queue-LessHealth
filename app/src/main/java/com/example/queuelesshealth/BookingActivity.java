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