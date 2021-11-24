package com.pseudoencom.fragment

import android.app.ActionBar
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import android.graphics.drawable.ColorDrawable
import android.view.*
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView


class IfFragment : Fragment(), View.OnClickListener{
    private lateinit var  button: Button
    private lateinit var sharedViewModel: SharedViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }

    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {
        requireActivity().window.statusBarColor = Color.parseColor("#2F6C31")
        val view: View = inflater.inflate(R.layout.fragment_if, container, false)

        button = view.findViewById(R.id.if1)
        view.findViewById<Button>(R.id.if1).setOnClickListener(this)

        button = view.findViewById(R.id.if2)
        view.findViewById<Button>(R.id.if2).setOnClickListener (this)

        button = view.findViewById(R.id.if3)
        view.findViewById<Button>(R.id.if3).setOnClickListener (this)

        button = view.findViewById(R.id.if4)
        view.findViewById<Button>(R.id.if4).setOnClickListener (this)

        button = view.findViewById(R.id.if5)
        view.findViewById<Button>(R.id.if5).setOnClickListener (this)

        button = view.findViewById(R.id.if6)
        view.findViewById<Button>(R.id.if6).setOnClickListener (this)

        button = view.findViewById(R.id.if7)
        view.findViewById<Button>(R.id.if7).setOnClickListener (this)

        button = view.findViewById(R.id.if8)
        view.findViewById<Button>(R.id.if8).setOnClickListener (this)

        button = view.findViewById(R.id.if9)
        view.findViewById<Button>(R.id.if9).setOnClickListener (this)

        button = view.findViewById(R.id.if10)
        view.findViewById<Button>(R.id.if10).setOnClickListener (this)
        return view
    }


    override fun onClick(v: View?) {
        var idWhenIf:Fragment? = null
        when (v!!.id){
        R.id.if1->{ idWhenIf = If1Fragment() }
        R.id.if2->{ idWhenIf = If2Fragment() }
        R.id.if3->{ idWhenIf = If3Fragment() }
        R.id.if4->{ idWhenIf = If4Fragment() }
        R.id.if5->{ idWhenIf = If5Fragment() }
        R.id.if6->{ idWhenIf = If6Fragment() }
        R.id.if7->{ idWhenIf = If7Fragment() }
        R.id.if8->{ idWhenIf = If8Fragment() }
        R.id.if9->{ idWhenIf = If9Fragment() }
        R.id.if10->{ idWhenIf = If10Fragment() }

    }
    if (idWhenIf!=null) {
        val fragTran = requireActivity().supportFragmentManager.beginTransaction()
        fragTran.replace(R.id.frameL, idWhenIf)
        fragTran.addToBackStack("BackToMain")
        fragTran.commit()
    }
    }override fun onResume() {
        super.onResume()
        sharedViewModel.setTitle("If Tasks")
        val actionBar: androidx.appcompat.app.ActionBar? = (activity as MainActivity?)!!.supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#4CAF50")))
        val bottomNavigationView: BottomNavigationView? = (activity as MainActivity?)!!.findViewById(R.id.bottom_navigation)
        bottomNavigationView?.visibility = View.GONE
    }

}
