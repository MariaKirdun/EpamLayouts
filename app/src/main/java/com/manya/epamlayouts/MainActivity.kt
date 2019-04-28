package com.manya.epamlayouts

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Button

/**
 *
 * Activity with [Fragment] and two [Button]s. [Button] fragment1 show [ConstraintFragment], and [Button] fragment2 show [NonConstraintFragment].
 *
 * @author Maria Kirdun
 */

class MainActivity : AppCompatActivity() {


    private val departData: Flight by lazy { DataGenerator.generateDepartData() }
    private val returnData: Flight by lazy { DataGenerator.generateReturnData() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frameContainer, ConstraintFragment.newInstance(departData,returnData))
                .commit()
        }

        val fragment1Button = findViewById<Button>(R.id.fragment1Button)
        fragment1Button.setOnClickListener {
            replaceFragment(ConstraintFragment.newInstance(departData,returnData))
        }
        val fragment2Button = findViewById<Button>(R.id.fragment2Button)
        fragment2Button.setOnClickListener {
            replaceFragment(NonConstraintFragment.newInstance(departData,returnData))
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}
