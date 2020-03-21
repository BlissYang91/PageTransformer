package com.example.pagetransformer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * @Author yangtianfu
 * @CreateTime 2020/3/21 19:51
 * @Describe
 */
class DataGenerator {
    companion object{
        val title = arrayOf("VV7","VV6")
        val describe = arrayOf("智在向前\n担当wey来","222智在向前\\n担当wey来")
        fun getTabView(context: Context, position:Int) : View {
            val view: View =
                LayoutInflater.from(context).inflate(R.layout.tab_item, null)
            var tv_name: TextView = view.findViewById(R.id.tv_name)
            tv_name.setText(title[position])
            var tv_des: TextView = view.findViewById(R.id.tv_des)
            tv_des.setText(describe[position])
            return view
        }
    }
}