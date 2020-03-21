package com.example.pagetransformer

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


/**
 * @Author yangtianfu
 * @CreateTime 2020/3/21 20:07
 * @Describe
 */
class MyViewPagerAdapter(
    fm: FragmentManager?,
    fragments: List<Fragment>
) :
    FragmentPagerAdapter(fm!!) {
    private val fragments: List<Fragment>
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        fragment = fragments[position]
        val bundle = Bundle()
        bundle.putString("id", "" + position)
        if (fragment != null) {
            fragment.setArguments(bundle)
        }
        return fragment
    }

    override fun getCount(): Int {
        return fragments.size
    }

    init {
        this.fragments = fragments
    }
}