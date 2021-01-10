package by.app.slise


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.app.slise.MovieDetails.FragmentMoviesDetails

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentMoviesDetails())
                .commitNow()
        }
    }
}
