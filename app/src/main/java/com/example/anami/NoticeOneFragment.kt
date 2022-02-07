package com.example.anami

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class NoticeOneFragment: Fragment(){

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notice_one, container, false)
    }

    companion object{

        fun newInstance(param1: String, param2: String)=
            NoticeOneFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun newInstant() : NoticeOneFragment
    {
        val args = Bundle()
        val frag = NoticeOneFragment()
        frag.arguments = args

        return frag
    }
}