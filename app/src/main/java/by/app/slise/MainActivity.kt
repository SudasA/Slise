package by.app.slise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.app.slise.ActorsRecyclerView.FragmentMoviesDetails
import by.app.slise.MoviesRecyclerView.MoviesFragment

class MainActivity : AppCompatActivity(), FragmentMoviesDetails.MovieFragmentckicklistener, MoviesFragment.MovieClicklistener {

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

    override fun onStartMovieDetails() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentMoviesDetails())
                .addToBackStack(MoviesFragment::class.java.name)
                .commit()
        }
    
        /*
                startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://www.themoviedb.org/movie/")
        })
         */
}