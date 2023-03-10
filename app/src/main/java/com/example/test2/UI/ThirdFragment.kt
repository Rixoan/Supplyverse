package com.example.test2.UI

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test2.Adapters.ItemAdapter
import com.example.test2.Adapters.SupplierAdapter
import com.example.test2.ITEMADD_REQUEST_CODE
import com.example.test2.LOGIN_REQUEST_CODE
import com.example.test2.R
import kotlinx.android.synthetic.main.fragment_third.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view_supplier.apply {
            layoutManager = GridLayoutManager(activity,2,GridLayoutManager.HORIZONTAL,false)
            adapter = SupplierAdapter()
        }
        recycler_view_produk_terbaru.apply {
            layoutManager = GridLayoutManager(activity,2)
            adapter = ItemAdapter(get_all_item(supplierlist))
        }

        floatingActionButton.setOnClickListener {
            if(loginuser!=null){
                var intent = Intent(this.context, Add_ItemActivity::class.java)
                startActivityForResult(intent, ITEMADD_REQUEST_CODE)
            }
            else {
                var intent = Intent(this.context, LoginActivity::class.java)
                startActivityForResult(intent, LOGIN_REQUEST_CODE)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== LOGIN_REQUEST_CODE || requestCode == ITEMADD_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){

                activity?.finish()
                startActivity(activity?.intent)

            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}