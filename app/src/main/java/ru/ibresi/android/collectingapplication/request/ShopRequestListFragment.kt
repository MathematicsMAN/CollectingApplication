package ru.ibresi.android.collectingapplication.request

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

class ShopRequestListFragment : Fragment() {
    private lateinit var shopRequestRecyclerView: RecyclerView
    private var adapter: ShopRequestAdapter? = null

    private val shopRequestListViewModel: ShopListViewModel by lazy {
        ViewModelProviders.of(this).get(ShopListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total shops: ${shopRequestListViewModel.shops.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shop_list_request, container, false)
        shopRequestRecyclerView = view.findViewById(R.id.shop_request_recycler_view) as RecyclerView
        shopRequestRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI() {
        val shops = shopRequestListViewModel.shops
        adapter = ShopRequestAdapter(shops)
        shopRequestRecyclerView.adapter = adapter
    }

    private inner class ShopRequestHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var shop: Shop

        val nameTextView: TextView = itemView.findViewById(R.id.shop_name)
        val addressTextView: TextView = itemView.findViewById(R.id.shop_address)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(shop: Shop) {
            this.shop = shop
            nameTextView.text = this.shop.name
            addressTextView.text = this.shop.address
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "${shop.name} был выбран", Toast.LENGTH_LONG).show()
        }
    }

    private inner class ShopRequestAdapter(var shops: List<Shop>) : RecyclerView.Adapter<ShopRequestHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopRequestHolder {
            val view = layoutInflater.inflate(R.layout.list_item_shop_request, parent, false)
            return ShopRequestHolder(view)
        }

        override fun onBindViewHolder(holder: ShopRequestHolder, position: Int) {
            val shop = shops[position]
            holder.bind(shop)
        }

        override fun getItemCount() = shops.size

    }

    companion object {
        fun newInstance(): ShopRequestListFragment {
            return ShopRequestListFragment()
        }
    }
}