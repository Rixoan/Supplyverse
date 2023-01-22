package com.example.test2.Database

import MyDB.userDB
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.test2.Models.UserDataModel

class myDBHelper(context : Context):SQLiteOpenHelper(
    context, DATABASE_NAME,null, DATABASE_VERSION
) {
    companion object{
        private  val  DATABASE_NAME = "mysqlitedb.db"
        private val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {

        var CREATE_USER_TABLE = "CREATE TABLE ${userDB.userTable.TABLE_USER} "+
                "(${userDB.userTable.COLUMN_USERNAME} TEXT PRIMARY KEY,"+
                "${userDB.userTable.COLUMN_PASSWORD} TEXT,"+
                "${userDB.userTable.COLUMN_UMKM} TEXT,"+
                "${userDB.userTable.COLUMN_SUPPLIER} TEXT)"
        db?.execSQL(CREATE_USER_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var DROP_USER_TABLE = "DROP TABLE IF EXISTS ${userDB.userTable.TABLE_USER}"
        db?.execSQL(DROP_USER_TABLE)
        onCreate(db)

    }
    fun addUser(user:UserDataModel):Long{
        var myDB = this.writableDatabase
        var contentValues = ContentValues().apply {
            put(userDB.userTable.COLUMN_USERNAME,user.username)
            put(userDB.userTable.COLUMN_PASSWORD,user.password)
            if(user.umkm == true){
                put(userDB.userTable.COLUMN_UMKM,"true")
            }
            else
                put(userDB.userTable.COLUMN_UMKM,"false")
            if(user.supplier == true){
                put(userDB.userTable.COLUMN_SUPPLIER,"true")
            }
            else
                put(userDB.userTable.COLUMN_SUPPLIER,"false")
        }
        var succes = myDB.insert(userDB.userTable.TABLE_USER,null,contentValues)
        myDB.close()
        return succes
    }
    fun viewallusername():ArrayList<UserDataModel>{
        //var tmplist = ArrayList<String>()
        var tmplistuser = ArrayList<UserDataModel>()

        var select = "SELECT * FROM ${userDB.userTable.TABLE_USER}"
        var myDB = this.readableDatabase
        var cursor :Cursor? = null
        try {
            cursor = myDB.rawQuery(select,null)
        }
        catch (e : SQLException){
            return ArrayList()
        }
        if(cursor.moveToFirst()){
            do {
                var username = cursor.getString(cursor.getColumnIndex(userDB.userTable.COLUMN_USERNAME))
                var pass = cursor.getString(cursor.getColumnIndex(userDB.userTable.COLUMN_PASSWORD))
                var umkm = false
                var supplier = false
                if(cursor.getString(cursor.getColumnIndex(userDB.userTable.COLUMN_UMKM))=="true"){
                    umkm = true
                }
                else{
                    umkm = false
                }
                if(cursor.getString(cursor.getColumnIndex(userDB.userTable.COLUMN_SUPPLIER))=="true"){
                    supplier = true
                }
                else{
                    supplier = false
                }
                //tmplist.add(username)
                tmplistuser.add(UserDataModel(username,pass,umkm,supplier))
            }while (cursor.moveToNext())
        }
        return tmplistuser

    }
    fun deletealluser(){
        var myDB = this.writableDatabase
        myDB.delete(userDB.userTable.TABLE_USER,null,null)
    }

    fun deleteLoginUser(username: String){
        var myDB = this.writableDatabase
        var selection = "${userDB.userTable.COLUMN_USERNAME} = ?"
        var selectionArgs = arrayOf(username)
        myDB.delete(userDB.userTable.TABLE_USER, selection, selectionArgs)
    }
}