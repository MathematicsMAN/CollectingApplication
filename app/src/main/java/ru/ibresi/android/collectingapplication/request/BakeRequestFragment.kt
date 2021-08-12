package ru.ibresi.android.collectingapplication.request

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.ibresi.android.collectingapplication.R
import ru.ibresi.android.collectingapplication.model.Bake


class BakeRequestFragment : Fragment() {
    private lateinit var bake: Bake
    private lateinit var nameField: TextView
    private lateinit var unitField: TextView
    private lateinit var weighField: TextView
    private lateinit var priceField: TextView
    private lateinit var countField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bake = Bake()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_item_bake_request, container, false)
        nameField = view.findViewById(R.id.bake_name) as TextView
        unitField = view.findViewById(R.id.bake_unit) as TextView
        weighField = view.findViewById(R.id.bake_weigh) as TextView
        priceField = view.findViewById(R.id.bake_price) as TextView
        countField = view.findViewById(R.id.bake_count) as EditText
        return view
    }

    override fun onStart() {
        super.onStart()

        val countWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                bake.count = s.toString().toDouble()
//                TODO добавить учёт изменения количества bake в BakeRequestListFragment
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        countField.addTextChangedListener(countWatcher)

    }
}