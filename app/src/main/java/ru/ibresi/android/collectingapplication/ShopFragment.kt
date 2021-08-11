package ru.ibresi.android.collectingapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import ru.ibresi.android.collectingapplication.model.Shop

class ShopFragment : Fragment() {
    private lateinit var shop: Shop
    private lateinit var nameField: EditText
    private lateinit var addressField: EditText
    private lateinit var phoneField: EditText
    private lateinit var contactField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shop = Shop()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shop, container, false)
        nameField = view.findViewById(R.id.shop_name) as EditText
        addressField = view.findViewById(R.id.shop_address) as EditText
        phoneField = view.findViewById(R.id.shop_phone) as EditText
        contactField = view.findViewById(R.id.shop_contact) as EditText

        return view
    }

    override fun onStart() {
        super.onStart()

        val nameWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                shop.name = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        nameField.addTextChangedListener(nameWatcher)

        val addressWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                shop.address = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        addressField.addTextChangedListener(addressWatcher)

        val phoneWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                shop.phone = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        phoneField.addTextChangedListener(phoneWatcher)

        val contactWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                shop.contact = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        contactField.addTextChangedListener(contactWatcher)
    }
}