package com.example.test2.UI

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test2.Adapters.ItemAdapter
import com.example.test2.Models.ItemDataModel
import com.example.test2.Models.PromoDataModel
import com.example.test2.Models.SupplierDataModel
import com.example.test2.R
import kotlinx.android.synthetic.main.fragment_home.*
import com.synnapps.carouselview.ImageListener


var supplierlist = get_supplier()
var cart = get_cart()
var promo = get_promo()
//val list = get_all_item(supplierlist)
var img :Bitmap ?= null




fun get_promo():ArrayList<PromoDataModel>{
    val promolist = ArrayList<PromoDataModel>()
    promolist.add(PromoDataModel(gmbr = R.drawable.event1))
    promolist.add(PromoDataModel(gmbr = R.drawable.event2))
    promolist.add(PromoDataModel(gmbr = R.drawable.event3))
    promolist.add(PromoDataModel(gmbr = R.drawable.event4))
    promolist.add(PromoDataModel(gmbr = R.drawable.event1))
    promolist.add(PromoDataModel(gmbr = R.drawable.event2))
    promolist.add(PromoDataModel(gmbr = R.drawable.event3))
    return promolist
}

fun get_item(supplier : String):ArrayList<ItemDataModel> {
    val list = ArrayList<ItemDataModel>()
    list.add(ItemDataModel("Item_1", 9500F,supplier, R.drawable.item_1))
    list.add(ItemDataModel("Item_2", 10500F,supplier, R.drawable.item_2))
    list.add(ItemDataModel("Item_3", 10000F,supplier, R.drawable.item_3))
    list.add(ItemDataModel("Item_4", 10000F,supplier, R.drawable.item_4))
    list.add(ItemDataModel("Item_5", 9500F,supplier, R.drawable.item_5))

//    for ( i in 1..15){
//        var nama = "Item" + i.toString()
//        var price = 50000F + (1000*i)
//        list.add(ItemDataModel(nama,price))
//    }

    return list
}

fun get_supplier():ArrayList<SupplierDataModel>{
    var supplierlist = ArrayList<SupplierDataModel>()
    supplierlist.add(SupplierDataModel("Supplier_1","Medan bla bla bla", get_item("Supplier_1"),
        R.drawable.logo1
    ))
    supplierlist.add(SupplierDataModel("Supplier_2","Medan bla bla bla", get_item("Supplier_2"),
        R.drawable.logo2
    ))
    supplierlist.add(SupplierDataModel("Supplier_3","Medan bla bla bla", get_item("Supplier_3"),
        R.drawable.logo3
    ))
    supplierlist.add(SupplierDataModel("Supplier_4","Medan bla bla bla", get_item("Supplier_4"),
        R.drawable.logo4
    ))
    supplierlist.add(SupplierDataModel("Supplier_5","Medan bla bla bla", get_item("Supplier_5"),
        R.drawable.logo5
    ))


    return supplierlist

}
fun get_cart():ArrayList<SupplierDataModel>{
    var supplierlist = ArrayList<SupplierDataModel>()
    var tmp_cart = SupplierDataModel("Supplier_1","",ArrayList<ItemDataModel>())
    tmp_cart.itemlist.add(ItemDataModel("Item_1",9500f,tmp_cart.nama))
    tmp_cart.itemlist.add(ItemDataModel("Item_2",9500f,tmp_cart.nama))

    supplierlist.add(tmp_cart)

    tmp_cart = SupplierDataModel("Supplier_2","",ArrayList<ItemDataModel>())
    tmp_cart.itemlist.add(ItemDataModel("Item_1",9500f,tmp_cart.nama))
    supplierlist.add(tmp_cart)
    tmp_cart = SupplierDataModel("Supplier_3","",ArrayList<ItemDataModel>())
    tmp_cart.itemlist.add(ItemDataModel("Item_1",9500f,tmp_cart.nama))
    supplierlist.add(tmp_cart)

    return  supplierlist
}


fun get_all_item(supplierlist : ArrayList<SupplierDataModel>):ArrayList<ItemDataModel>{
    val list = ArrayList<ItemDataModel>()
    for(i in supplierlist){
        for(j in i.itemlist){
            //j.itemname += "[${i.nama}]" //hanya contoh untuk menambahkan nama supplier di belakang nama item
            list.add(j)
        }
    }
    return  list
}

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
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


        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycle_view_item.apply {
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            adapter = ItemAdapter(get_all_item(supplierlist))
        }

        recycle_view_item_Rekomen.apply {
            layoutManager = GridLayoutManager(activity,2)
            adapter = ItemAdapter(get_all_item(supplierlist))
        }
        recycle_view_item_Rekomen.isNestedScrollingEnabled = false
        //frameLayout.isNestedScrollingEnabled = false

        //carousel view
        val bannerlist = intArrayOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
        )

        val imagesListener = ImageListener { index:Int, imageView: ImageView ->
            imageView.setImageResource(bannerlist[index])
        }
        cv_banner.setImageListener(imagesListener)
        cv_banner.pageCount = bannerlist.size






    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}