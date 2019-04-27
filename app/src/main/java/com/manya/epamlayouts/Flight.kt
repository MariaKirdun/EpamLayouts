package com.manya.epamlayouts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * Simple data class for flight information
 * with parcelable implementation.
 *
 * @author Maria Kirdun
 */

@Parcelize
data class Flight (
    val date : String,
    val freeSeats : Int,
    val price : Int,
    val takeOffCity: String,
    val landCity : String,
    val takeOffTime: String,
    val landTime : String,
    val duration : String
) : Parcelable