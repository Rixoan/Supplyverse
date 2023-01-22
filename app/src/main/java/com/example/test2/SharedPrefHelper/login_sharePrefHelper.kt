package com.example.test2.SharedPrefHelper

import android.content.Context
import android.content.SharedPreferences

class login_sharePrefHelper (context: Context, name: String) {

    val USER_NAME = "NAMA"
    //val PASS = "PASS"
    val INDEX = "INDEX"

    private var mypref : SharedPreferences
    init {
        mypref = context.getSharedPreferences(name,Context.MODE_PRIVATE)
    }
    inline fun SharedPreferences.editMe(operator: (SharedPreferences.Editor)->Unit){
        val editMe = edit()
        operator(editMe)
        editMe.apply()
    }

    var username : String?
    get() = mypref.getString(USER_NAME,"KOSONG")
    set(value){
        //mypref.edit().putString(USER_NAME,value).apply()
        mypref.editMe {
            it.putString(USER_NAME,value)
        }
    }

    var index : Int?
    get() = mypref.getInt(INDEX,-1)
    set(value) {
        //mypref.edit().putInt(INDEX,value!!).apply()
        mypref.editMe {
            it.putInt(INDEX,value!!)

        }
    }
    fun clearValues(){
        //mypref.edit().clear().commit()
        mypref.editMe {
            it.clear()
        }
    }
}