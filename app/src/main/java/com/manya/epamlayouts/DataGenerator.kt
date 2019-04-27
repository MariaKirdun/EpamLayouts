package com.manya.epamlayouts

/**
 *
 *  Singleton for generating flight information.
 *
 *  @author Maria Kirdun
 */

object DataGenerator {
    fun generateDepartData() = Flight(
        "16 SEP 2019",
        3,
        435,
        "MSQ",
        "FLO",
        "00:20",
        "09:20",
        "9:00"
    )

    fun generateReturnData() = Flight(
        "17 SEP 2019",
        5,
        488,
        "FLO",
        "MSQ",
        "05:10",
        "09:20",
        "4:10"
    )
}