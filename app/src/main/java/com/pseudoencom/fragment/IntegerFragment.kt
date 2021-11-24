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
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView

class IntegerFragment : Fragment(), View.OnClickListener{
    private lateinit var  button: Button
    private lateinit var sharedViewModel: SharedViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }
    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        requireActivity().window.statusBarColor = Color.parseColor("#C8527A")
        val view: View = inflater.inflate(R.layout.fragment_integer, container, false)

        button = view.findViewById(R.id.integer1)
        view.findViewById<Button>(R.id.integer1).setOnClickListener(this)

        button = view.findViewById(R.id.integer2)
        view.findViewById<Button>(R.id.integer2).setOnClickListener (this)

        button = view.findViewById(R.id.integer3)
        view.findViewById<Button>(R.id.integer3).setOnClickListener (this)

        button = view.findViewById(R.id.integer4)
        view.findViewById<Button>(R.id.integer4).setOnClickListener (this)

        button = view.findViewById(R.id.integer5)
        view.findViewById<Button>(R.id.integer5).setOnClickListener (this)

        button = view.findViewById(R.id.integer6)
        view.findViewById<Button>(R.id.integer6).setOnClickListener (this)

        button = view.findViewById(R.id.integer7)
        view.findViewById<Button>(R.id.integer7).setOnClickListener (this)

        button = view.findViewById(R.id.integer8)
        view.findViewById<Button>(R.id.integer8).setOnClickListener (this)

        button = view.findViewById(R.id.integer9)
        view.findViewById<Button>(R.id.integer9).setOnClickListener (this)

        button = view.findViewById(R.id.integer10)
        view.findViewById<Button>(R.id.integer10).setOnClickListener (this)
        return view
    }

    override fun onClick(v: View?) {
        var idWhenInteger:Fragment? = null
        when (v!!.id){
            R.id.integer1->{ idWhenInteger = Integer1Fragment() }
            R.id.integer2->{ idWhenInteger = Integer2Fragment() }
            R.id.integer3->{ idWhenInteger = Integer3Fragment() }
            R.id.integer4->{ idWhenInteger = Integer4Fragment() }
            R.id.integer5->{ idWhenInteger = Integer5Fragment() }
            R.id.integer6->{ idWhenInteger = Integer6Fragment() }
            R.id.integer7->{ idWhenInteger = Integer7Fragment() }
            R.id.integer8->{ idWhenInteger = Integer8Fragment() }
            R.id.integer9->{ idWhenInteger = Integer9Fragment() }
            R.id.integer10->{ idWhenInteger = Integer10Fragment() }

        }
        if (idWhenInteger!=null) {
            val fragTran = requireActivity().supportFragmentManager.beginTransaction()
            fragTran.replace(R.id.frameL, idWhenInteger)
            fragTran.addToBackStack("BackToMain")
            fragTran.commit()
        }
    }
    override fun onResume() {
        super.onResume()
        sharedViewModel.setTitle("Integer Tasks")
        val actionBar: androidx.appcompat.app.ActionBar? = (activity as MainActivity?)!!.supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#F06292")))
        val bottomNavigationView: BottomNavigationView? = (activity as MainActivity?)!!.findViewById(R.id.bottom_navigation)
        bottomNavigationView?.visibility = View.GONE

    }
}

