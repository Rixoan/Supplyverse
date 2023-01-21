package com.example.test2.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentlist = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()


    override fun getCount(): Int {
        return (fragmentlist.size)
    }

    override fun getItem(position: Int): Fragment {
        return (fragmentlist[position])
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return (fragmentTitleList[position])
    }
    fun addFragment(fragment: Fragment, title :String){
        fragmentlist.add(fragment)
        fragmentTitleList.add((title))
    }

}