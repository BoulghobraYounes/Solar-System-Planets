package com.example.solarsystem

import android.os.Parcel
import android.os.Parcelable

data class PlanetModel (
    val name: String?,
    val image: Int,
    val description: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(image)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlanetModel> {
        override fun createFromParcel(parcel: Parcel): PlanetModel {
            return PlanetModel(parcel)
        }

        override fun newArray(size: Int): Array<PlanetModel?> {
            return arrayOfNulls(size)
        }
    }
}