package com.example.artsupply

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_art_detail.*

class ArtDetail : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art_detail)

        val actionBar = supportActionBar

        actionBar!!.title = "Detail Supply"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val listArt : ArtData? = intent.getParcelableExtra(EXTRA_DATA)
        detail_avatar.setImageResource(listArt?.avatar!!)
        detail_name.text = listArt?.name
        detail_brand.text =getString(R.string.brand, listArt?.brand)
        detail_price.text = getString(R.string.price, listArt?.price)
        detail_packet.text = getString(R.string.packet, listArt?.packet)

    }

}
