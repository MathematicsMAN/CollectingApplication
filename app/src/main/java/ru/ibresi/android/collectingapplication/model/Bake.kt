package ru.ibresi.android.collectingapplication.model

import ru.ibresi.android.collectingapplication.R
import java.util.*

data class Bake(
    val id: UUID = UUID.randomUUID(),
    var name: String = "",
    var unit: String = R.string.default_unit.toString(),
    var weigh: Double = 1.0,
    var price: Double = 1.0
)