package com.example.assignment3;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderActivity extends AppCompatActivity {

    private CheckBox dress, shoe, bag, makeup;
    private RadioGroup paymentMethodGroup;
    private SeekBar ageSeekBar;
    private Switch notificationSwitch;
    private RatingBar ratingBar;
    private TextView ageDisplay, ratingText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        dress = findViewById(R.id.dress);
        shoe = findViewById(R.id.shoe);
        bag = findViewById(R.id.bag);
        makeup = findViewById(R.id.makeup);

        paymentMethodGroup = findViewById(R.id.radioGroup);

        ageSeekBar = findViewById(R.id.seekBar);
        ageDisplay = findViewById(R.id.age_display);

        notificationSwitch = findViewById(R.id.btn_switch);
        ratingBar = findViewById(R.id.ratingBar);
        ratingText = findViewById(R.id.rating);

        ratingText.setText("Rating: " + ratingBar.getRating());

        ageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageDisplay.setText(progress + "y");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        notificationSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String message = isChecked ? "Notifications Enabled" : "Notifications Disabled";
            Toast.makeText(OrderActivity.this, message, Toast.LENGTH_SHORT).show();
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingText.setText("Rating: " + rating);
            }
        });

    }

    protected void onPause() {
        super.onPause();
    }
}