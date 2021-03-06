package com.bluapp.kotlinview.ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bluapp.kotlinview.R

class ViewPagerActivity14 : AppCompatActivity() {
    private var viewPager: ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager14)
        viewPager = findViewById(R.id.viewpager) as ViewPager2
        viewPager!!.adapter = MyAdapter(supportFragmentManager, lifecycle)
        viewPager!!.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private inner class MyAdapter(fm: FragmentManager?, lifecycle: Lifecycle) : FragmentStateAdapter(fm!!, lifecycle) {
        private val int_items = 5

        override fun createFragment(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = ViewPagerFragment()
                1 -> fragment = ViewPagerFragment()
                2 -> fragment = ViewPagerFragment()
                3 -> fragment = ViewPagerFragment()
                4 -> fragment = ViewPagerFragment()
            }
            return fragment!!
        }

        override fun getItemCount(): Int {
            return int_items
        }

    }
}
