package com.example.it_service_app.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.example.it_service_app.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ServiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ServiceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferences1: SharedPreferences
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val mail=sharedPreferences.getString("MAIL","").toString()
        sharedPreferences1 = requireActivity().getSharedPreferences("$mail", Context.MODE_PRIVATE)
        println("$mail + ssssssssssssssssssssssssss")

        val editor = sharedPreferences1.edit()
//        editor.clear();
//        editor.apply();
        val button1 = view.findViewById<View>(R.id.button_1)
        val button2 = view.findViewById<View>(R.id.button_2)
        val button3 = view.findViewById<View>(R.id.button_3)
        val button4 = view.findViewById<View>(R.id.button_4)
        val button5 = view.findViewById<View>(R.id.button_5)
        val button6 = view.findViewById<View>(R.id.button_6)
        val button7 = view.findViewById<View>(R.id.button_7)
        val button8 = view.findViewById<View>(R.id.button_8)
        val button9 = view.findViewById<View>(R.id.button_9)
        button1.setOnClickListener{
            var int = 1
            editor.putString("NAME1",name1)
            editor.putString("DESC1", desc1)
            editor.apply()
        }
        button2.setOnClickListener{
            editor.putString("NAME2",name2)
            editor.putString("DESC2", desc2)
            editor.apply()
        }
        button3.setOnClickListener{
            editor.putString("NAME3",name3)
            editor.putString("DESC3", desc3)
            editor.apply()
        }
        button4.setOnClickListener{
            editor.putString("NAME4",name4)
            editor.putString("DESC4", desc4)
            editor.apply()
        }
        button5.setOnClickListener{
            editor.putString("NAME5",name5)
            editor.putString("DESC5", desc5)
            editor.apply()
        }
        button6.setOnClickListener{
            editor.putString("NAME6",name6)
            editor.putString("DESC6", desc6)
            editor.apply()
        }
        button7.setOnClickListener{
            editor.putString("NAME7",name7)
            editor.putString("DESC7", desc7)
            editor.apply()
        }
        button8.setOnClickListener{
            editor.putString("NAME8",name8)
            editor.putString("DESC8", desc8)
            editor.apply()
        }
        button9.setOnClickListener{
            editor.putString("NAME9",name9)
            editor.putString("DESC9", desc9)
            editor.apply()
        }


    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ServiceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}






/*
do {
                //if (sharedPreferences1.getString("NAME" + "$i","").toString()!=null){
                if(sharedPreferences1.getString("NAME" + "$i","").toString()=="Windows installation"){
                    val name = sharedPreferences1.getString("NAME" + "$i","").toString()
                    val description = sharedPreferences1.getString("DESC" + "$i","").toString()
                    i+=1
                    val cart = Cart_item(R.drawable.win_install, name, description)
                    //init(R.drawable.win_install, name, description)
                    rcView.layoutManager = LinearLayoutManager(activity)
                    rcView.adapter = adapter
                    adapter.addCart(cart)
                }
                if(sharedPreferences1.getString("NAME" + "$i","").toString()=="Cleaning PC"){
                    val name = sharedPreferences1.getString("NAME" + "$i","").toString()
                    val description = sharedPreferences1.getString("DESC" + "$i","").toString()
                    i+=1
                    val cart = Cart_item(R.drawable.clean_pc, name, description)
                    //init(R.drawable.clean_pc, name, description)
                    rcView.layoutManager = LinearLayoutManager(activity)
                    rcView.adapter = adapter
                    adapter.addCart(cart)
                }
                if(sharedPreferences1.getString("NAME" + "$i","").toString()=="Installing software"){
                    val name = sharedPreferences1.getString("NAME" + "$i","").toString()
                    val description = sharedPreferences1.getString("DESC" + "$i","").toString()
                    i+=1
                    val cart = Cart_item(R.drawable.install_soft, name, description)
                    //init(R.drawable.install_soft, name, description)
                    rcView.layoutManager = LinearLayoutManager(activity)
                    rcView.adapter = adapter
                    adapter.addCart(cart)
                }
                if(sharedPreferences1.getString("NAME" + "$i","").toString()=="Installing antivirus"){
                    val name = sharedPreferences1.getString("NAME" + "$i","").toString()
                    val description = sharedPreferences1.getString("DESC" + "$i","").toString()
                    i+=1
                    val cart = Cart_item(R.drawable.install_antivirus, name, description)
                    //init(R.drawable.install_antivirus, name, description)
                    rcView.layoutManager = LinearLayoutManager(activity)
                    rcView.adapter = adapter
                    adapter.addCart(cart)
                }
                if(sharedPreferences1.getString("NAME" + "$i","").toString()=="Installing drivers"){
                    val name = sharedPreferences1.getString("NAME" + "$i","").toString()
                    val description = sharedPreferences1.getString("DESC" + "$i","").toString()
                    i+=1
                    val cart = Cart_item(R.drawable.install_drivers, name, description)
                    //init(R.drawable.install_drivers, name, description)
                    rcView.layoutManager = LinearLayoutManager(activity)
                    rcView.adapter = adapter
                    adapter.addCart(cart)
                }
                if(sharedPreferences1.getString("NAME" + "$i","").toString()=="PC components"){
                    val name = sharedPreferences1.getString("NAME" + "$i","").toString()
                    val description = sharedPreferences1.getString("DESC" + "$i","").toString()
                    i+=1
                    val cart = Cart_item(R.drawable.selection_pc, name, description)
                    //init(R.drawable.selection_pc, name, description)
                    rcView.layoutManager = LinearLayoutManager(activity)
                    rcView.adapter = adapter
                    adapter.addCart(cart)
                }
                if(sharedPreferences1.getString("NAME" + "$i","").toString()=="Buying a PC"){
                    val name = sharedPreferences1.getString("NAME" + "$i","").toString()
                    val description = sharedPreferences1.getString("DESC" + "$i","").toString()
                    i+=1
                    val cart = Cart_item(R.drawable.buying_pc, name, description)
                    //init(R.drawable.buying_pc, name, description)
                    rcView.layoutManager = LinearLayoutManager(activity)
                    rcView.adapter = adapter
                    adapter.addCart(cart)
                }
                if(sharedPreferences1.getString("NAME" + "$i","").toString()=="PC repair"){
                    val name = sharedPreferences1.getString("NAME" + "$i","").toString()
                    val description = sharedPreferences1.getString("DESC" + "$i","").toString()
                    i+=1
                    val cart = Cart_item(R.drawable.pc_repair, name, description)
                    //init(R.drawable.pc_repair, name, description)
                    rcView.layoutManager = LinearLayoutManager(activity)
                    rcView.adapter = adapter
                    adapter.addCart(cart)
                }
                if(sharedPreferences1.getString("NAME" + "$i","").toString()=="Overclocking"){
                    val name = sharedPreferences1.getString("NAME" + "$i","").toString()
                    val description = sharedPreferences1.getString("DESC" + "$i","").toString()
                    i+=1
                    val cart = Cart_item(R.drawable.overclock_pc, name, description)
                    //init(R.drawable.overclock_pc, name, description)
                    rcView.layoutManager = LinearLayoutManager(activity)
                    rcView.adapter = adapter
                    adapter.addCart(cart)
                }
                if(i<=90){
                    i += 1
                    //break
                }

//            }
//            else{
//                //break
//            }

            }while (true)
 */