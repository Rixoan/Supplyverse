package com.example.test2.UI

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.test2.*
import com.example.test2.Database.myDBHelper
import com.example.test2.Models.UserDataModel
import com.example.test2.SharedPrefHelper.login_sharePrefHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_nav_header.view.*
import kotlin.collections.ArrayList

val userlist = getuser()
var loginindex = -1
var loginuser : UserDataModel? = null


fun getuser():ArrayList<UserDataModel>{

    var usrlist = ArrayList<UserDataModel>()
    usrlist.add(UserDataModel("Supplier_10","12345"))
    usrlist.add(UserDataModel("test_Supplier","12345"))

    return usrlist

}

class MainActivity : AppCompatActivity() {

    var mySQLITEDB : myDBHelper? = null

    lateinit var toggle : ActionBarDrawerToggle


    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(myToolbar)
        supportActionBar!!.title = ""
        supportActionBar!!.elevation = 0f

        mySQLITEDB = myDBHelper(this)
        load_login_sharedpref()


        swipe.setOnRefreshListener {


            swipe.isRefreshing = false

        }


        val homewithTab = HomewithTab()
        val second = SecondFragment()
        val third = ThirdFragment()
        val fourth = fourthFragment()
        val fifth = FifthFragment()

        makeCurrentFragment(homewithTab)



        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){

                R.id.first_navbar -> {makeCurrentFragment(homewithTab)
                    appBarLayout.visibility = View.VISIBLE}
                R.id.second_navbar -> if(loginuser !=null){
                    appBarLayout.visibility = View.VISIBLE
                    makeCurrentFragment(second)
                }
                else{
                    var intent = Intent(this, LoginActivity::class.java)
//                    startActivity(intent)
                    startActivityForResult(intent, LOGIN_REQUEST_CODE)
                }
                //Kode bawah untuk account, apabila belum login maka akan ke login page.
                R.id.third_navbar -> if(true){makeCurrentFragment(third)
                    appBarLayout.visibility = View.VISIBLE}
                else Toast.makeText(this,"Test!!!",Toast.LENGTH_SHORT).show()

                R.id.fourth_navbar -> {makeCurrentFragment(fourth)
                    appBarLayout.visibility = View.VISIBLE}
                R.id.fifth_navbar -> if(loginuser!=null){
                    appBarLayout.visibility = View.GONE
                    makeCurrentFragment(fifth)
                }
                else{
                    var intent = Intent(this, LoginActivity::class.java)
                    //startActivity(intent)
                    startActivityForResult(intent, LOGIN_REQUEST_CODE)
                }
            }
            true
        }

        //Kode Drawer layout
        toggle = ActionBarDrawerToggle(this,drawerlayout, R.string.open, R.string.close)
        drawerlayout.addDrawerListener(toggle)

        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawer_nav.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.first -> {makeCurrentFragment(homewithTab)
                    appBarLayout.visibility = View.VISIBLE}

                R.id.second -> if(loginuser!=null){
                    appBarLayout.visibility = View.VISIBLE
                    makeCurrentFragment(second)
                }
                else{
                    var intent = Intent(this, LoginActivity::class.java)
//                    startActivity(intent)
                    startActivityForResult(intent, LOGIN_REQUEST_CODE)
                }
                //Kode bawah untuk account, apabila belum login maka akan ke login page.
                R.id.third -> if(true){makeCurrentFragment(third)
                    appBarLayout.visibility = View.VISIBLE}
                else Toast.makeText(this,"Test!!!",Toast.LENGTH_SHORT).show()

                R.id.fourth -> {makeCurrentFragment(fourth)
                    appBarLayout.visibility = View.VISIBLE}
                R.id.fifth -> if(loginuser!=null){
                    appBarLayout.visibility = View.GONE
                    makeCurrentFragment(fifth)
                }
                else{
                    var intent = Intent(this, LoginActivity::class.java)
//                    startActivity(intent)
                    startActivityForResult(intent, LOGIN_REQUEST_CODE)
                }
            }
            it.isChecked = true
            drawerlayout.closeDrawers()
            true


        }


        // kode dibawah digunakan apabila user login maka ubah nama user sesuai username.
        var header = drawer_nav.getHeaderView(0)
        if(loginuser!=null){
            header.username.text = loginuser?.username
        }
        else
        {
            header.username.text = "User"
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    private fun makeCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(EXTRA_STATE,bottomNavigationView.selectedItemId)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var tmp = savedInstanceState?.getInt(EXTRA_STATE)?:0
        //Toast.makeText(this, tmp.toString(), Toast.LENGTH_SHORT).show()
        when(tmp){
            R.id.first_navbar -> {makeCurrentFragment(HomewithTab())}
            R.id.second_navbar -> {makeCurrentFragment(SecondFragment())}
            R.id.third_navbar ->{makeCurrentFragment(ThirdFragment())}
            R.id.fourth_navbar ->{makeCurrentFragment(fourthFragment())}
            R.id.fifth_navbar ->{makeCurrentFragment(FifthFragment())}
        }
    }

    override fun onResume() {
        super.onResume()
        //bottomNavigationView.selectedItemId = R.id.first
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== LOGIN_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){

                finish()
                startActivity(intent)
                //Toast.makeText(this,"Selamat datang ${userlist[loginindex].username}",Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun cart(view: View) {

        if(loginuser!=null){
            var intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
        else{
            var intent = Intent(this, LoginActivity::class.java)
//                    startActivity(intent)
            startActivityForResult(intent, LOGIN_REQUEST_CODE)



        }

        //Toast.makeText(this,"You click cart",Toast.LENGTH_SHORT).show()
    }
    fun load_login_sharedpref(){
        var filename = "LoginFilePref"
        var loginpref = login_sharePrefHelper(this,filename)
        //loginindex = loginpref.index!!
        var username = loginpref.username
        var tmplist = mySQLITEDB?.viewallusername()
        for (i in tmplist!!){
            if (username == i.username){
                loginuser = i
            }
        }

    }


}