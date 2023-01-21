package com.example.test2.Models
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDataModel(val username : String, val password : String, var umkm : Boolean = false, var supplier :Boolean = false):Parcelable
