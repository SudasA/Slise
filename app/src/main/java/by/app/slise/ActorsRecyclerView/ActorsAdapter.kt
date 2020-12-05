package by.app.slise.ActorsRecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.app.slise.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ActorsAdapter(
): RecyclerView.Adapter<ActorsViewHolder>(){

    private var actors: List<Actors> = listOf()

    override fun getItemViewType(position: Int): Int {
        return when(actors.size) {
            0 -> VIEW_TYPE_EMPTY
            else -> VIEW_TYPE_ACTORS
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        return when (viewType) {
            by.app.slise.ActorsRecyclerView.VIEW_TYPE_EMPTY -> by.app.slise.ActorsRecyclerView.EmptyViewHolder(
                    LayoutInflater.from(
                            parent.context
                    ).inflate(R.layout.item_actors_data, parent, false)
            )
            else -> by.app.slise.ActorsRecyclerView.DataViewHolder(
                    LayoutInflater.from(
                            parent.context
                    ).inflate(R.layout.item_actors_data, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        when (holder) {
            is DataViewHolder -> {
                holder.onBind(actors[position])
            }
            is EmptyViewHolder -> { /* nothing to bind */}
        }
    }

    override fun getItemCount(): Int = actors.size

    fun bindActors(newActors: List<Actors>) {
        actors = newActors
    }
}

abstract class  ActorsViewHolder (itemview: View) : RecyclerView.ViewHolder(itemview)

private class EmptyViewHolder(itemView: View) : ActorsViewHolder(itemView)


class DataViewHolder(itemView: View): ActorsViewHolder(itemView){

    private var avatar: ImageView= itemView.findViewById(R.id.imageView2)
    private val name: TextView = itemView.findViewById(R.id.textView22)

    fun onBind(actor: Actors) {

           Glide.with(context)
                    .load(actor.actorView)
                    .apply(imageOption)
                    .into(avatar)




        name.text = actor.actorName

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




