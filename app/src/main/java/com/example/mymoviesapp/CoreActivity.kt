package com.example.mymoviesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

abstract class CoreActivity : AppCompatActivity() {
    fun toDetailsAct(id:Int){
        val i = Intent(this, DetailsActivity::class.java)
        i.putExtra(DetailsActivity.EXTRA_ID, id)
        startActivity(i)
    }
}