package com.example.loginandregistrationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*

class MainActivity : AppCompatActivity() {

    lateinit var handler:DatabaseUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        handler = DatabaseUtils(this)
        renderHome()

        registration.setOnClickListener {
            renderRegistration();
        }

        login.setOnClickListener {
            renderLogIn();
        }

        save.setOnClickListener{
            handler.insertUserInfo(name.text.toString(), email.text.toString(), password_register.text.toString())
            renderHome()
        }

        login_button.setOnClickListener {
            if(handler.isUserPresentInDatabase(login_email.text.toString(), login_password.text.toString())){
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun renderRegistration(){
        registration_layout.visibility = View.VISIBLE;
        login_layout.visibility = View.GONE;
        home_ll.visibility = View.GONE;
    }

    fun renderLogIn() {
        registration_layout.visibility = View.GONE;
        login_layout.visibility = View.VISIBLE;
        home_ll.visibility = View.GONE;
    }

    fun renderHome() {
        registration_layout.visibility = View.GONE;
        login_layout.visibility = View.GONE;
        home_ll.visibility = View.VISIBLE;
    }
}
