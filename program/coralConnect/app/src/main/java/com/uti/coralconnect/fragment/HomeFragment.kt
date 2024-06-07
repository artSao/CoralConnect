package com.uti.coralconnect.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.uti.coralconnect.R

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var originalButtonBackgroundColors = mutableListOf<Int>()
    private var originalButtonTextColor = 0

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
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val btnAll: Button = view.findViewById(/* id = */ R.id.category_btn_all)
        val btnFamous: Button = view.findViewById(/* id = */ R.id.category_btn_famous)
        val btnNewest: Button = view.findViewById(/* id = */ R.id.category_btn_newest)

        originalButtonBackgroundColors.add(btnAll.backgroundTintList?.defaultColor ?: Color.TRANSPARENT)
        originalButtonBackgroundColors.add(btnFamous.backgroundTintList?.defaultColor ?: Color.TRANSPARENT)
        originalButtonBackgroundColors.add(btnNewest.backgroundTintList?.defaultColor ?: Color.TRANSPARENT)
        originalButtonTextColor = btnAll.currentTextColor

        replaceFragment(ContentFragment())

        btnAll.setOnClickListener{
            resetButtonColors(view)
            btnAll.setBackgroundColor(Color.BLACK)
            btnAll.setTextColor(Color.WHITE)
            replaceFragment(ContentFragment())
        }

        btnFamous.setOnClickListener{
            resetButtonColors(view) // Mengatur ulang warna tombol
            btnFamous.setBackgroundColor(Color.BLACK) // Ubah warna latar belakang tombol
            btnFamous.setTextColor(Color.WHITE) // Ubah warna teks tombol
            replaceFragment(PopularContentFragment())
        }

        btnNewest.setOnClickListener{
            resetButtonColors(view)
            btnNewest.setBackgroundColor(Color.BLACK)
            btnNewest.setTextColor(Color.WHITE)
            replaceFragment(NewstContentFragment())
        }

        return view
    }
    // Reset Warna Background dan ColorText Ketika berpindah button
    private fun resetButtonColors(view: View) {
        val btnAll: Button = view.findViewById(/* id = */ R.id.category_btn_all)
        val btnFamous: Button = view.findViewById(/* id = */ R.id.category_btn_famous)
        val btnNewest: Button = view.findViewById(/* id = */ R.id.category_btn_newest)

        btnAll.setBackgroundColor(Color.parseColor("#f0efef"))
        btnAll.setTextColor(Color.BLACK)
        btnFamous.setBackgroundColor(Color.parseColor("#f0efef"))
        btnFamous.setTextColor(Color.BLACK)
        btnNewest.setBackgroundColor(Color.parseColor("#f0efef"))
        btnNewest.setTextColor(Color.BLACK)

    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.display_content, fragment).addToBackStack(null).commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}