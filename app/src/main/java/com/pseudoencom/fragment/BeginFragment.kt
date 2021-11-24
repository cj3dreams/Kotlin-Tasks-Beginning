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

class BeginFragment : Fragment(), View.OnClickListener{
    private lateinit var  button: Button
    private lateinit var sharedViewModel: SharedViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }
    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        requireActivity().window.statusBarColor = Color.parseColor("#535C8A")
        val view: View = inflater.inflate(R.layout.fragment_begin, container, false)

        button = view.findViewById(R.id.begin1)
        view.findViewById<Button>(R.id.begin1).setOnClickListener(this)

        button = view.findViewById(R.id.begin2)
        view.findViewById<Button>(R.id.begin2).setOnClickListener (this)

        button = view.findViewById(R.id.begin3)
        view.findViewById<Button>(R.id.begin3).setOnClickListener (this)

        button = view.findViewById(R.id.begin4)
        view.findViewById<Button>(R.id.begin4).setOnClickListener (this)

        button = view.findViewById(R.id.begin5)
        view.findViewById<Button>(R.id.begin5).setOnClickListener (this)

        button = view.findViewById(R.id.begin6)
        view.findViewById<Button>(R.id.begin6).setOnClickListener (this)

        button = view.findViewById(R.id.begin7)
        view.findViewById<Button>(R.id.begin7).setOnClickListener (this)

        button = view.findViewById(R.id.begin8)
        view.findViewById<Button>(R.id.begin8).setOnClickListener (this)

        button = view.findViewById(R.id.begin9)
        view.findViewById<Button>(R.id.begin9).setOnClickListener (this)

        button = view.findViewById(R.id.begin10)
        view.findViewById<Button>(R.id.begin10).setOnClickListener (this)
        return view
    }

    override fun onClick(v: View?) {
        var idWhenBegin:Fragment? = null
        when (v!!.id){
            R.id.begin1->{ idWhenBegin = Begin1Fragment() }
            R.id.begin2->{ idWhenBegin = Begin2Fragment() }
            R.id.begin3->{ idWhenBegin = Begin3Fragment() }
            R.id.begin4->{ idWhenBegin = Begin4Fragment() }
            R.id.begin5->{ idWhenBegin = Begin5Fragment() }
            R.id.begin6->{ idWhenBegin = Begin6Fragment() }
            R.id.begin7->{ idWhenBegin = Begin7Fragment() }
            R.id.begin8->{ idWhenBegin = Begin8Fragment() }
            R.id.begin9->{ idWhenBegin = Begin9Fragment() }
            R.id.begin10->{ idWhenBegin = Begin10Fragment() }

        }
        if (idWhenBegin!=null) {
            val fragTran = requireActivity().supportFragmentManager.beginTransaction()
            fragTran.replace(R.id.frameL, idWhenBegin)
            fragTran.addToBackStack("BackToMain")
            fragTran.commit()
        }
    }
    override fun onResume() {
        super.onResume()
        sharedViewModel.setTitle("Begin Tasks")
        val actionBar: androidx.appcompat.app.ActionBar? = (activity as MainActivity?)!!.supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#7986CB")))
        val bottomNavigationView: BottomNavigationView? = (activity as MainActivity?)!!.findViewById(R.id.bottom_navigation)
        bottomNavigationView?.visibility = View.GONE

    }
}

