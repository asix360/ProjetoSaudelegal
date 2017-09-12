package com.example.info.ndexemple.Model

import android.os.Parcel
import android.os.Parcelable

data class UnidadeModel (val unidadename:String,
                         val voto: Int,
                         val localizacao:String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(unidadename)
        parcel.writeInt(voto)
        parcel.writeString(localizacao)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UnidadeModel> {
        override fun createFromParcel(parcel: Parcel): UnidadeModel {
            return UnidadeModel(parcel)
        }

        override fun newArray(size: Int): Array<UnidadeModel?> {
            return arrayOfNulls(size)
        }
    }
}
