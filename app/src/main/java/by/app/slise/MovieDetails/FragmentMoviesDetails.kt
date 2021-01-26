package by.app.slise.MovieDetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.app.slise.R


class FragmentMoviesDetails : Fragment()  {

    private var movieFragmentckicklistener: MovieFragmentckicklistener? = null

    val actors: List<Actors> = listOf()

    private lateinit var adapter: ActorsAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        view?.findViewById<TextView>(R.id.text_thirteen)?.apply {
            setOnClickListener {
                movieFragmentckicklistener?.changeFragmentBack()
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler: RecyclerView = view.findViewById(R.id.r_actors)
        adapter = ActorsAdapter(view.context,actors)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieFragmentckicklistener) {
           movieFragmentckicklistener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        movieFragmentckicklistener = null
    }

    private fun updateData(){
        adapter.bindActors(ActorsDatasource().getActors())
        adapter.notifyDataSetChanged()
        }

    interface MovieFragmentckicklistener{
        fun changeFragmentBack()
    }
}






