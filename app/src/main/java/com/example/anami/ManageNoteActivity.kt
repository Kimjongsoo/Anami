package com.example.anami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TabHost

class ManageNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_note)

        val tabHost: TabHost = findViewById<TabHost>(R.id.tabHost1)
        tabHost.setup()

        val tab1 = tabHost.newTabSpec("Tab 1")
        tab1.setIndicator("이번 달")
        tab1.setContent(R.id.tab1)
        tabHost.addTab(tab1)

        val tab2 = tabHost.newTabSpec("Tab 2")
        tab2.setIndicator("저번 달")
        tab1.setContent(R.id.tab2)
        tabHost.addTab(tab2)

        val tab3 = tabHost.newTabSpec("Tab 3")
        tab3.setIndicator("이전 달")
        tab3.setContent(R.id.tab3)
        tabHost.addTab(tab3)

        tabHost.currentTab = 0

    }
}