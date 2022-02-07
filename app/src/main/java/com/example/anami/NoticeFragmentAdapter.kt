package com.example.anami

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


open class NoticeFragmentAdapter (fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val fragment = when(position)
        {
            0->NoticeOneFragment().newInstant()
            1->NoticeTwoFragment().newInstant()
            2->NoticeThreeFragment().newInstant()
            else-> NoticeOneFragment().newInstant()
        }
        return fragment
    }

    //notice_tab의 개수만큼 return
    override fun getCount(): Int = 3

    //notice_tab의 이름 fragment마다 바꾸게 하기
    override fun getPageTitle(position: Int): CharSequence?{
        val title = when(position)
        {
            0->"이번 달"
            1->"저번 달"
            2->"이 전"
            else ->"main"
        }
        return title
    }

}