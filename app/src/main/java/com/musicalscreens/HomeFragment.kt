package com.musicalscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.musicalscreens.R

class HomeFragment : Fragment() {

    private lateinit var adapter : MyAdapter
    private lateinit var recyclerView : RecyclerView
    private lateinit var lyricsArrayList : ArrayList<Lyrics>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var lyrics : Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(lyricsArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(){
        lyricsArrayList = arrayListOf<Lyrics>()

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f
        )
        heading = arrayOf(
            getString(R.string.heading_a),
            getString(R.string.heading_b),
            getString(R.string.heading_c),
            getString(R.string.heading_d),
            getString(R.string.heading_e),
            getString(R.string.heading_f)
        )
        lyrics = arrayOf(

            getString(R.string.song_a),
            getString(R.string.song_b),
            getString(R.string.song_c),
            getString(R.string.song_d),
            getString(R.string.song_e),
            getString(R.string.song_f)
        )
        for (i in imageId.indices){
            val lyrics = Lyrics(imageId[i],heading[i])
            lyricsArrayList.add(lyrics)
        }

    }

}