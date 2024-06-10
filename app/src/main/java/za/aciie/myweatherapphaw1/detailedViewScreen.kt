package za.aciie.myweatherapphaw1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detailedViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        // Find the UI elements by their ID
        val detailsView = findViewById<TextView>(R.id.detailsView)
        val exit = findViewById<Button>(R.id.btnExit)
        val btnBck = findViewById<Button>(R.id.btnBck)
        // Retrieve data from the intent
        val dateArray = intent.getStringArrayListExtra("strDayArray")
        val minArray = intent.getIntegerArrayListExtra("intMinArray")
        val maxArray = intent.getIntegerArrayListExtra("intMaxArray")
        val weatherArray = intent.getStringArrayListExtra("strWeatherArray")
        val avgMin = intent.getDoubleExtra("avgMin", 0.0)
        val avgMax = intent.getDoubleExtra("avgMax", 0.0)

        // Create a string to display the details
        val details = StringBuilder()

        if (dateArray != null && minArray != null && maxArray != null && weatherArray != null) {
            for (i in dateArray.indices) {
                details.append("Date: ${dateArray[i]}, Min: ${minArray[i]}, Max: ${maxArray[i]}, Weather: ${weatherArray[i]}\n")
            }
            details.append("\nAverage Min: $avgMin\nAverage Max: $avgMax\nThank you for using the app :)")
        } else {
            details.append("No data available")
        }
        // Display the details
        detailsView.text = details.toString()

        btnBck.setOnClickListener {
            val goBack = Intent(this, MainScreen::class.java)
            startActivity(goBack)
        }

        exit.setOnClickListener {
            finishAffinity()     // Exit the app
        }
    }
}



