package com.example.queuelesshealth;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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

    // 2. SETUP SPINNERS
    private void setupSpinners() {
        setupGenderSpinner();
        setupPrioritySpinner();
    }

    private void setupGenderSpinner() {
        String[] genderOptions = {
                "Select Gender",
                "Male",
                "Female",
                "Other"
        };

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                genderOptions
        );

        genderAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spGender.setAdapter(genderAdapter);
    }

    private void setupPrioritySpinner() {
        String[] priorityOptions = {
                "Select Priority Category",
                "Senior Citizen",
                "Person with Disability (PWD)",
                "Pregnant"
        };

        ArrayAdapter<String> priorityAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                priorityOptions
        );

        priorityAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spPriorityCategory.setAdapter(priorityAdapter);
    }

    // 3. PATIENT TYPE SELECTION
    private void setupPatientType() {

        spPriorityCategory.setEnabled(false);

        rgPatientType.setOnCheckedChangeListener(
                (group, checkedId) -> {

                    if (checkedId == R.id.rbPriority) {

                        spPriorityCategory.setEnabled(true);

                    } else {

                        spPriorityCategory.setEnabled(false);
                        spPriorityCategory.setSelection(0);
                    }
                }
        );
    }

    // 4. DATE PICKER
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

            // Prevent selecting past dates
            datePicker.getDatePicker().setMinDate(
                    System.currentTimeMillis()
            );

            datePicker.show();
        });
    }

    // 5. TIME PICKER
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

    // 6. AVAILABLE TIME SLOTS
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

    // 7. CONFIRM BOOKING
    private void setupConfirmButton() {

        btnConfirmBooking.setOnClickListener(v -> {

            String patientName = etFullName.getText().toString().trim();
            String age = etAge.getText().toString().trim();
            String reason = etReason.getText().toString().trim();

            String gender = spGender.getSelectedItem().toString();

            // Validate patient name
            if (patientName.isEmpty()) {

                etFullName.setError("Please enter your full name!");
                etFullName.requestFocus();
                return;
            }

            // Validate age
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

            // Validate gender
            if (spGender.getSelectedItemPosition() == 0) {

                Toast.makeText(
                        this,
                        "Please select your gender!",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Validate reason
            if (reason.isEmpty()) {

                etReason.setError(
                        "Please enter your reason for appointment!"
                );

                etReason.requestFocus();
                return;
            }

            // Validate appointment date
            if (selectedDate.isEmpty()) {

                Toast.makeText(
                        this,
                        "Please select an appointment date!",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Validate appointment time
            if (selectedTime.isEmpty()) {

                Toast.makeText(
                        this,
                        "Please select an appointment time!",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Validate patient type
            int checkedPatientType =
                    rgPatientType.getCheckedRadioButtonId();

            if (checkedPatientType == -1) {

                Toast.makeText(
                        this,
                        "Please select patient type!",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            String patientType;

            if (checkedPatientType == R.id.rbPriority) {

                if (spPriorityCategory.getSelectedItemPosition() == 0) {

                    Toast.makeText(
                            this,
                            "Please select priority category!",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                patientType = "Priority - " +
                        spPriorityCategory.getSelectedItem().toString();

            } else {

                patientType = "Regular";
            }

            // Appointment Details
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

            // Display Confirmation
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