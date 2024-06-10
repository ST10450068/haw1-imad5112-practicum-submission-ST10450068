package za.aciie.myweatherapphaw1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Find the button for navigating to the next page by its ID
        val nextPage =  findViewById<Button>(R.id.btnNextPage)

            nextPage.setOnClickListener {
                // Create an intent to navigate to the MainScreen activity
                val intent = Intent (this, MainScreen::class.java) //developer.android.com. (2024).
                startActivity(intent) // Start the MainScreen activity

            }
    }
}
