package com.example.water_app.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.water_app.R
import com.example.water_app.home.SubmitActivity
import com.example.water_app.recyclerview.HomeAdapter
import com.example.water_app.vo.HomeData

class HomeFragment : Fragment() {

    private lateinit var homeRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container,false)

        val homeList = arrayListOf(
            HomeData(R.drawable.my_document, "제목1", "100만원", "10%"),
            HomeData(R.drawable.my_document, "제목2", "200만원", "20%"),
            HomeData(R.drawable.my_document, "제목3", "300만원", "30%"),
            HomeData(R.drawable.my_document, "제목4", "400만원", "40%")
        )

        homeRecyclerView = view.findViewById(R.id.rvDonation)

        homeRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        homeRecyclerView.setHasFixedSize(true)
        homeRecyclerView.adapter = HomeAdapter(requireContext(), homeList)

        // OnClickListener
        val adapter = HomeAdapter(requireContext(), homeList)

        adapter.setItemClickListener(object : HomeAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                activity?.let{
                    val intent = Intent(context, SubmitActivity::class.java)
                    startActivity(intent)
                }
            }
        })

        homeRecyclerView.adapter = adapter

        return view
    }
}