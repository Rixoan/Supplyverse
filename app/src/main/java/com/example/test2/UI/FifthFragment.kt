package com.example.test2.UI

import android.content.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.test2.Database.myDBHelper
import com.example.test2.R
import com.example.test2.SharedPrefHelper.login_sharePrefHelper
import kotlinx.android.synthetic.main.fragment_fifth.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FifthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class FifthFragment : Fragment() {


    var mySQLitedb : myDBHelper? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        mySQLitedb = myDBHelper(requireContext())

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_logout.setOnClickListener {
            Toast.makeText(activity,"logout", Toast.LENGTH_SHORT).show()
            //loginindex = -1
            loginuser = null
            //menghapus data shared pref login
            var filename = "LoginFilePref"
            var loginpref = login_sharePrefHelper(requireContext(),filename)
            loginpref.clearValues()


            activity?.finish()
            startActivity(activity?.intent)
        }

        bt_delete.setOnClickListener {
            Toast.makeText(activity,"Delete Account", Toast.LENGTH_SHORT).show()
            mySQLitedb?.deleteLoginUser(loginuser?.username.toString())
            loginuser = null
            var filename = "LoginFilePref"
            var loginpref = login_sharePrefHelper(requireContext(),filename)
            loginpref.clearValues()
            activity?.finish()
            startActivity(activity?.intent)
        }

        histori.setOnClickListener {
            var intent = Intent(this.context, HistoriActivity::class.java)
            startActivity(intent)
        }


        if(loginuser!=null){
            usernameHolder.text = loginuser?.username
        }
        else{
            usernameHolder.text = "User"

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fifth, container, false)
    }
}
