package ru.ibresi.android.collectingapplication.model

import androidx.lifecycle.ViewModel

class BakeListViewModel : ViewModel() {
    val bakes = mutableListOf<Bake>()

    init {
        for (i in 0 until 100) {
            val bake = Bake()
            bake.name = "Выпечка номер $i"
            bake.unit = if (i % 3 == 0) "кг/шт." else "кг"
            bake.weigh = if (i % 3 == 0) i * 0.352 % 2 else 1.0
            bake.price = if (i % 2 == 0) (i + 10.0) % 40 else (i * 0.72 + 10.0) % 30
            bakes += bake
        }
    }
}