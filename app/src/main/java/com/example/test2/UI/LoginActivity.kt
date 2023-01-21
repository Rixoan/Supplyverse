package com.example.test2.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.test2.Database.myDBHelper
import com.example.test2.Models.UserDataModel
import com.example.test2.R
import com.example.test2.SharedPrefHelper.login_sharePrefHelper
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private var filename = "LoginFilePref"
    var mySQLitedb : myDBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Toast.makeText(this,"${tv_username.text.toString().length}",Toast.LENGTH_SHORT).show()

        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        mySQLitedb = myDBHelper(this)

        tv_username.doOnTextChanged { text, start, before, count ->
            val usrlength = tv_username.text.toString().length
            val passlength = tv_password.text.toString().length
            et_pass.error = null
            et_username.error = null

            if(usrlength >0 && passlength > 0){
                login.isEnabled = true
            }
            else
            {
                login.isEnabled = false
            }
        }
        tv_password.doOnTextChanged { text, start, before, count ->
            val usrlength = tv_username.text.toString().length
            val passlength = tv_password.text.toString().length
            et_pass.error = null
            et_username.error = null

            if(usrlength >0 && passlength > 0){
                login.isEnabled = true
            }
            else
            {
                login.isEnabled = false
            }
        }
        ib_login_back.setOnClickListener {
            finish()
        }



    }

    fun login(view: View) {

        if(tv_username.text.toString() != "" && tv_password.text.toString() != ""){
            //var index = checkuser(tv_username.text.toString(),tv_password.text.toString())

            var tmpusr = chechuser1(tv_username.text.toString(),tv_password.text.toString())
            if(tmpusr!=null){
                //Toast.makeText(this,"${index} dengan username : ${userlist[index].username}",Toast.LENGTH_SHORT).show()
                //loginindex = index
                //meyimpan kedalam sharedpref login

                loginuser = tmpusr
                var loginpref = login_sharePrefHelper(this,filename)
//                loginpref.index = index
                loginpref.username = loginuser?.username
                Toast.makeText(this,"Selamat datang ${loginuser!!.username}",Toast.LENGTH_SHORT).show()
                var intent = Intent()
                setResult(RESULT_OK,intent)
                finish()
                
            }
            else{
                Toast.makeText(this,"Username dan password salah",Toast.LENGTH_SHORT).show()
                et_pass.error = "Username atau Password salah !"
                et_username.error = ""
            }


        }


    }
    fun checkuser(username :String, password :String) : Int{
        for((i,value) in userlist.withIndex()){
            if(value.username == username && value.password == password){
                return i
            }

        }
        return -1
    }
    fun chechuser1(username: String, password: String):UserDataModel?{
        var tmplist = mySQLitedb?.viewallusername()
        for(i in tmplist!!){
            if(i.username == username && i.password==password){
                return i
            }

        }
        return null
    }

    fun formregister(view: View) {

        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}