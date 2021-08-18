package com.example.artsupply

import android.content.Intent
import android.content.res.TypedArray
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var adapter: ArtAdapter
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataName: Array<String>
    private lateinit var dataPrice: Array<String>
    private lateinit var dataBrand: Array<String>
    private lateinit var dataPacket: Array<String>
    private lateinit var arts: ArrayList<ArtData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAboutActivity: Button = findViewById(R.id.btn_about_activity)
        btnAboutActivity.setOnClickListener(this)

        prepare()

        adapter = ArtAdapter(this, addItem())
        lv_list.adapter = adapter

        lv_list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val listDataArt = ArtData(0, "", "", "", "")
            listDataArt.avatar = dataAvatar.getResourceId(position, position)
            listDataArt.name = dataName[position]
            listDataArt.price = dataPrice[position]
            listDataArt.brand = dataBrand[position]
            listDataArt.packet = dataPacket[position]

            val intent = Intent(this@MainActivity, ArtDetail::class.java)
            intent.putExtra(ArtDetail.EXTRA_DATA, listDataArt)

            this@MainActivity.startActivity(intent)
            Toast.makeText(this@MainActivity, arts[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataName = resources.getStringArray(R.array.name)
        dataPrice = resources.getStringArray(R.array.price)
        dataBrand = resources.getStringArray(R.array.brand)
        dataPacket = resources.getStringArray(R.array.packet)

    }

    private fun addItem(): ArrayList<ArtData> {
        arts = ArrayList()
        for (i in dataName.indices) {
            val art = ArtData()
            art.avatar = dataAvatar.getResourceId(i, -1)
            art.name = dataName[i]
            art.brand = dataBrand[i]
            art.price = dataPrice[i]
            arts.add(art)
        }
        return arts
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_about_activity -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
