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

/** * Queue-Less Health main menu. */
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

        // Open to everyone
        findViewById(R.id.cardDoctors).setOnClickListener(v ->
                openScreen("Find a Doctor", null, "FindAdoctor", "FindADoctor", "DoctorSearchActivity"));
        findViewById(R.id.cardHelp).setOnClickListener(v ->
                openScreen("Help & About", null, "HelpActivity"));

        // Need an account
        findViewById(R.id.cardBook).setOnClickListener(v ->
                requireLogin("Book Appointment", "BookAppointmentActivity", "BookAppointment"));
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

        // Specialty chips -> Find a Doctor with the chosen specialty
        int[] chipIds = {R.id.chipGeneral, R.id.chipPediatrics, R.id.chipDental,
                R.id.chipCardiology, R.id.chipEye, R.id.chipDerma};
        for (int id : chipIds) {
            findViewById(id).setOnClickListener(v -> {
                String specialty = ((TextView) v).getText().toString();
                openScreen("Find a Doctor", specialty, "FindAdoctor", "FindADoctor", "DoctorSearchActivity");
            });
        }

        findViewById(R.id.btnEmergency).setOnClickListener(v -> confirmEmergency());
    }

    private void requireLogin(String label, String... candidates) {
        if (isLoggedIn()) {
            openScreen(label, null, candidates);
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Please log in")
                    .setMessage("You need an account to use \"" + label + "\".")
                    .setPositiveButton("Login", (d, w) -> openScreen("Login", null, "LoginActivity", "Login"))
                    .setNeutralButton("Register", (d, w) -> openScreen("Register", null, "RegisterActivity", "Register"))
                    .setNegativeButton("Cancel", null)
                    .show();
        }
    }

    /** Tries each class name in this package; shows a message if none exist yet. */
    private void openScreen(String label, String specialty, String... candidates) {
        String pkg = getClass().getPackage().getName();
        for (String name : candidates) {
            try {
                Class<?> target = Class.forName(pkg + "." + name);
                Intent intent = new Intent(this, target);
                if (specialty != null) {
                    intent.putExtra("specialty", specialty);
                }
                startActivity(intent);
                return;
            } catch (ClassNotFoundException ignored) {
                // try next name
            }
        }
        String extra = specialty != null ? " (" + specialty + ")" : "";
        Toast.makeText(this, label + extra + " screen coming soon", Toast.LENGTH_SHORT).show();
    }

    private void confirmLogout() {
        new AlertDialog.Builder(this)
                .setTitle("Log out")
                .setMessage("Are you sure you want to log out?")
                .setPositiveButton("Log out", (d, w) -> {
                    prefs.edit().clear().apply();
                    refreshUi();
                    Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void confirmEmergency() {
        new AlertDialog.Builder(this)
                .setTitle("Emergency")
                .setMessage("This opens your phone dialer with 911. Continue?")
                .setPositiveButton("Open dialer", (d, w) ->
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"))))
                .setNegativeButton("Cancel", null)
                .show();
    }
}
