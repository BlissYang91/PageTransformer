package com.example.pagetransformer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding:ViewDataBinding
     lateinit var mFragmensts: List<Fragment>
    private var adapter: MyViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_main)
        initView()
    }

    private fun initView() {
        mFragmensts = listOf(Fragment1(),Fragment2())
        adapter = MyViewPagerAdapter(supportFragmentManager,mFragmensts)
        view_pager.setAdapter(adapter)
        view_pager.setCurrentItem(0,false)
//        view_pager.setOffscreenPageLimit(1)
        for (x in 0..1){
            tab_layout.addTab(tab_layout.newTab().setCustomView(DataGenerator.getTabView(this,x)))
        }

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let { view_pager.setCurrentItem(it,true) }
                Toast.makeText(this@MainActivity,"点击了${tab?.position}",Toast.LENGTH_SHORT).show()
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }


        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }
}
