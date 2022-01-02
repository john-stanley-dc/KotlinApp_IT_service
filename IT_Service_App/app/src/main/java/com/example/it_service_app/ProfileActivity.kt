package com.example.it_service_app
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.it_service_app.fragments.CartFragment
import com.example.it_service_app.fragments.HomeFragment
import com.example.it_service_app.fragments.MapFragment
import com.example.it_service_app.fragments.ServiceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity: AppCompatActivity() {
    val homeFragment = HomeFragment()
    val serviceFragment = ServiceFragment()
    val cartFragment = CartFragment()
    val mapFragment = MapFragment()
    fun start(){
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
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }


}