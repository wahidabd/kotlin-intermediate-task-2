package com.udacoding.kotlinintermediate2.view.more

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udacoding.kotlinintermediate2.R
import com.udacoding.kotlinintermediate2.helper.SessionManager
import com.udacoding.kotlinintermediate2.view.MainActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private var sessionManager: SessionManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sessionManager = SessionManager(this)
        tv_profile_username.text = sessionManager?.nama
        tv_profile_name.text = sessionManager?.nama
        tv_profile_hp.text = sessionManager?.hp
        tv_profile_email.text = sessionManager?.email

        img_profile_back.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
            onBackPressed()
        }
    }
}