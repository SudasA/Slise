package by.app.slise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesAdapter (
    private val clickListener: OnRecyclerItemClicked
) : RecyclerView.Adapter<ActorsViewHolder>() {

    private var movies = listOf<Movie>()

    override fun getItemViewType(position: Int): Int {
        return when(movies.size) {
            0 -> VIEW_TYPE_EMPTY
            else -> VIEW_TYPE_ACTORS
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        return when (viewType) {
            VIEW_TYPE_EMPTY -> EmptyViewHolder(
                LayoutInflater.from(
                    parent.context
                ).inflate(R.layout.activity_movie_details, parent, false)
            )
            else -> DataViewHolder(
                LayoutInflater.from(
                    parent.context
                ).inflate(R.layout.item_movie_data, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
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

    fun bindActors(newActors: List<Movie>) {
        movies = newActors
        notifyDataSetChanged()
    }

}


abstract class  ActorsViewHolder (itemview: View) : RecyclerView.ViewHolder(itemview)

private class EmptyViewHolder(itemView: View) : ActorsViewHolder(itemView)
private class DataViewHolder(itemView: View) : ActorsViewHolder(itemView) {

    private val avatar: ImageView = itemView.findViewById(R.id.imageView4)
    private val name: TextView = itemView.findViewById(R.id.nameOfFilms)
    private val depricate :TextView = itemView.findViewById(R.id.TextView15)
    private val style : TextView = itemView.findViewById(R.id.textView2)
    private val duration : TextView = itemView.findViewById(R.id.textView13)
    private val views : TextView = itemView.findViewById(R.id.textView12)

    fun onBind(actor: Movie) {
        Glide.with(context)
            .load(actor.avatar)
            .apply(imageOption)
            .into(avatar)

        name.text = actor.nameOfFilms

        depricate.text = actor.depricate

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
    fun onClick(actor: Movie)
}