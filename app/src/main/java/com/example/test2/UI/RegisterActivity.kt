package com.example.test2.UI

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.test2.Database.myDBHelper
import com.example.test2.Models.UserDataModel
import com.example.test2.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    var mySQLitedb : myDBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mySQLitedb = myDBHelper(this)

        tv_register_username.doOnTextChanged { text, start, before, count ->
            val usrlength = tv_register_username.text.toString().length
            val passlength = tv_register_password.text.toString().length
            et_register_username.error = null

            if(usrlength >0 && passlength > 0){
                register.isEnabled = true
            }
            else
            {
                register.isEnabled = false
            }
        }
        tv_register_password.doOnTextChanged { text, start, before, count ->
            val usrlength = tv_register_username.text.toString().length
            val passlength = tv_register_password.text.toString().length

            if(usrlength >0 && passlength > 0){
                register.isEnabled = true
            }
            else
            {
                register.isEnabled = false
            }
        }
    }

    fun register(view: View) {
        var tmplist = mySQLitedb?.viewallusername()
        for (i in tmplist!!){
            if(tv_register_username.text.toString() == i.username){
                Toast.makeText(this,"Username sudah ada",Toast.LENGTH_SHORT).show()
                et_register_username.error = "Username sudah ada"
                return
            }
        }
        var tmpusr = UserDataModel(tv_register_username.text.toString(),tv_register_password.text.toString())
        if(rb_supplier.isChecked){
            tmpusr.supplier = true
        }
        else{
            tmpusr.umkm = true
        }
        //userlist.add(tmpusr)
        var result = mySQLitedb?.addUser(tmpusr)
        if(result!=-1L){
            Toast.makeText(this,"Berhasil register",Toast.LENGTH_SHORT).show()
            readusernamedb()

        }
        else{
            Toast.makeText(this,"Gagal register",Toast.LENGTH_SHORT).show()
        }


        //finish()


    }
    fun readusernamedb(){
        var tmpnama = ""
        Thread(Runnable {
            var tmplist = mySQLitedb?.viewallusername()

            for(i in tmplist!!){
                tmpnama ="$tmpnama"+"${i.username}    ${i.password} \n${i.supplier}  ${i.umkm}\n\n"
            }
            runOnUiThread(Runnable {
                val alertdialog = AlertDialog.Builder(this)
                alertdialog.setTitle("")
                    .setMessage(tmpnama)
                    .setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i -> finish() })
                val alert = alertdialog.create()
                alert.show()
            })


        }).start()


    }

}