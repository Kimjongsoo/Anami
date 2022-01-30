package com.example.anami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.anami.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            var account:String = binding.etAccount.text.toString()
            if(account == "") account = "default"
            Toast.makeText(this, account + "님 환영합니다", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}