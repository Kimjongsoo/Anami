package com.example.anami

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ManageListAdapter (private val items: MutableList<ManageListItem>): BaseAdapter(){
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {

        var convertView = view
        if (convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.manage_list, parent, false)
        else {
            val item: ManageListItem = items[position]
//            convertView.findViewById<View>(R.id.text_month) = item.month
//            convertView.findViewById<View>(R.id.text_score)
//            convertView!!.text_month.text = item.month
//            convertView.text_score.text = item . score
//            convertView.text_homework.text = item.homework
        }

        return convertView
    }

    override fun getItem(position: Int): ManageListItem = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = items.size




}