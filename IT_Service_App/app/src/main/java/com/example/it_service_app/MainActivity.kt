package com.example.it_service_app

import android.content.Context
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.it_service_app.fragments.CartFragment
import com.example.it_service_app.fragments.HomeFragment
import com.example.it_service_app.fragments.MapFragment
import com.example.it_service_app.fragments.ServiceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    val user_DB = DBHelper(this)
    lateinit var sharedPreferences: SharedPreferences
    val homeFragment = HomeFragment()
    val serviceFragment = ServiceFragment()
    val cartFragment = CartFragment()
    val mapFragment = MapFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

    }


    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

    fun log_in(view: View) {
        setContentView(R.layout.login_page)
    }
    fun log_in_createacc(view: View){
        setContentView(R.layout.registration_page)
    }
    fun create_acc(view: View) {
        setContentView(R.layout.registration_page)
    }
    fun reg_log_acc(view: View){
        setContentView(R.layout.login_page)
    }
    fun create_acc_register(view: android.view.View){
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        val name: EditText = findViewById(R.id.reg_name)
        val surname: EditText = findViewById(R.id.reg_surname)
        val email: EditText = findViewById(R.id.reg_email)
        val password: EditText = findViewById(R.id.reg_pass)
        if(name.text.toString() == "" || surname.text.toString() == "" || email.text.toString() == "" || password.text.toString() == ""){
            Toast.makeText(this, "Fill in all the fields!", Toast.LENGTH_SHORT).show()
        }
        else if (password.text.toString().length < 8){
            Toast.makeText(this, "Password must be more than 8 characters!", Toast.LENGTH_SHORT).show()
        }
        else if(pattern.matcher(email.text.toString()).matches()==false){
            Toast.makeText(this, "Not correct email", Toast.LENGTH_SHORT).show()
        }
        else{
            val user1 = user_DB.insertUserData(name.text.toString(), surname.text.toString(), email.text.toString(), password.text.toString())
            if (user1!= null){
                setContentView(R.layout.login_page)
            }
        }


    }
    fun sign_in_button(view: View){
        val email: EditText = findViewById(R.id.log_email)
        val password: EditText = findViewById(R.id.log_pass)
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        val editor = sharedPreferences.edit()
        editor.putString("MAIL",email.text.toString())
        editor.putString("PASS", password.text.toString())
        editor.apply()

        val user2 = user_DB.userIsInDB(email.text.toString(), password.text.toString())
        if(user2 == false){
            setContentView(R.layout.activity_nav)
            makeCurrentFragment(homeFragment)
            val bottom_navigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
            bottom_navigation.setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.ic_home -> makeCurrentFragment(homeFragment)
                    R.id.ic_service -> makeCurrentFragment(serviceFragment)
                    R.id.ic_cart -> makeCurrentFragment(cartFragment)
                    R.id.ic_map -> makeCurrentFragment(mapFragment)
                }
                true
            }
        }
        else{
            Toast.makeText(this, "Not correct data", Toast.LENGTH_SHORT).show()
        }
    }


}
