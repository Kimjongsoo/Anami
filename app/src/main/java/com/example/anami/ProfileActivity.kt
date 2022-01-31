package com.example.anami

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.anami.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding:ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogout.setOnClickListener{
            val sharedPreferences:SharedPreferences = getSharedPreferences("app_shared_pref", Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean("isLogin", false)
            editor.apply()

            Toast.makeText(this, "로그아웃 완료", Toast.LENGTH_SHORT).show()
            //앱 종료 후 재시작
            finishAffinity()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            System.exit(1)
        }
    }
}