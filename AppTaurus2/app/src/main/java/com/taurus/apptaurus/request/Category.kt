package com.taurus.apptaurus.request

data class Category(
    val id: Int,
    val description: String
){
    override fun toString(): String {
        return description
    }
}
