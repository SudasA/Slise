package by.app.slise.MoviesRecyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import by.app.slise.ActorsRecyclerView.FragmentMoviesDetails
import by.app.slise.R

class MoviesFragment : Fragment() {

    private var recycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_holder_movie, container, false)
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
        recycler = null

        super.onDetach()
    }

    private fun updateData() {
        (recycler?.adapter as? MoviesAdapter)?.apply {
            bindActors(MoviesDataSource().getMovies())
        }
        
    }

    private fun doOnClick(actor: Movies) {
        recycler?.let {
            activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container, FragmentMoviesDetails())
                    ?.addToBackStack(MoviesFragment::class.java.name)
                    ?.commit()
        }
    }


    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(actor: Movies) {
            doOnClick(actor)
        }
    }
}