package com.example.test2.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test2.Adapters.PromoAdapter
import com.example.test2.R
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.cv_banner
import kotlinx.android.synthetic.main.fragment_recomend.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecomendFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecomendFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_recomend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycle_view_promo.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PromoAdapter()
        }
        recycle_view_promo.isNestedScrollingEnabled =false
        //n_scrollView_recomend.isNestedScrollingEnabled = false



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
         * @return A new instance of fragment RecomendFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecomendFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}