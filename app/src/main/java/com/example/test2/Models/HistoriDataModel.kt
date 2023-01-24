package com.example.test2.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HistoriDataModel(val supplier : SupplierDataModel = SupplierDataModel(),
                            val tanggal : String = "21-12-2022",
                            val status : Int ): Parcelable
