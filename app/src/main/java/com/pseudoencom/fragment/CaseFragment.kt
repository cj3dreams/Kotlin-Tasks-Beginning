package com.pseudoencom.fragment

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView

class CaseFragment : Fragment(), View.OnClickListener{
    private lateinit var  button: Button
    private lateinit var sharedViewModel: SharedViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }
    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        requireActivity().window.statusBarColor = Color.parseColor("#016161")
        val view: View = inflater.inflate(R.layout.fragment_case, container, false)

        button = view.findViewById(R.id.case1)
        view.findViewById<Button>(R.id.case1).setOnClickListener(this)

        button = view.findViewById(R.id.case2)
        view.findViewById<Button>(R.id.case2).setOnClickListener (this)

        button = view.findViewById(R.id.case3)
        view.findViewById<Button>(R.id.case3).setOnClickListener (this)

        button = view.findViewById(R.id.case4)
        view.findViewById<Button>(R.id.case4).setOnClickListener (this)

        button = view.findViewById(R.id.case5)
        view.findViewById<Button>(R.id.case5).setOnClickListener (this)

        button = view.findViewById(R.id.case6)
        view.findViewById<Button>(R.id.case6).setOnClickListener (this)

        button = view.findViewById(R.id.case7)
        view.findViewById<Button>(R.id.case7).setOnClickListener (this)

        button = view.findViewById(R.id.case8)
        view.findViewById<Button>(R.id.case8).setOnClickListener (this)

        button = view.findViewById(R.id.case9)
        view.findViewById<Button>(R.id.case9).setOnClickListener (this)

        button = view.findViewById(R.id.case10)
        view.findViewById<Button>(R.id.case10).setOnClickListener (this)
        return view
    }

    override fun onClick(v: View?) {
        var idWhenCase:Fragment? = null
        when (v!!.id){
            R.id.case1->{ idWhenCase = Case1Fragment() }
            R.id.case2->{ idWhenCase = Case2Fragment() }
            R.id.case3->{ idWhenCase = Case3Fragment() }
            R.id.case4->{ idWhenCase = Case4Fragment() }
            R.id.case5->{ idWhenCase = Case5Fragment() }
            R.id.case6->{ idWhenCase = Case6Fragment() }
            R.id.case7->{ idWhenCase = Case7Fragment() }
            R.id.case8->{ idWhenCase = Case8Fragment() }
            R.id.case9->{ idWhenCase = Case9Fragment() }
            R.id.case10->{ idWhenCase = Case10Fragment() }

        }
        if (idWhenCase!=null) {
            val fragTran = requireActivity().supportFragmentManager.beginTransaction()
            fragTran.replace(R.id.frameL, idWhenCase)
            fragTran.addToBackStack("BackToMain")
            fragTran.commit()
        }
    }override fun onResume() {
        super.onResume()
        sharedViewModel.setTitle("Case Tasks")
        val actionBar: androidx.appcompat.app.ActionBar? = (activity as MainActivity?)!!.supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF018786")))
        val bottomNavigationView: BottomNavigationView? = (activity as MainActivity?)!!.findViewById(R.id.bottom_navigation)
        bottomNavigationView?.visibility = View.GONE

    }

}

