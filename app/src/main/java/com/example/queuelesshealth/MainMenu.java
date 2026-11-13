package com.example.queuelesshealth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

/**
 * Queue-Less Health main menu.
 */
public class MainMenu extends AppCompatActivity {

    // Session data (your Login / Booking screens should save these)
    private static final String PREFS = "qlh_session";
    private static final String KEY_NAME = "user_name";
    private static final String KEY_QUEUE_NO = "queue_number";   // int, 0 = none
    private static final String KEY_QUEUE_DOC = "queue_doctor";  // String
    private static final String KEY_QUEUE_AHEAD = "queue_ahead"; // int

    private static final String[] TIPS = {
            "Drink at least 8 glasses of water today.",
            "A 20-minute walk a day keeps the heart happy.",
            "Wash your hands often to avoid catching colds.",
            "Aim for 7-8 hours of sleep tonight.",
            "Take a screen break every 20 minutes to rest your eyes.",
            "Add one more fruit or vegetable to your meals today.",
            "Arrive 10 minutes early to your appointment."
    };

    private TextView tvGreeting, tvSubGreeting, tvQueueStatus, tvQueueDetail, tvQueueNumber, tvTip;
    private View layoutAuth, btnLogout;
    private ScrollView scrollMain;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_6);

        prefs = getSharedPreferences(PREFS, Context.MODE_PRIVATE);

        scrollMain = findViewById(R.id.scrollMain);
        tvGreeting = findViewById(R.id.tvGreeting);
        tvSubGreeting = findViewById(R.id.tvSubGreeting);
        tvQueueStatus = findViewById(R.id.tvQueueStatus);
        tvQueueDetail = findViewById(R.id.tvQueueDetail);
        tvQueueNumber = findViewById(R.id.tvQueueNumber);
        tvTip = findViewById(R.id.tvTip);
        layoutAuth = findViewById(R.id.layoutAuth);
        btnLogout = findViewById(R.id.btnLogout);

        int day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        tvTip.setText(TIPS[day % TIPS.length]);

        setupClicks();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshUi();
    }

    private boolean isLoggedIn() {
        return prefs.getString(KEY_NAME, null) != null;
    }

    private void refreshUi() {
        if (isLoggedIn()) {
            tvGreeting.setText("Hello, " + prefs.getString(KEY_NAME, "") + "!");
            tvSubGreeting.setText("Welcome back. How can we help today?");
            layoutAuth.setVisibility(View.GONE);
            btnLogout.setVisibility(View.VISIBLE);
        } else {
            tvGreeting.setText("Hello, Guest!");
            tvSubGreeting.setText("Skip the waiting room. Book, track and get seen.");
            layoutAuth.setVisibility(View.VISIBLE);
            btnLogout.setVisibility(View.GONE);
        }

        int queueNo = prefs.getInt(KEY_QUEUE_NO, 0);
        if (isLoggedIn() && queueNo > 0) {
            int ahead = prefs.getInt(KEY_QUEUE_AHEAD, 0);
            String doctor = prefs.getString(KEY_QUEUE_DOC, "your doctor");
            tvQueueNumber.setText(String.valueOf(queueNo));
            tvQueueStatus.setText(ahead == 0 ? "You're next!" : ahead + " patient(s) ahead of you");
            tvQueueDetail.setText("Waiting for " + doctor + " - est. " + (ahead * 10) + " min");
        } else {
            tvQueueNumber.setText("--");
            tvQueueStatus.setText("No active appointment");
            tvQueueDetail.setText("Book an appointment to get a queue number.");
        }
    }

    private void setupClicks() {
        findViewById(R.id.btnLogin).setOnClickListener(v ->
                openScreen("Login", null, "LoginActivity", "Login"));
        findViewById(R.id.btnRegister).setOnClickListener(v ->
                openScreen("Register", null, "RegisterActivity", "Register"));
        btnLogout.setOnClickListener(v -> confirmLogout());

        BookingActivity (activity_main_8.xml)
        findViewById(R.id.cardBook).setOnClickListener(v ->
                openScreen("Book Appointment", null, "BookingActivity", "BookAppointmentActivity", "BookAppointment"));

        findViewById(R.id.cardDoctors).setOnClickListener(v ->
                openScreen("Find a Doctor", null, "FindAdoctor", "FindADoctor", "DoctorSearchActivity"));
        findViewById(R.id.cardHelp).setOnClickListener(v ->
                openScreen("Help & About", null, "HelpActivity"));

        findViewById(R.id.cardQueue).setOnClickListener(v ->
                requireLogin("My Queue", "QueueActivity", "Queue"));
        findViewById(R.id.cardQueueStatus).setOnClickListener(v ->
                requireLogin("My Queue", "QueueActivity", "Queue"));
        findViewById(R.id.cardAppointments).setOnClickListener(v ->
                requireLogin("My Appointments", "AppointmentsActivity", "Appointments"));
        findViewById(R.id.cardDashboard).setOnClickListener(v ->
                requireLogin("Dashboard", "DoctorDashboard", "DashboardActivity"));
        findViewById(R.id.cardNotifications).setOnClickListener(v ->
                requireLogin("Notifications", "NotificationsActivity"));
        findViewById(R.id.cardProfile).setOnClickListener(v ->
                requireLogin("My Profile", "ProfileActivity"));

        // Bottom navigation
        findViewById(R.id.navHome).setOnClickListener(v -> scrollMain.smoothScrollTo(0, 0));
        findViewById(R.id.navAppointments).setOnClickListener(v ->
                requireLogin("My Appointments", "AppointmentsActivity", "Appointments"));
        findViewById(R.id.navQueue).setOnClickListener(v ->
                requireLogin("My Queue", "QueueActivity", "Queue"));
        findViewById(R.id.navProfile).setOnClickListener(v ->
                requireLogin("My Profile", "ProfileActivity"));
