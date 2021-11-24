package com.pseudoencom.fragment

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment(), View.OnClickListener{
    lateinit var  button: Button
    lateinit var imageButton: ImageButton
    lateinit var sharedViewModel: SharedViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }

    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {
        requireActivity().window.statusBarColor = Color.parseColor("#FF000000")
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)

        button = view.findViewById(R.id.BeginButton)
        view.findViewById<Button>(R.id.BeginButton).setOnClickListener(this)

        button = view.findViewById(R.id.IntegerButton)
        view.findViewById<Button>(R.id.IntegerButton).setOnClickListener (this)

        button = view.findViewById(R.id.BooleanButton)
        view.findViewById<Button>(R.id.BooleanButton).setOnClickListener (this)

        button = view.findViewById(R.id.IfButton)
        view.findViewById<Button>(R.id.IfButton).setOnClickListener (this)

        button = view.findViewById(R.id.CaseButton)
        view.findViewById<Button>(R.id.CaseButton).setOnClickListener (this)

        button = view.findViewById(R.id.ForButton)
        view.findViewById<Button>(R.id.ForButton).setOnClickListener (this)

        imageButton = view.findViewById(R.id.telegram)
        view.findViewById<ImageButton>(R.id.telegram).setOnClickListener{
                val url = "tg://resolve?domain=cj3dreams"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
        return view
    }


    override fun onClick(v: View?) {
        var idWhen:Fragment? = null
        when (v!!.id){
            R.id.BeginButton->{ idWhen = BeginFragment() }
            R.id.IntegerButton->{ idWhen = IntegerFragment() }
            R.id.BooleanButton->{ idWhen = BooleanFragment() }
            R.id.IfButton->{ idWhen = IfFragment() }
            R.id.CaseButton->{ idWhen = CaseFragment() }
            R.id.ForButton->{idWhen = ForFragment()}

        }
        if (idWhen!=null) {
            val fragTranz = requireActivity().supportFragmentManager.beginTransaction()
            fragTranz.replace(R.id.frameL, idWhen)
            fragTranz.addToBackStack("Back")
            fragTranz.commit()
        }
    }
    override fun onResume() {
        super.onResume()
        sharedViewModel.setTitle("My Tasks Improved")
        val actionBar: androidx.appcompat.app.ActionBar? = (activity as MainActivity?)!!.supportActionBar
        actionBar?.setHomeButtonEnabled(false)
        actionBar?.setDisplayHomeAsUpEnabled(false)
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#141414")))
        val bottomNavigationView: BottomNavigationView? = (activity as MainActivity?)!!.findViewById(R.id.bottom_navigation)
        bottomNavigationView?.visibility = View.VISIBLE

    }

}