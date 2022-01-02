package com.example.it_service_app.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.it_service_app.CartAdapter
import com.example.it_service_app.Cart_item
import com.example.it_service_app.R
import com.example.it_service_app.databinding.FragmentCartBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CartFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var name1: String = "Windows installation"
    private var desc1: String = "404"

    private var name2: String = "Cleaning PC"
    private var desc2: String = "404"

    private var name3: String = "Installing software"
    private var desc3: String = "404"

    private var name4: String = "Installing antivirus"
    private var desc4: String = "404"

    private var name5: String = "Installing drivers"
    private var desc5: String = "404"

    private var name6: String = "PC components"
    private var desc6: String = "404"

    private var name7: String = "Buying a PC"
    private var desc7: String = "404"

    private var name8: String = "PC repair"
    private var desc8: String = "404"

    private var name9: String = "Overclocking"
    private var desc9: String = "404"
    lateinit var binding: FragmentCartBinding
    private val adapter = CartAdapter()
    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferences1: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private var i = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCartBinding.inflate(layoutInflater)
        binding = FragmentCartBinding.inflate(layoutInflater)
        sharedPreferences = requireActivity().getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val mail=sharedPreferences.getString("MAIL","").toString()

        sharedPreferences1 = requireActivity().getSharedPreferences("$mail", Context.MODE_PRIVATE)
        val des1 = sharedPreferences1.getString("NAME1","").toString()
        //println("$des1 +++++++++++++++++++++++++++++")
//        val editor = sharedPreferences1.edit()
//        val button1 = view?.findViewById<View>(R.id.button_1)
//        val button2 = view?.findViewById<View>(R.id.button_2)
//        val button3 = view?.findViewById<View>(R.id.button_3)
//        val button4 = view?.findViewById<View>(R.id.button_4)
//        val button5 = view?.findViewById<View>(R.id.button_5)
//        val button6 = view?.findViewById<View>(R.id.button_6)
//        val button7 = view?.findViewById<View>(R.id.button_7)
//        val button8 = view?.findViewById<View>(R.id.button_8)
//        val button9 = view?.findViewById<View>(R.id.button_9)
//        button1?.setOnClickListener{
//            editor.putString("NAME1",name1)
//            editor.putString("DESC1", desc1)
//            editor.apply()
//            i=1
//            val name = sharedPreferences1.getString("NAME" + "$i","").toString()
//            val description = sharedPreferences1.getString("DESC" + "$i","").toString()
//            init(R.drawable.win_install, name, description)
//        }
//        button2?.setOnClickListener{
//            editor.putString("NAME2",name2)
//            editor.putString("DESC2", desc2)
//            editor.apply()
//            i=2
//            val name = sharedPreferences1.getString("NAME" + "$i","").toString()
//            val description = sharedPreferences1.getString("DESC" + "$i","").toString()
//            init(R.drawable.clean_pc, name, description)
//        }
//        button3?.setOnClickListener{
//            editor.putString("NAME3",name3)
//            editor.putString("DESC3", desc3)
//            editor.apply()
//            i=3
//            val name = sharedPreferences1.getString("NAME" + "$i","").toString()
//            val description = sharedPreferences1.getString("DESC" + "$i","").toString()
//            init(R.drawable.install_soft, name, description)
//        }
//        button4?.setOnClickListener{
//            editor.putString("NAME4",name4)
//            editor.putString("DESC4", desc4)
//            editor.apply()
//            i=4
//            val name = sharedPreferences1.getString("NAME" + "$i","").toString()
//            val description = sharedPreferences1.getString("DESC" + "$i","").toString()
//            init(R.drawable.install_antivirus, name, description)
//        }
//        button5?.setOnClickListener{
//            editor.putString("NAME5",name5)
//            editor.putString("DESC5", desc5)
//            editor.apply()
//            i=5
//            val name = sharedPreferences1.getString("NAME" + "$i","").toString()
//            val description = sharedPreferences1.getString("DESC" + "$i","").toString()
//            init(R.drawable.install_drivers, name, description)
//        }
//        button6?.setOnClickListener{
//            editor.putString("NAME6",name6)
//            editor.putString("DESC6", desc6)
//            editor.apply()
//            i=6
//            val name = sharedPreferences1.getString("NAME" + "$i","").toString()
//            val description = sharedPreferences1.getString("DESC" + "$i","").toString()
//            init(R.drawable.selection_pc, name, description)
//        }
//        button7?.setOnClickListener{
//            editor.putString("NAME7",name7)
//            editor.putString("DESC7", desc7)
//            editor.apply()
//            i=7
//            val name = sharedPreferences1.getString("NAME" + "$i","").toString()
//            val description = sharedPreferences1.getString("DESC" + "$i","").toString()
//            init(R.drawable.buying_pc, name, description)
//        }
//        button8?.setOnClickListener{
//            editor.putString("NAME8",name8)
//            editor.putString("DESC8", desc8)
//            editor.apply()
//            i=8
//            val name = sharedPreferences1.getString("NAME" + "$i","").toString()
//            val description = sharedPreferences1.getString("DESC" + "$i","").toString()
//            init(R.drawable.pc_repair, name, description)
//        }
//        button9?.setOnClickListener{
//            editor.putString("NAME9",name9)
//            editor.putString("DESC9", desc9)
//            editor.apply()
//            i=9
//            val name = sharedPreferences1.getString("NAME" + "$i","").toString()
//            val description = sharedPreferences1.getString("DESC" + "$i","").toString()
//            init(R.drawable.overclock_pc, name, description)
//        }
        //println(sharedPreferences1.all)
        val view=binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        val size = sharedPreferences1.all
        val size2 = size.size
        println(size["NAME5"])
        binding.apply {
            for((i,n) in size){
                val m =5
                println(size)
                if(i == "Installing drivers "){
                    val name = sharedPreferences1.getString("NAME+$i","")
                    println("$name+ lox")
                    val description = sharedPreferences1.getString("DESC+$i","")
                    val cart = Cart_item(R.drawable.win_install, name!!, description!!)
                    rcView.layoutManager = LinearLayoutManager(activity)
                    rcView.adapter = adapter
                    adapter.addCart(cart)
                }

            }


        }
    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}