package com.example.todos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class OptionAdapter(
    private var context: Context,
    private var nameList: ArrayList<String>,
    private var iconList: ArrayList<Int>
) :
    ArrayAdapter<String>(context,R.layout.item_option,nameList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var currImage = convertView

        if(currImage==null)
        {
            currImage = LayoutInflater.from(context).inflate(R.layout.item_option,parent,false)
        }

        var textView : TextView = currImage!!.findViewById(R.id.textOption)
        var imageView : ImageView = currImage!!.findViewById(R.id.iamge_option)

        textView.text = nameList[position]
        imageView.setImageResource(iconList[position])
        return currImage!!

    }
}