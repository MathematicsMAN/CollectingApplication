package ru.ibresi.android.collectingapplication.catalog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.ibresi.android.collectingapplication.R
import ru.ibresi.android.collectingapplication.model.Shop
import ru.ibresi.android.collectingapplication.model.ShopListViewModel

private const val TAG = "ShopListFragment"

class ShopListFragment : Fragment() {
    private lateinit var shopRecyclerView: RecyclerView
    private var adapter: ShopAdapter? = null

    private val shopListViewModel: ShopListViewModel by lazy {
        ViewModelProviders.of(this).get(ShopListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total shops: ${shopListViewModel.shops.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shop_list, container, false)
        shopRecyclerView = view.findViewById(R.id.shop_recycler_view) as RecyclerView
        shopRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI() {
        val shops = shopListViewModel.shops
        adapter = ShopAdapter(shops)
        shopRecyclerView.adapter = adapter
    }

    private inner class ShopHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var shop: Shop

        val nameTextView: TextView = itemView.findViewById(R.id.shop_name)
        val addressTextView: TextView = itemView.findViewById(R.id.shop_address)
        val phoneTextView: TextView = itemView.findViewById(R.id.shop_phone)
        val contactTextView: TextView = itemView.findViewById(R.id.shop_contact)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(shop: Shop) {
            this.shop = shop
            nameTextView.text = this.shop.name
            addressTextView.text = this.shop.address
            phoneTextView.text = this.shop.phone
            contactTextView.text = this.shop.contact
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "${shop.name} был выбран", Toast.LENGTH_LONG).show()
        }
    }

    private inner class ShopAdapter(var shops: List<Shop>) : RecyclerView.Adapter<ShopHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopHolder {
            val view = layoutInflater.inflate(R.layout.list_item_shop, parent, false)
            return ShopHolder(view)
        }

        override fun onBindViewHolder(holder: ShopHolder, position: Int) {
            val shop = shops[position]
            holder.bind(shop)
        }

        override fun getItemCount() = shops.size

    }

    companion object {
        fun newInstance(): ShopListFragment {
            return ShopListFragment()
        }
    }
}