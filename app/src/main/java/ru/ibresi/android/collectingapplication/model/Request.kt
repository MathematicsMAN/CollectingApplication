package ru.ibresi.android.collectingapplication.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(foreignKeys = [ForeignKey(
        entity = Shop::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("shop_id"),
        onDelete = ForeignKey.CASCADE),
    ForeignKey(
        entity = Bake::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("bake_id"),
        onDelete = ForeignKey.CASCADE)]
)
data class Request(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var shop_id: UUID,
    var bake_id: UUID,
    var date: Date = Date(),
    var count: Double = 0.0
)