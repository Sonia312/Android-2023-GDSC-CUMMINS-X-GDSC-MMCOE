package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ratingEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        ratingEditText = findViewById(R.id.ratingEditText);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the user's rating from the EditText
                String ratingString = ratingEditText.getText().toString();

                if (!ratingString.isEmpty()) {
                    // Convert the rating to an integer
                    int rating = Integer.parseInt(ratingString);

                    // Check if the rating is within the valid range (1-10)
                    if (rating >= 1 && rating <= 10) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    } else {
                        // Show an error message if the rating is out of range
                        Toast.makeText(MainActivity.this, "Please rate from 1 to 10", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Show an error message if the EditText is empty
                    Toast.makeText(MainActivity.this, "Please enter a rating", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
