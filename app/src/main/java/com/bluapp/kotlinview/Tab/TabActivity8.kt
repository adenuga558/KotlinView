package com.bluapp.kotlinview.Tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bluapp.kotlinview.R
import com.google.android.material.tabs.TabLayout

class TabActivity8 : AppCompatActivity() {
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab8)
        tabLayout = findViewById(R.id.tabs) as TabLayout
        viewPager = findViewById(R.id.viewpager) as ViewPager
        viewPager!!.setAdapter(MyAdapter(supportFragmentManager))
        tabLayout!!.post(Runnable { tabLayout!!.setupWithViewPager(viewPager) })
        selectTab(3)

    }

    private fun selectTab(index: Int) {
        Handler().postDelayed(Runnable {
            tabLayout!!.setScrollPosition(index, 0f, true)
            viewPager!!.currentItem = index
        }, 100)
    }


    private inner class MyAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val int_items = 5;

        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = TabFragment()
                1 -> fragment = TabFragment()
                2 -> fragment = TabFragment()
                3 -> fragment = TabFragment()
                4 -> fragment = TabFragment()
            }
            return fragment!!
        }

        override fun getCount(): Int {
            return int_items
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "TabLayout1"
                1 -> return "TabLayout2"
                2 -> return "TabLayout3"
                3 -> return "TabLayout4"
                4 -> return "TabLayout5"
            }
            return null
        }
    }
}
