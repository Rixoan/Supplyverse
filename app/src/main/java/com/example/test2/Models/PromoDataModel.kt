package com.example.test2.Models
import android.os.Parcelable
import com.example.test2.R
import kotlinx.android.parcel.Parcelize
@Parcelize
data class PromoDataModel(val nama :String = "" , val tanggal : String = "17 - 18 Desember 2022", val gmbr : Int = R.drawable.event1):Parcelable
