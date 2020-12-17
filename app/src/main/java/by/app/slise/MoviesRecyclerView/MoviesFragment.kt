package by.app.slise.MoviesRecyclerView

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import by.app.slise.R

class MoviesFragment : Fragment() {

    private var recycler: RecyclerView? = null

    private var movieClickListener: MovieClicklistener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = view.findViewById(R.id.rv_movies)
        recycler?.adapter = MoviesAdapter(clickListener)

    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onDetach() {
        super.onDetach()
        recycler = null
        movieClickListener = null
    }

    private fun updateData() {
        (recycler?.adapter as? MoviesAdapter)?.apply {
            bindActors(MoviesDataSource().getMovies())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieClicklistener) {
            movieClickListener = context
        }
    }

    private fun doOnClick() {
        recycler?.let {
            movieClickListener?.onStartMovieDetails()
        }
    }


    private val clickListener = object : OnRecyclerItemClicked {
    override fun onClick(actor: Movies) {
            doOnClick()
       }
    }

    interface MovieClicklistener  {
        fun onStartMovieDetails()
    }
}