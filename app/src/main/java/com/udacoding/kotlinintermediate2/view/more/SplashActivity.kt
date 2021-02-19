package com.udacoding.kotlinintermediate2.view.more

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.udacoding.kotlinintermediate2.R
import com.udacoding.kotlinintermediate2.helper.SessionManager
import com.udacoding.kotlinintermediate2.view.MainActivity
import com.udacoding.kotlinintermediate2.view.auth.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val session = SessionManager(this)
        Handler().postDelayed(Runnable {
            if(session.login == true){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this, LoginActivity::class.java))
            }

            finish()

        }, 1500)
    }
}