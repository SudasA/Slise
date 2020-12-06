package by.app.slise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.app.slise.MoviesRecyclerView.MoviesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MoviesFragment())
                .commit()
    }
}