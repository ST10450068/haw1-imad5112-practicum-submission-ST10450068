package za.aciie.myweatherapphaw1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import java.util.ArrayList

class MainScreen : AppCompatActivity() {
    // Arrays to store the input data
    private val strDayArray = mutableListOf<String>()
    private val intMinArray = mutableListOf<Int>()
    private val intMaxArray = mutableListOf<Int>()
    private val strWeatherArray = mutableListOf<String>()
    private val weeklyWeather = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)
        // Find the UI elements by their ID
        val strDay = findViewById<EditText>(R.id.strDay)
        val intMin = findViewById<EditText>(R.id.intMin)
        val intMax = findViewById<EditText>(R.id.intMax)
        val strWeather = findViewById<EditText>(R.id.strWeather)
        val resultTxt = findViewById<TextView>(R.id.resultTxt)
        val btnDetailed = findViewById<Button>(R.id.btnOfDets)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnAvg = findViewById<Button>(R.id.btnAvg)
        val btnClear = findViewById<Button>(R.id.btnClear)
        // Set the onClick listener for the submit button
        btnSubmit.setOnClickListener {
            val day = strDay.text.toString()
            val Mininum = intMin.text.toString().toIntOrNull()
            val Maximum = intMax.text.toString().toIntOrNull()
            val Weather = strWeather.text.toString()


            // Check if all inputs are valid
            if (day != null && Mininum != null && Maximum != null && Weather.isNotEmpty()) {
                // Add the inputs to their respective arrays
                strDayArray.add(day)
                intMinArray.add(Mininum)
                intMaxArray.add(Maximum)
                strWeatherArray.add(Weather)
                weeklyWeather.add("Day: $day, Min: $Mininum, Max: $Maximum, Weather condition: $Weather")
                // Display the collected data
                resultTxt.text = weeklyWeather.joinToString("\n")
            } else {
                // Show an error message if inputs are invalid
                resultTxt.text = "Please fill all fields correctly"
            }


        }
        // Set the onClick listener for the detailed view button
        btnDetailed.setOnClickListener {
            if (strDayArray.isNotEmpty() && intMinArray.isNotEmpty() && intMaxArray.isNotEmpty() && strWeatherArray.isNotEmpty()) {
                // Create an intent to start the detailed view activity
                val intent = Intent(this, detailedViewScreen::class.java)
                intent.putStringArrayListExtra("strDayArray", ArrayList(strDayArray)) //developer.android.com.(2024)
                intent.putIntegerArrayListExtra("intMinArray", ArrayList(intMinArray))
                intent.putIntegerArrayListExtra("intMaxArray", ArrayList(intMaxArray))
                intent.putStringArrayListExtra("strWeatherArray", ArrayList(strWeatherArray))
                startActivity(intent)
            } else {
                resultTxt.text = "No data to display in the detailed view"
            }

            btnAvg.setOnClickListener {
                // Calculate averages
                if (intMinArray.isNotEmpty() && intMaxArray.isNotEmpty()) {
                    val avgMin = intMinArray.average()
                    val avgMax = intMaxArray.average()
                    resultTxt.text = "Average Min: $avgMin\nAverage Max: $avgMax"
                } else {
                    resultTxt.text = "No data to calculate average"
                }
            }

            btnClear.setOnClickListener {
                // Clear all arrays and text fields
                strDayArray.clear()
                intMinArray.clear()
                intMaxArray.clear()
                strWeatherArray.clear()
                weeklyWeather.clear()
                resultTxt.text = ""
                strDay.text.clear()
                intMin.text.clear()
                intMax.text.clear()
                strWeather.text.clear()

            }
        }
    }
}





