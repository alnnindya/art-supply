package com.example.artsupply

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

class ArtAdapter(private val context: Context, private val listArt : ArrayList<ArtData>) : BaseAdapter() {

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if(itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.art_item, null, true)
        }
        val viewHolder = ViewHolder(itemView as View)
        val art = getItem(position) as ArtData
        viewHolder.bind(art)
        return itemView
    }


    override fun getItem(i: Int): Any {
        return listArt[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return listArt.size
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val imgAvatar: CircleImageView = view.findViewById(R.id.img_avatar)
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtPrice: TextView = view.findViewById(R.id.txt_price)
        private val txtBrand: TextView = view.findViewById(R.id.txt_brand)

        internal fun bind(art: ArtData) {
            art.avatar?.let { imgAvatar.setImageResource(it) }
            txtName.text = art.name
            txtPrice.text = art.price
            txtBrand.text = art.brand
        }
    }

}

