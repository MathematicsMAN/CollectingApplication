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
import ru.ibresi.android.collectingapplication.model.Bake
import ru.ibresi.android.collectingapplication.model.BakeListViewModel
import kotlin.math.pow
import kotlin.math.round

private const val TAG = "BakeListFragment"

class BakeListFragment : Fragment() {
    private lateinit var bakeRecyclerView: RecyclerView
    private var adapter: BakeAdapter? = null

    private val bakeListViewModel: BakeListViewModel by lazy {
        ViewModelProviders.of(this).get(BakeListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total bakes: ${bakeListViewModel.bakes.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bake_list, container, false)
        bakeRecyclerView = view.findViewById(R.id.bake_recycler_view) as RecyclerView
        bakeRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI() {
        val bakes = bakeListViewModel.bakes
        adapter = BakeAdapter(bakes)
        bakeRecyclerView.adapter = adapter
    }

    private inner class BakeHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var bake: Bake

        val nameTextView: TextView = itemView.findViewById(R.id.bake_name)
        val weighTextView: TextView = itemView.findViewById(R.id.bake_weigh)
        val unitTextView: TextView = itemView.findViewById(R.id.bake_unit)
        val priceTextView: TextView = itemView.findViewById(R.id.bake_price)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(bake: Bake) {
            this.bake = bake
            nameTextView.text = this.bake.name_b
            weighTextView.text = roundMe(this.bake.weight, 3).toString()
            unitTextView.text = this.bake.unit_id
            priceTextView.text = roundMe(this.bake.price).toString() + " руб."
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "${bake.name_b} была выбрана", Toast.LENGTH_LONG).show()
        }
    }

    private inner class BakeAdapter(var bakes: List<Bake>) : RecyclerView.Adapter<BakeHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BakeHolder {
            val view = layoutInflater.inflate(R.layout.list_item_bake, parent, false)
            return BakeHolder(view)
        }

        override fun onBindViewHolder(holder: BakeHolder, position: Int) {
            val bake = bakes[position]
            holder.bind(bake)
        }

        override fun getItemCount() = bakes.size

    }

    private fun roundMe(x: Double, m: Int = 2): Double {
       return round(x * 10.0.pow(m)) / 10.0.pow(m)
    }

    companion object {
        fun newInstance(): BakeListFragment {
            return BakeListFragment()
        }
    }
}