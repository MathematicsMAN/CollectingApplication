package ru.ibresi.android.collectingapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ibresi.android.collectingapplication.catalog.BakeListFragment
import ru.ibresi.android.collectingapplication.catalog.ShopListFragment
import ru.ibresi.android.collectingapplication.request.BakeRequestListFragment
import ru.ibresi.android.collectingapplication.request.ShopRequestListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
//            val fragment = BakeListFragment.newInstance()
//            val fragment = ShopListFragment.newInstance()
            val fragment = BakeRequestListFragment.newInstance()
//            val fragment = ShopRequestListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}