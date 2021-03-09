package com.doanducdat.nvgcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val controller = findNavController()
        //nhận data từ bundle
        val bundle: Bundle? = arguments
        if (bundle != null) {
            val user1: User = bundle.getSerializable("USER") as User
            txtText.text = bundle.getString("DATA")
            txtUser.text = user1.toString()
        }


        btn_open_fragThird.setOnClickListener {
            controller.navigate(R.id.thirdFragment)
        }
    }
}