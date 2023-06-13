package com.taurus.apptaurus

import com.taurus.apptaurus.response.ResponseGanho
import com.taurus.apptaurus.response.ResponseGasto

class CombinedData(private val gasto: ResponseGasto?, private val ganho: ResponseGanho?) {

    fun getGasto(): ResponseGasto? {
        return gasto
    }

    fun getGanho(): ResponseGanho? {
        return ganho
    }

    fun getData(): Any? {
        return gasto?.created_at ?: ganho?.created_at
    }
}
