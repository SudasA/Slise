package by.app.slise.MovieDetails

import android.content.Context
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
    context: Context,
    var actors: List<Actors>
): RecyclerView.Adapter<ViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_actors_data, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = actors.size

    fun getItem (position: Int): Actors = actors[position]

    fun bindActors(newActors: List<Actors>) {
        actors = newActors
    }
}


class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var avatar: ImageView= itemView.findViewById(R.id.image_actors)
    private val name: TextView = itemView.findViewById(R.id.text_actors)

    fun bind(actor: Actors) {

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









