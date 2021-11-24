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

class ForFragment : Fragment(), View.OnClickListener{
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
        val view: View = inflater.inflate(R.layout.fragment_for, container, false)

        button = view.findViewById(R.id.for1)
        view.findViewById<Button>(R.id.for1).setOnClickListener(this)

        button = view.findViewById(R.id.for2)
        view.findViewById<Button>(R.id.for2).setOnClickListener (this)

        button = view.findViewById(R.id.for3)
        view.findViewById<Button>(R.id.for3).setOnClickListener (this)

        button = view.findViewById(R.id.for4)
        view.findViewById<Button>(R.id.for4).setOnClickListener (this)

        button = view.findViewById(R.id.for5)
        view.findViewById<Button>(R.id.for5).setOnClickListener (this)

        button = view.findViewById(R.id.for6)
        view.findViewById<Button>(R.id.for6).setOnClickListener (this)

        button = view.findViewById(R.id.for7)
        view.findViewById<Button>(R.id.for7).setOnClickListener (this)

        button = view.findViewById(R.id.for8)
        view.findViewById<Button>(R.id.for8).setOnClickListener (this)

        button = view.findViewById(R.id.for9)
        view.findViewById<Button>(R.id.for9).setOnClickListener (this)

        button = view.findViewById(R.id.for10)
        view.findViewById<Button>(R.id.for10).setOnClickListener (this)
        return view
    }

    override fun onClick(v: View?) {
        var idWhenFor:Fragment? = null
        when (v!!.id){
            R.id.for1->{ idWhenFor = For1Fragment() }
            R.id.for2->{ idWhenFor = For2Fragment() }
            R.id.for3->{ idWhenFor = For3Fragment() }
            R.id.for4->{ idWhenFor = For4Fragment() }
            R.id.for5->{ idWhenFor = For5Fragment() }
            R.id.for6->{ idWhenFor = For6Fragment() }
            R.id.for7->{ idWhenFor = For7Fragment() }
            R.id.for8->{ idWhenFor = For8Fragment() }
            R.id.for9->{ idWhenFor = For9Fragment() }
            R.id.for10->{ idWhenFor = For10Fragment() }

        }
        if (idWhenFor!=null) {
            val fragTran = requireActivity().supportFragmentManager.beginTransaction()
            fragTran.replace(R.id.frameL, idWhenFor)
            fragTran.addToBackStack("BackToMain")
            fragTran.commit()
        }
    }override fun onResume() {
        super.onResume()
        sharedViewModel.setTitle("For Tasks")
        val actionBar: androidx.appcompat.app.ActionBar? = (activity as MainActivity?)!!.supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF018786")))
        val bottomNavigationView: BottomNavigationView? = (activity as MainActivity?)!!.findViewById(R.id.bottom_navigation)
        bottomNavigationView?.visibility = View.GONE

    }

}

