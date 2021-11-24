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

class BooleanFragment : Fragment(), View.OnClickListener{
    private lateinit var  button: Button
    private lateinit var sharedViewModel: SharedViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }
    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        requireActivity().window.statusBarColor = Color.parseColor("#D3491E")
        val view: View = inflater.inflate(R.layout.fragment_boolean, container, false)

        button = view.findViewById(R.id.boolean1)
        view.findViewById<Button>(R.id.boolean1).setOnClickListener(this)

        button = view.findViewById(R.id.boolean2)
        view.findViewById<Button>(R.id.boolean2).setOnClickListener (this)

        button = view.findViewById(R.id.boolean3)
        view.findViewById<Button>(R.id.boolean3).setOnClickListener (this)

        button = view.findViewById(R.id.boolean4)
        view.findViewById<Button>(R.id.boolean4).setOnClickListener (this)

        button = view.findViewById(R.id.boolean5)
        view.findViewById<Button>(R.id.boolean5).setOnClickListener (this)

        button = view.findViewById(R.id.boolean6)
        view.findViewById<Button>(R.id.boolean6).setOnClickListener (this)

        button = view.findViewById(R.id.boolean7)
        view.findViewById<Button>(R.id.boolean7).setOnClickListener (this)

        button = view.findViewById(R.id.boolean8)
        view.findViewById<Button>(R.id.boolean8).setOnClickListener (this)

        button = view.findViewById(R.id.boolean9)
        view.findViewById<Button>(R.id.boolean9).setOnClickListener (this)

        button = view.findViewById(R.id.boolean10)
        view.findViewById<Button>(R.id.boolean10).setOnClickListener (this)
        return view
    }

    override fun onClick(v: View?) {
        var idWhenBoolean:Fragment? = null
        when (v!!.id){
            R.id.boolean1->{ idWhenBoolean = Boolean1Fragment() }
            R.id.boolean2->{ idWhenBoolean = Boolean2Fragment() }
            R.id.boolean3->{ idWhenBoolean = Boolean3Fragment() }
            R.id.boolean4->{ idWhenBoolean = Boolean4Fragment() }
            R.id.boolean5->{ idWhenBoolean = Boolean5Fragment() }
            R.id.boolean6->{ idWhenBoolean = Boolean6Fragment() }
            R.id.boolean7->{ idWhenBoolean = Boolean7Fragment() }
            R.id.boolean8->{ idWhenBoolean = Boolean8Fragment() }
            R.id.boolean9->{ idWhenBoolean = Boolean9Fragment() }
            R.id.boolean10->{ idWhenBoolean = Boolean10Fragment() }

        }
        if (idWhenBoolean!=null) {
            val fragTran = requireActivity().supportFragmentManager.beginTransaction()
            fragTran.replace(R.id.frameL, idWhenBoolean)
            fragTran.addToBackStack("BackToMain")
            fragTran.commit()
        }
    }override fun onResume() {
        super.onResume()
        sharedViewModel.setTitle("Boolean Tasks")
        val actionBar: androidx.appcompat.app.ActionBar? = (activity as MainActivity?)!!.supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF5722")))
        val bottomNavigationView: BottomNavigationView? = (activity as MainActivity?)!!.findViewById(R.id.bottom_navigation)
        bottomNavigationView?.visibility = View.GONE

    }

}

