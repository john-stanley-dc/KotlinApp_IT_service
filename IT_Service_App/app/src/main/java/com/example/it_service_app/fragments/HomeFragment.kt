package com.example.it_service_app.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.it_service_app.DBHelper
import com.example.it_service_app.MainActivity
import com.example.it_service_app.R
//AIzaSyDJA6EDs51wxNxIrvvordPYKHy0N6NxGMY
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var dbHelper: DBHelper

    var name_textview: TextView?=null
    var surname_textview: TextView?=null
    var email_textview: TextView?=null
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        dbHelper = DBHelper(activity as MainActivity)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        getUserData()
    }

    private fun getUserData(){
        name_textview = view?.findViewById(R.id.name_textview)
        surname_textview = view?.findViewById(R.id.surname_textview)
        email_textview = view?.findViewById(R.id.email_textview)
        preferences=requireActivity().getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)
        val mail=preferences.getString("MAIL","").toString()
        val password=preferences.getString("PASS","").toString()
        var cursor = dbHelper.getData(mail,password)

        name_textview?.text="${cursor[0]}"
        surname_textview?.text="${cursor[1]}"
        email_textview?.text="${cursor[2]}"
        Log.d("NAME?????????", name_textview?.text.toString())
    }






    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}