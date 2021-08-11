package ru.ibresi.android.collectingapplication.model

import java.util.*

data class Shop(
    val id: UUID = UUID.randomUUID(),
    var name: String = "",
    var address: String = "",
    var phone: String = "",
    var contact: String = ""
)