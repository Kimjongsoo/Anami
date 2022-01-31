package com.example.anami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anami.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}