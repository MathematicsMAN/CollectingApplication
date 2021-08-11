package ru.ibresi.android.collectingapplication.model

import androidx.lifecycle.ViewModel

class ShopListViewModel : ViewModel() {
    val shops = mutableListOf<Shop>()

    init {
        for (i in 0 until 100) {
            val shop = Shop()
            shop.name = "Магазин номер $i"
            shop.address = if (i % 2 == 0) "п.Ибреси, ул. Энгельса, д. ${i + 1}"
                                      else "п.Буинск, ул. Ленина, д. ${i + 2}"
            shop.phone = if (i % 3 == 0) "+7(999)999-99-99" else "+7(888)888-88-88"
            shop.contact = when { i % 3 == 0 -> "Петров"
                                  i % 3 == 1 -> "Козлов"
                                  else -> "Баранов"
                            }
            shops += shop
        }
    }
}