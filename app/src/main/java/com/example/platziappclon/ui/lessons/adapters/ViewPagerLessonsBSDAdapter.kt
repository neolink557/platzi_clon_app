package com.example.platziappclon.ui.lessons.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerLessonsBSDAdapter(activity:FragmentActivity,private val mFragmentList:List<Fragment>):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return mFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragmentList[position]
    }
}