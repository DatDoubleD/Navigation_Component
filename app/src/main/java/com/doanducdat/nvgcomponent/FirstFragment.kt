package com.doanducdat.nvgcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val controller = findNavController()

        btn_open_fragTwo.setOnClickListener {

            //pass data = bundle
            val user1:User = User(edtUserName.text.toString(), edtAge.text.toString())
            val bundle:Bundle = bundleOf(
                "DATA" to edtData.text.toString(),
                "USER" to user1
            )
            //pas data =
            //có thể gọi id của destination(thẻ fragment trong nvg_graph) hoăc id của action của destination đó
            controller.navigate(R.id.secondFragment, bundle)
        }

        btn_open_fragThird.setOnClickListener {
            controller.navigate(R.id.thirdFragment)
        }
    }
}