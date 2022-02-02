package com.example.anami

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
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

        binding.btnChangeInfo.setOnClickListener {
            val intent = Intent(this, ChangeProfileActivity::class.java)
            startActivity(intent)
        }

        binding.tvLogout.setOnClickListener{
            val pInterface = DialogInterface.OnClickListener{ dialog, which ->
                val sharedPreferences:SharedPreferences = getSharedPreferences("app_shared_pref", Context.MODE_PRIVATE)
                val editor:SharedPreferences.Editor = sharedPreferences.edit()
                editor.putBoolean("isLogin", false)
                editor.apply()

                Toast.makeText(this, "로그아웃 완료", Toast.LENGTH_SHORT).show()
                finishAffinity()
            }

            val dialogBuilder = AlertDialog.Builder(this)
                .setIcon(R.drawable.tmp_anami_icon)
                .setTitle("")
                .setMessage("정말 로그아웃하시겠습니까?")
                .setPositiveButton("네", pInterface)
                .setNegativeButton("아니오", null)

            dialogBuilder.create().show()
        }
    }
}