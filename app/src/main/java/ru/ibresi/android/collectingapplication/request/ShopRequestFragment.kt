package ru.ibresi.android.collectingapplication.request

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.ibresi.android.collectingapplication.R
import ru.ibresi.android.collectingapplication.model.Bake
import ru.ibresi.android.collectingapplication.model.Shop

class ShopRequestFragment : Fragment() {
    private lateinit var shop: Shop
    private lateinit var nameField: TextView
    private lateinit var addressField: TextView
    private lateinit var countField: TextView
    private lateinit var weightField: TextView
    private lateinit var requestBakes: MutableList<Bake>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shop = Shop()
//        requestBakes = shop.request
//        TODO Массив requestBakes получить из запроса в БД таблицы Request
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_item_shop_request, container, false)
        nameField = view.findViewById(R.id.shop_name) as TextView
        addressField = view.findViewById(R.id.shop_address) as TextView
        countField = view.findViewById(R.id.count_positions) as TextView
        weightField = view.findViewById(R.id.total_weight) as TextView

        return view
    }

    override fun onStart() {
        super.onStart()

        val countWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                countField = countPositions()
//                weightField.text = totalWeight().toString()
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        countField.addTextChangedListener(countWatcher)

    }

    private fun countPositions(): Int {
        var count = 0
//        for (bake in requestBakes) {
//            if (bake.count > 0.001) count++
//        }
//        TODO count считать из запроса в БД
        return count
    }

    private fun totalWeight(): Double {
        var weight = 0.0
//        for (bake in requestBakes) {
//            weight += bake.weight * bake.count
//        }
//        TODO weight считать из запроса в БД
        return weight
    }
}