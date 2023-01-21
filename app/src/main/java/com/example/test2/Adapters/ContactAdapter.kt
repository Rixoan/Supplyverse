package com.example.test2.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.Models.ContactDataModel
import com.example.test2.R
import kotlinx.android.synthetic.main.contact_list.view.*

import kotlinx.android.synthetic.main.contact_list_backup.view.*

class ContactAdapter(var list : List<ContactDataModel>): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        return ContactHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.contact_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bindContact(list[position])


    }

    override fun getItemCount(): Int = list.size

    class  ContactHolder (view : View) : RecyclerView.ViewHolder(view){
        var gmbr = view.profile_img
        var fullName = view.contact_name
        var number = view.tv_number
//        var email = view.tv_email
//        var lastName = view.last_name
//        var firstName = view.first_name


        fun bindContact(tmp : ContactDataModel) {
            gmbr.setImageResource(tmp.gmbr)
            fullName.text = tmp.fullname
            number.text = tmp.number
//            email.text = tmp.email
//            firstName.text = tmp.firstname
//            lastName.text = tmp.lastname
        }
    }


}