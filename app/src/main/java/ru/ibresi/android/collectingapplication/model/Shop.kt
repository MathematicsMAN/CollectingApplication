package ru.ibresi.android.collectingapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Shop(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var name_s: String = "",
    var address: String = "",
    var phone: String = "",
    var contact: String = ""
)