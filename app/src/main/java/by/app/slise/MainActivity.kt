package by.app.slise

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.TextMain)
        textView.setOnClickListener { moveToNextScreen() }
    }

    private fun moveToNextScreen(){
        val intent = Intent(this, MovieDetailsActivity::class.java)
        startActivity(intent)
    }
}