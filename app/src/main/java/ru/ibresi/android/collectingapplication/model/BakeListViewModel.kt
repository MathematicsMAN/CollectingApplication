package ru.ibresi.android.collectingapplication.model

import androidx.lifecycle.ViewModel
import ru.ibresi.android.collectingapplication.BakeRepository

class BakeListViewModel : ViewModel() {
  /*  val bakes = mutableListOf<Bake>()

    init {
        for (i in 0 until 100) {
            val bake = Bake()
            bake.name_b = "Выпечка номер $i"
            bake.unit_id = if (i % 3 == 0) "кг/шт." else "кг"
            bake.weight = if (i % 3 == 0) i * 0.352 % 2 else 1.0
            bake.price = if (i % 2 == 0) (i + 10.0) % 40 else (i * 0.72 + 10.0) % 30
            bakes += bake
        }
    }  */
    private val bakeRepository = BakeRepository.get()
    val units = bakeRepository.getUnits()
    val bakes = bakeRepository.getBakes()
}