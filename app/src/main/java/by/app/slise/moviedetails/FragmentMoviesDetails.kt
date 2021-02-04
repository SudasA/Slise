package by.app.slise.moviedetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.app.slise.R
import by.app.slise.databinding.FragmentMoviesDetailsBinding
import by.app.slise.model.Actor
import by.app.slise.model.Movie
import coil.load
import by.app.slise.adapters.ActorListAdapter
import by.app.slise.adapters.ActorListItemDecorator

import by.app.slise.MovieClickListener
import java.lang.IllegalArgumentException
import kotlin.properties.Delegates

const val MOVIE_ID_ARG = "Movie"

class FragmentMoviesDetails : Fragment() {

    private var movieId by Delegates.notNull<Int>()
    private val viewModel: MoviesDetailsViewModel by lazy {
        ViewModelProvider(
            this,
            MoviesDetailsViewModelFactory(movieId)
        ).get(MoviesDetailsViewModel::class.java)
    }

    private var _binding: FragmentMoviesDetailsBinding? = null
    private val binding get() = _binding!!
    private var listenerMovie: MovieClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesDetailsBinding.inflate(inflater, container, false)

        val bundle: Bundle? = this.arguments
        movieId =
            bundle?.getInt(MOVIE_ID_ARG) ?: throw IllegalArgumentException("Couldn't find movieId")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener {
            listenerMovie?.backPressed()
        }

        binding.actorsRv.addItemDecoration(
            ActorListItemDecorator(
                resources.getDimension(R.dimen.margin_8).toInt()
            )
        )

        viewModel.currentMovie.observe(this.viewLifecycleOwner, this::bindMovie)
        viewModel.actorsList.observe(this.viewLifecycleOwner, this::bindActors)
        viewModel.loadingState.observe(this.viewLifecycleOwner, this::setLoading)

    }

    private fun bindMovie(movie: Movie) {
        movie.run {
            binding.movieTitle.text = title
            binding.genre.text = genres.toString()
                .subSequence(1, genres.toString().length - 1)
            binding.backgroundPoster.load("https://image.tmdb.org/t/p/w500/" + movie.backdrop) {
                placeholder(R.drawable.backdrop_placeholder)
                error(R.drawable.backdrop_placeholder)
            }
            binding.reviewsCount.text = resources.getString(R.string.reviews, votes)
            binding.rating.rating = ratings.div(2).toFloat()
            binding.storylineBody.text = overview
            if (adult) {
                binding.ageLimit.text = resources.getString(R.string.age_adult)
            } else {
                binding.ageLimit.text = resources.getString(R.string.age_non_adult)
            }
        }
    }

    private fun bindActors(actorsList: List<Actor>) {
        if (actorsList.isEmpty()) {
            binding.castTitle.visibility = View.INVISIBLE
        } else {
            binding.castTitle.visibility = View.VISIBLE
            val adapter = ActorListAdapter()
            adapter.bindActors(actorsList)
            binding.actorsRv.adapter = adapter
        }
    }

    private fun setLoading(loading: Boolean) {
        binding.movieDetailsProgressBar.isVisible = loading
        binding.movieDetailsContainer.isVisible = !loading
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is MovieClickListener) {
            this.listenerMovie = activity as MovieClickListener
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        listenerMovie = null
    }

    companion object {
        fun newInstance(movieId: Int): FragmentMoviesDetails {
            return FragmentMoviesDetails().apply {
                arguments = Bundle().apply {
                    putInt(MOVIE_ID_ARG, movieId)
                }
            }
        }
    }
}