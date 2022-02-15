package com.example.anami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.anami.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //time
    var bpTime:Long = 0

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //임시 버튼으로 액티비티 연결 (디자인 후 재편성하기)
        binding.btnTmpManage.setOnClickListener {
            val intent = Intent(this,ManageNoteActivity::class.java)
            startActivity(intent)
        }
        binding.btnTmpProfile.setOnClickListener {
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.btnTmpNotice.setOnClickListener {
            val intent = Intent(this,NoticeActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        val curTime:Long = System.currentTimeMillis()
        val tg:Long = curTime - bpTime

        if(tg in 0..2000)
            finish()
        else{
            bpTime = curTime
            Toast.makeText(this, "'뒤로'버튼을 한 번 더 누르시면 종료됩니다.",Toast.LENGTH_SHORT).show()
        }
    }
}