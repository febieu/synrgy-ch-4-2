package com.example.synrgychallenge4

import android.os.Parcel
import android.os.Parcelable

data class MusicKpop(
    val imageMusic : Int,
    val nameMusic: String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageMusic)
        parcel.writeString(nameMusic)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MusicKpop> {
        override fun createFromParcel(parcel: Parcel): MusicKpop {
            return MusicKpop(parcel)
        }

        override fun newArray(size: Int): Array<MusicKpop?> {
            return arrayOfNulls(size)
        }
    }

}
