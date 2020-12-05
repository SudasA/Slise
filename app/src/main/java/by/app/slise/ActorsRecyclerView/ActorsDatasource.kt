package by.app.slise.ActorsRecyclerView

import by.app.slise.R


class ActorsDatasource {
    fun getActors() : List<Actor> {
        return listOf(
                Actor(R.drawable.chrish, "Robert\\nDowney Jr."),
                Actor(R.drawable.mark, "Chris\\nEvans"),
                Actor(R.drawable.chrise, "Mark\\nRuffalo"),
                Actor(R.drawable.robert, "Chris\\nHemsworth"),
        )
    }
}