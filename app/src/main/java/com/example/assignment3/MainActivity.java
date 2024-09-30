package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxTerms;
    private RadioGroup radioGroupGender;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private TextView seekBarValue;
    private Switch switchNotifications;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkBoxTerms = findViewById(R.id.checkboxTerms);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);
        seekBarValue = findViewById(R.id.seekBarValue);
        switchNotifications = findViewById(R.id.switchNotifications);
        submitButton = findViewById(R.id.submitButton);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText("SeekBar Value: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }


    private void validateForm() {
        // Validate CheckBox (Terms & Conditions)
        if (!checkBoxTerms.isChecked()) {
            Toast.makeText(this, "Please agree to the Terms and Conditions.", Toast.LENGTH_SHORT).show();
            return;
        }


        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Please select your gender.", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton selectedGenderButton = findViewById(selectedGenderId);
        String gender = selectedGenderButton.getText().toString();


        float rating = ratingBar.getRating();


        int seekBarValueInt = seekBar.getProgress();


        boolean notificationsEnabled = switchNotifications.isChecked();


        String summary = "Gender: " + gender +
                "\nRating: " + rating +
                "\nSeekBar Value: " + seekBarValueInt +
                "\nNotifications: " + (notificationsEnabled ? "Enabled" : "Disabled");


        Toast.makeText(this, summary, Toast.LENGTH_LONG).show();
    }
}