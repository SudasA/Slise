package by.app.slise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.app.slise.ActorsRecyclerView.FragmentMoviesDetails
import by.app.slise.MoviesRecyclerView.MoviesFragment

class MainActivity : AppCompatActivity(), FragmentMoviesDetails.MovieFragmentckicklistener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MoviesFragment())
                .commit()
    }

    override fun changeFragmentBack() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MoviesFragment())
                .commit()
    }
}