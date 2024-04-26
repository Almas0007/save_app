package kz.iitu.umutpa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.iitu.umutpa.dailyroutine.DailyRoutineFragment
import kz.iitu.umutpa.dashboard.DashbaordFragment
import kz.iitu.umutpa.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    lateinit var fragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.color.purple))
        loadFragment(DashbaordFragment())
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_dashboard -> {
                    fragment = DashbaordFragment()
                    supportActionBar?.title = resources.getString(R.string.dashboard)
                }
                R.id.navigation_daily_routine -> {
                    fragment = DailyRoutineFragment()
                    supportActionBar?.title = resources.getString(R.string.daily_routine)
                }
                R.id.navigation_profile -> {
                    fragment = ProfileFragment()
                    supportActionBar?.title = resources.getString(R.string.profile)

                }
            }

            loadFragment(fragment)
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }
}