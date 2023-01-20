package com.example.test2.Models

import android.os.Parcelable
import com.example.test2.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactDataModel(
    var fullname : String = "",
//    var firstname : String = "",
//    var lastname : String = "",
    var number : String = "",
//    var email : String = "",
    var gmbr : Int = R.mipmap.ic_launcher_round
):Parcelable