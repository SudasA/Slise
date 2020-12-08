package by.app.slise.MoviesRecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.app.slise.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesAdapter (
    private val clickListener: OnRecyclerItemClicked
) : RecyclerView.Adapter<MoviesViewHolder>() {

    private var movies = listOf<Movies>()

    override fun getItemViewType(position: Int): Int {
        return when(movies.size) {
            0 -> VIEW_TYPE_EMPTY
            else -> VIEW_TYPE_ACTORS
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder{
        return when (viewType) {
            VIEW_TYPE_EMPTY -> EmptyViewHolder(
                LayoutInflater.from(
                    parent.context
                ).inflate(R.layout.activity_main, parent, false)
            )
            else -> DataViewHolder(
                LayoutInflater.from(
                    parent.context
                ).inflate(R.layout.item_movie_data, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        when (holder) {
            is DataViewHolder -> {
                holder.onBind(movies[position])
                holder.itemView.setOnClickListener {
                    clickListener.onClick(movies[position])
                }
            }
            is EmptyViewHolder -> { /* nothing to bind */}
        }
    }


    override fun getItemCount(): Int = movies.size

    fun bindActors(newActors: List<Movies>) {
        movies = newActors
        notifyDataSetChanged()
    }

}


abstract class MoviesViewHolder (itemview: View) : RecyclerView.ViewHolder(itemview)

private class EmptyViewHolder(itemView: View) : MoviesViewHolder(itemView)
private class DataViewHolder(itemView: View) : MoviesViewHolder(itemView) {

    private val avatar: ImageView = itemView.findViewById(R.id.image_font_back)
    private val name: TextView = itemView.findViewById(R.id.name_of_films)
    private val deprecate :TextView = itemView.findViewById(R.id.text_deprecate_two)
    private val style : TextView = itemView.findViewById(R.id.text_style)
    private val duration : TextView = itemView.findViewById(R.id.text_min)
    private val views : TextView = itemView.findViewById(R.id.text_reviewsx)

    fun onBind(actor: Movies) {
        Glide.with(context)
            .load(actor.avatar)
            .apply(imageOption)
            .into(avatar)

        name.text = actor.nameOfFilms

        deprecate.text = actor.deprecate

        style.text = actor.style

        duration.text = actor.duration

        views.text = actor.views


    }




    companion object {
        private val imageOption = RequestOptions()
            .placeholder(R.drawable.ic_avatar_placeholder)
            .fallback(R.drawable.ic_avatar_placeholder)
    }
}

    private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

private const val VIEW_TYPE_EMPTY = 0
private const val VIEW_TYPE_ACTORS = 1

interface OnRecyclerItemClicked {
    fun onClick(actor: Movies)
}