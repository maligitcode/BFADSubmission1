package com.ali.submission1
import android.os.Parcelable
import  kotlinx.android.parcel.Parcelize

@Parcelize
data class userdata(
    var Username: String,
    var Name: String,
    var Avatar: Int,
    var Company: String,
    var Location: String,
    var Repository: String,
    var Follower: String,
    var Following: String
):Parcelable