package com.example.firstpracticetask_20250315;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

// Creating MainActivity class which inherits AppCompatActivity functionality
public class MainActivity extends AppCompatActivity {
    //OnCreate method is the first method called when the activity is created,
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calling parent class OnCreate method to save activity state.
        EdgeToEdge.enable(this); //EdgeToEdge function is needed for UI elements to spread until edges.
        setContentView(R.layout.activity_main); //set layout based on activity_main.xml file.
        //Set insets to maintain view across different screen sizes.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); //get system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); //set padding to view
            return insets;
        });

        Button btnChangeText = findViewById(R.id.btnChangeText); //get button from activity_main.xml file.
        Button btnChangeTextColor = findViewById(R.id.btnChangeTextColor); //get another button from activity_main.xml file.
        TextView tvMain = findViewById(R.id.tvMain); //get textview from activity_main.xml file.

        //setting click listener for first button (responsible for text change)
        btnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMain.setText(getString(R.string.button_clicked_text));
            }
        });

        //setting click listener for second button (responsible for text color change)
        btnChangeTextColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomColor = getRandomColor(); //get random color
                tvMain.setTextColor(randomColor); //set text color to random color

            }
        });
    }
    //method for generating random color
    private int getRandomColor(){
        Random random = new Random(); //create random object
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)); //return random color
    }
}