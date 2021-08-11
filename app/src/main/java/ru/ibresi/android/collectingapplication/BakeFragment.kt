package ru.ibresi.android.collectingapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import ru.ibresi.android.collectingapplication.model.Bake


class BakeFragment : Fragment() {
    private lateinit var bake: Bake
    private lateinit var nameField: EditText
    private lateinit var unitField: EditText
    private lateinit var weighField: EditText
    private lateinit var priceField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bake = Bake()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bake, container, false)
        nameField = view.findViewById(R.id.bake_name) as EditText
        unitField = view.findViewById(R.id.bake_unit) as EditText
        weighField = view.findViewById(R.id.bake_weigh) as EditText
        priceField = view.findViewById(R.id.bake_price) as EditText
        return view
    }

    override fun onStart() {
        super.onStart()

        val nameWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                bake.name = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        nameField.addTextChangedListener(nameWatcher)

        val unitWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                bake.unit = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        unitField.addTextChangedListener(unitWatcher)

        val weighWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                bake.weigh = if (s.toString() == "") 0.0 else s.toString().toDouble()
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        weighField.addTextChangedListener(weighWatcher)

        val priceWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                bake.price = if (s.toString() == "") 0.0 else s.toString().toDouble()
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        priceField.addTextChangedListener(priceWatcher)
    }
}