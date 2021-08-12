package ru.ibresi.android.collectingapplication.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import ru.ibresi.android.collectingapplication.R
import java.util.*

@Entity(foreignKeys = [ForeignKey(
    entity = Units::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("unit_id"),
    onDelete = ForeignKey.CASCADE)]
)
data class Bake(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var name_b: String = "",
    var unit_id: String = R.string.default_unit.toString(),
    var weight: Double = 1.0,
    var price: Double = 1.0,
)