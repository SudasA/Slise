package by.app.slise.MoviesRecyclerView

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import by.app.slise.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MoviesFragment : Fragment() {

    private val scope = CoroutineScope(Dispatchers.Main)

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
            recycler?.setHasFixedSize(true);
            recycler?.setItemViewCacheSize(40);

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
        scope.launch {
            (recycler?.adapter as? MoviesAdapter)?.apply {
                bindActors(MoviesDataSource().getMovies())
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieClicklistener) {
            movieClickListener = context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    private fun doOnClick() {
        scope.launch {
            recycler?.let {
                scope.launch { movieClickListener?.onStartMovieDetails() }
            }
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