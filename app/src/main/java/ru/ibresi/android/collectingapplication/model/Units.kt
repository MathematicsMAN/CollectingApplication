package ru.ibresi.android.collectingapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Units(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = ""
)