package by.app.slise.MovieList

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import by.app.slise.R
import by.app.slise.databinding.ItemMovieBinding
import by.app.slise.entities.Movie
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation



class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val transformation: Transformation

    init {
        val dimension = itemView.resources.getDimension(R.dimen.cornerRad)
        val cornerRadius = dimension.toInt()
        transformation = RoundedCornersTransformation(cornerRadius, 0)
    }

    fun bind(movie: Movie, listener: (Movie) -> Unit) {
        setName(movie)
        setThumbnail(movie)
        setClickListener(listener, movie)
        setCount(movie)
        setGenres(movie)
        setAdult(movie)
        setDate(movie)
    }

    private fun setClickListener(
        listener: (Movie) -> Unit,
        movie: Movie
    ) {
        itemView.setOnClickListener { listener(movie) }
    }

    private fun setName(movie: Movie) {
        binding.movieName.text = movie.name
    }

    private fun setThumbnail(movie: Movie) {
        Picasso.get()
            .load(movie.thumbnail)
            .placeholder(R.drawable.ph_movie_grey_200)
            .error(R.drawable.ph_movie_grey_200)
            .transform(transformation)
            .fit()
            .centerCrop()
            .into(binding.movieThumbnail)
    }

    @SuppressLint("SetTextI18n")
    private fun setCount (movie: Movie) {
        binding.textReviewsx.text = "${movie.voteCount} REVIEWS"
    }

    private fun setGenres (movie: Movie) {
        binding.ratingBar.rating = movie.average
    }

    @SuppressLint("SetTextI18n")
    private fun setAdult (movie: Movie) {
        if (movie.adult) {
            binding.textDeprecateTwo.text = "18+"
        }
    }

    private fun setDate (movie: Movie) {
            binding.textMin.text = movie.releaseDate
    }
}