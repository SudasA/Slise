package by.app.slise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions

class MoviesAdapter (
    private val clickListener: OnRecyclerItemClicked
) : RecyclerView.Adapter<ActorsViewHolder>() {

    private var actors = listOf<Actor>()

    override fun getItemViewType(position: Int): Int {
        return when(actors.size) {
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
                ).inflate(R.layout.item_actors_data, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        when (holder) {
            is DataViewHolder -> {
              //  holder.onBind(actors[position])
                holder.itemView.setOnClickListener {
                    clickListener.onClick(actors[position])
                }
            }
            is EmptyViewHolder -> { /* nothing to bind */}
        }
    }


    override fun getItemCount(): Int = actors.size

    fun bindActors(newActors: List<Actor>) {
        actors = newActors
        notifyDataSetChanged()
    }

}


abstract class  ActorsViewHolder (itemview: View) : RecyclerView.ViewHolder(itemview)

private class EmptyViewHolder(itemView: View) : ActorsViewHolder(itemView)
private class DataViewHolder(itemView: View) : ActorsViewHolder(itemView) {
/*
    private val avatar: ImageView = itemView.findViewById(R.id.imageView4)

    fun onBind(actor: Actor) {
        Glide.with(context)
            .load(actor.avatar)
            .apply(imageOption)
            .into(avatar)


    }

 */


    companion object {
        private val imageOption = RequestOptions()
            .placeholder(R.drawable.ic_avatar_placeholder)
            .fallback(R.drawable.ic_avatar_placeholder)
            .circleCrop()
    }
}

    private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

private const val VIEW_TYPE_EMPTY = 0
private const val VIEW_TYPE_ACTORS = 1

interface OnRecyclerItemClicked {
    fun onClick(actor: Actor)
}