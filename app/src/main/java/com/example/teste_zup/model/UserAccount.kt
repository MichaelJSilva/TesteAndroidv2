package com.example.teste_zup.model

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.Deferred


data class UserAccount (
    @Json(name = "userId")  val userId: Int,
    @Json(name = "name")  val name: String?,
    @Json(name = "bankAccount")  val bankAccount: String?,
    @Json(name = "agency")  val agency: String?,
    @Json(name = "balance")  val balance: Double
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(userId)
        parcel.writeString(name)
        parcel.writeString(bankAccount)
        parcel.writeString(agency)
        parcel.writeDouble(balance)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserAccount> {
        override fun createFromParcel(parcel: Parcel): UserAccount {
            return UserAccount(parcel)
        }

        override fun newArray(size: Int): Array<UserAccount?> {
            return arrayOfNulls(size)
        }
    }


}