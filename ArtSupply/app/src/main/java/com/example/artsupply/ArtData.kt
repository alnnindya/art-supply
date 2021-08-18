package com.example.artsupply

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArtData(
    var avatar : Int? = null,
    var name: String? = null,
    var brand : String? = null,
    var price: String? = null,
    var packet: String? = null,

    ):Parcelable
