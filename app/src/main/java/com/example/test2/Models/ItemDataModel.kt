package com.example.test2.Models

import android.os.Parcelable
import com.example.test2.R
import kotlinx.android.parcel.Parcelize
@Parcelize
data class ItemDataModel(var itemname:String = "",
                         var itemprice:Float = 0f,
                         var supplier : String="",
                         val gmbr : Int = R.drawable.item_1 ):Parcelable
