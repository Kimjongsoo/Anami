package com.example.anami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager

class NoticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)

        val notice_pagerAdapter = NoticeFragmentAdapter(supportFragmentManager)
        val pager= findViewById<ViewPager>(R.id.notice_viewPager)
        pager.adapter = notice_pagerAdapter
        val notice_tab = findViewById<TabLayout>(R.id.notice_tab)
        notice_tab.setupWithViewPager(pager)

    }

}