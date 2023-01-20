package com.example.test2.UI

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.Adapters.ContactAdapter
import com.example.test2.CONTACT_PERMISSION_REQUEST_CODE
import com.example.test2.LOCATION_PERMISSION_REQUEST_CODE
import com.example.test2.Models.ContactDataModel
import com.example.test2.R
import kotlinx.android.synthetic.main.fragment_second.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment(),
    LoaderManager.LoaderCallbacks<Cursor>
{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var gmbrProfile = ContactsContract.CommonDataKinds.Photo.PHOTO
    private var fullName = ContactsContract.Contacts.DISPLAY_NAME
//    private var email = ContactsContract.CommonDataKinds.Email.ADDRESS
//    private var firstName = ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME
//    private var lastName = ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME
    private var number = ContactsContract.CommonDataKinds.Phone.NUMBER

    var myContactList : MutableList<ContactDataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        if (ActivityCompat.checkSelfPermission(this.requireContext(),
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            // request permission
            ActivityCompat.requestPermissions(this.requireActivity(),
                arrayOf(android.Manifest.permission.READ_CONTACTS), CONTACT_PERMISSION_REQUEST_CODE
            )


            return
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contact_recy_view.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ContactAdapter(myContactList)
        }
        LoaderManager.getInstance(this).initLoader(1, null, this)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        var contactURI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        var myProjection = arrayOf(fullName, number)
        return CursorLoader(this.requireContext(), contactURI, myProjection, null, null, "$number ASC")
    }

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        myContactList.clear()
        if (data != null) {
            data.moveToFirst()
            while (!data.isAfterLast) {
//                Toast.makeText(this.requireContext(),data.getColumnIndex(firstname),Toast.LENGTH_SHORT).show()
                myContactList.add(
                    ContactDataModel(
                        data.getString(data.getColumnIndex(fullName)),
//                        data.getString(data.getColumnIndex(firstName)),
//                        data.getString(data.getColumnIndex(lastName)),

                        data.getString(data.getColumnIndex(number))
//                        data.getString(data.getColumnIndex(email))
                    )
                )
                data.moveToNext()
            }
            contact_recy_view.apply {
                layoutManager = LinearLayoutManager(this.context)
                adapter = ContactAdapter(myContactList)
            }
        }
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {

    }

}
