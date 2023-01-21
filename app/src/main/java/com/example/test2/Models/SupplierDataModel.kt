package com.example.test2.Models
import android.os.Parcelable
import com.example.test2.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SupplierDataModel(
    val nama : String ="",
    val tempat : String ="",
    val itemlist : ArrayList<ItemDataModel> = ArrayList<ItemDataModel>(),
    val gmbr : Int = R.drawable.logo1
):Parcelable

