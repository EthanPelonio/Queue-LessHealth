package com.example.queuelesshealth;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity {

    private static final int DARK_TEXT = Color.parseColor("#111827");
    private static final int HINT_GRAY = Color.parseColor("#6B7280");

    private EditText etFullName, etAge, etReason;
    private Spinner spGender, spPriorityCategory;
    private RadioGroup rgPatientType;
    private MaterialButton btnDate, btnTime;
    private MaterialButton btnSlot9, btnSlot1030, btnSlot2;
    private MaterialButton btnConfirmBooking;

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

    private void initViews() {
        etFullName = findViewById(R.id.etFullName);
        etAge = findViewById(R.id.etAge);
        etReason = findViewById(R.id.etReason);

        etFullName.setTextColor(DARK_TEXT);
        etFullName.setHintTextColor(HINT_GRAY);

        etAge.setTextColor(DARK_TEXT);
        etAge.setHintTextColor(HINT_GRAY);

        etReason.setTextColor(DARK_TEXT);
        etReason.setHintTextColor(HINT_GRAY);

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

    private void setupSpinners() {
        setupGenderSpinner();
        setupPrioritySpinner();
    }

    private ArrayAdapter<String> createDarkSpinnerAdapter(String[] items) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                items
        ) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);
                if (textView != null) {
                    textView.setTextColor(DARK_TEXT);
                }
                return view;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);
                if (textView != null) {
                    textView.setTextColor(DARK_TEXT);
                    textView.setBackgroundColor(Color.WHITE);
                }
                return view;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    private void setupGenderSpinner() {
        String[] genderOptions = {
                "Select Gender",
                "Male",
                "Female",
                "Other"
        };
        spGender.setAdapter(createDarkSpinnerAdapter(genderOptions));
    }

    private void setupPrioritySpinner() {
        String[] priorityOptions = {
                "Select Priority Category",
                "Senior Citizen",
                "Person with Disability (PWD)",
                "Pregnant"
        };
        spPriorityCategory.setAdapter(createDarkSpinnerAdapter(priorityOptions));
    }

    private void setupPatientType() {
        spPriorityCategory.setEnabled(false);

        rgPatientType.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbPriority) {
                spPriorityCategory.setEnabled(true);
            } else {
                spPriorityCategory.setEnabled(false);
                spPriorityCategory.setSelection(0);
            }
        });
    }

    private void setupDatePicker() {
        btnDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker = new DatePickerDialog(
                    BookingActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        selectedDate = String.format(
                                Locale.US,
                                "%02d/%02d/%04d",
                                selectedDay,
                                selectedMonth + 1,
                                selectedYear
                        );
                        btnDate.setText(selectedDate);
                    },
                    year,
                    month,
                    day
            );

            datePicker.getDatePicker().setMinDate(System.currentTimeMillis());
            datePicker.show();
        });
    }

    private void setupTimePicker() {
        btnTime.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePicker = new TimePickerDialog(
                    BookingActivity.this,
                    (view, selectedHour, selectedMinute) -> {
                        String amPm = selectedHour < 12 ? "AM" : "PM";

                        int displayHour = selectedHour % 12;
                        if (displayHour == 0) {
                            displayHour = 12;
                        }

                        selectedTime = String.format(
                                Locale.US,
                                "%d:%02d %s",
                                displayHour,
                                selectedMinute,
                                amPm
                        );
                        btnTime.setText(selectedTime);
                    },
                    hour,
                    minute,
                    false
            );

            timePicker.show();
        });
    }

    private void setupTimeSlots() {
        btnSlot9.setOnClickListener(v -> {
            selectedTime = "9:00 AM";
            btnTime.setText(selectedTime);
        });

        btnSlot1030.setOnClickListener(v -> {
            selectedTime = "10:30 AM";
            btnTime.setText(selectedTime);
        });

        btnSlot2.setOnClickListener(v -> {
            selectedTime = "2:00 PM";
            btnTime.setText(selectedTime);
        });
    }

    private void setupConfirmButton() {
        btnConfirmBooking.setOnClickListener(v -> {
            String patientName = etFullName.getText().toString().trim();
            String age = etAge.getText().toString().trim();
            String reason = etReason.getText().toString().trim();
            String gender = spGender.getSelectedItem().toString();

            if (patientName.isEmpty()) {
                etFullName.setError("Please enter your full name!");
                etFullName.requestFocus();
                return;
            }

            if (age.isEmpty()) {
                etAge.setError("Please enter your age!");
                etAge.requestFocus();
                return;
            }

            int patientAge;
            try {
                patientAge = Integer.parseInt(age);
            } catch (NumberFormatException e) {
                etAge.setError("Please enter a valid age!");
                etAge.requestFocus();
                return;
            }

            if (patientAge < 1 || patientAge > 120) {
                etAge.setError("Please enter a valid age!");
                etAge.requestFocus();
                return;
            }

            if (spGender.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Please select your gender!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (reason.isEmpty()) {
                etReason.setError("Please enter your reason for appointment!");
                etReason.requestFocus();
                return;
            }

            if (selectedDate.isEmpty()) {
                Toast.makeText(this, "Please select an appointment date!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedTime.isEmpty()) {
                Toast.makeText(this, "Please select an appointment time!", Toast.LENGTH_SHORT).show();
                return;
            }

            int checkedPatientType = rgPatientType.getCheckedRadioButtonId();
            if (checkedPatientType == -1) {
                Toast.makeText(this, "Please select patient type!", Toast.LENGTH_SHORT).show();
                return;
            }

            String patientType;
            if (checkedPatientType == R.id.rbPriority) {
                if (spPriorityCategory.getSelectedItemPosition() == 0) {
                    Toast.makeText(this, "Please select priority category!", Toast.LENGTH_SHORT).show();
                    return;
                }
                patientType = "Priority - " + spPriorityCategory.getSelectedItem().toString();
            } else {
                patientType = "Regular";
            }

            String appointmentDetails =
                    "Patient Name: " + patientName +
                            "\nAge: " + age +
                            "\nGender: " + gender +
                            "\nDoctor: Dr. A. Santos" +
                            "\nSpecialization: General Medicine" +
                            "\nReason: " + reason +
                            "\nAppointment Date: " + selectedDate +
                            "\nAppointment Time: " + selectedTime +
                            "\nPatient Type: " + patientType;

            new AlertDialog.Builder(BookingActivity.this)
                    .setTitle("Appointment Confirmed!")
                    .setMessage(appointmentDetails)
                    .setPositiveButton("OK", (dialog, which) -> Toast.makeText(
                            BookingActivity.this,
                            "Booking completed successfully!",
                            Toast.LENGTH_LONG
                    ).show())
                    .show();
        });
    }
}