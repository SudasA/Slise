package by.app.slise.ActorsRecyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.app.slise.R


class FragmentMoviesDetails : Fragment()  {

    private lateinit var adapter: ActorsAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return     inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler: RecyclerView = view.findViewById(R.id.r_actors)
        adapter = ActorsAdapter()
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }


    private fun updateData(){
        adapter.bindActors(ActorsDatasource().getActors())
        adapter.notifyDataSetChanged()
        }
    }




