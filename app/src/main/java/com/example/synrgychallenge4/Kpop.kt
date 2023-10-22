package com.example.synrgychallenge4

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize

@VersionedParcelize
data class Kpop(
    val image: Int,
    val name: String?,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    operator fun get(position: Int): Any {
        return position
    }

    companion object CREATOR : Parcelable.Creator<Kpop> {
        override fun createFromParcel(parcel: Parcel): Kpop {
            return Kpop(parcel)
        }

        override fun newArray(size: Int): Array<Kpop?> {
            return arrayOfNulls(size)
        }
    }
}
