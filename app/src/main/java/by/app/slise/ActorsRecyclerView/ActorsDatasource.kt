package by.app.slise.ActorsRecyclerView


class ActorsDatasource {
    fun getActors() : List<Actors> {
        return listOf(
               Actors("https://avatars.mds.yandex.net/get-kinopoisk-image/1777765/badcb124-2d8c-455b-a8f6-ffd7459fc3be/280x420", "Robert\nDowney Jr."),
               Actors("https://avatars.mds.yandex.net/get-kinopoisk-image/1777765/e03dc053-41a5-499e-9712-4d7b0cd2dcca/280x420", "Chris\nEvans"),
               Actors("https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/cbc216b7-5d88-408d-b37a-8d574089f312/280x420", "Mark\nRuffalo"),
               Actors("https://avatars.mds.yandex.net/get-kinopoisk-image/1900788/23f94a27-bd93-4074-add5-db22e54e0833/280x420", "Chris\nHemsworth"),
        )
    }
}