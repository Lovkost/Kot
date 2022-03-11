package com.example.kot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {
    private val viewModel: PokemonViewModel by lazy {
        ViewModelProviders.of(this).get(PokemonViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, Observer { renderData(it) })
    }

    private fun renderData(data: PokemonData?) {
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = getListData(data)?.let { RecyclerAdapter(it) }
    }

    private fun getListData(data: PokemonData?): List<PokemonResponse>? {
        when(data){
            is PokemonData.Success->{
                val serverResponseData = data.serverResponseData
                return serverResponseData?.results
            }
            is PokemonData.Error->{
                Toast.makeText(context,Error().message,Toast.LENGTH_SHORT).show()
            }
        }
        return null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
