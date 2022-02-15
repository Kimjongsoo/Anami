package com.example.anami

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import com.example.anami.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //자동 로그인을 위한 sharedPreference
        sharedPreferences = getSharedPreferences("app_shared_pref", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()


        if(sharedPreferences.getBoolean("isLogin", false)){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        
        //로그인 버튼 작동
        binding.btnLogin.setOnClickListener{
            if(binding.etAccount.text.toString() == "" || binding.etPassword.text.toString() == "") {
                Toast.makeText(this,"아이디와 비밀번호를 모두 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, MainActivity::class.java)

                if (binding.cbAutoLogin.isChecked) {
                    editor.putBoolean("isLogin", true)
                    editor.apply()
                }

                var account: String = binding.etAccount.text.toString()
                if (account == "") account = "default"
                Toast.makeText(this, account + "님 환영합니다", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }
        }
    }
}