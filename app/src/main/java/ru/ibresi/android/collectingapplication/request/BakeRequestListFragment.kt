package ru.ibresi.android.collectingapplication.request

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
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

private const val TAG = "BakeRequestListFragment"

class BakeRequestListFragment : Fragment() {
    private lateinit var bakeRequestRecyclerView: RecyclerView
    private var adapter: BakeRequestAdapter? = null

    private val bakeRequestListViewModel: BakeListViewModel by lazy {
        ViewModelProviders.of(this).get(BakeListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total bakes in request: ${bakeRequestListViewModel.bakes.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bake_list_request, container, false)
        bakeRequestRecyclerView = view.findViewById(R.id.bake_request_recycler_view) as RecyclerView
        bakeRequestRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI() {
        val bakes = bakeRequestListViewModel.bakes
        adapter = BakeRequestAdapter(bakes)
        bakeRequestRecyclerView.adapter = adapter
    }

    private inner class BakeRequestHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var bake: Bake

        val nameTextView: TextView = itemView.findViewById(R.id.bake_name)
        val weighTextView: TextView = itemView.findViewById(R.id.bake_weigh)
        val unitTextView: TextView = itemView.findViewById(R.id.bake_unit)
        val priceTextView: TextView = itemView.findViewById(R.id.bake_price)
        val countEditText: EditText = itemView.findViewById(R.id.bake_count)
        val plusButton: ImageView = itemView.findViewById(R.id.plus_button)
        val minusButton: ImageView = itemView.findViewById(R.id.minus_button)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(bake: Bake) {
            this.bake = bake
            nameTextView.text = this.bake.name_b
            weighTextView.text = roundMe(this.bake.weight, 3).toString()
            unitTextView.text = this.bake.unit_id
            priceTextView.text = roundMe(this.bake.price).toString() + " руб."
//            countEditText.setText(this.bake.count.toString())
//            TODO Передавать значния в Request.count
            plusButton.setOnClickListener {
                Toast.makeText(context, "Нажат плюс", Toast.LENGTH_LONG).show()
            }
            minusButton.setOnClickListener {
                Toast.makeText(context, "Нажат минус", Toast.LENGTH_LONG).show()
            }
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "${bake.name_b} была выбрана", Toast.LENGTH_LONG).show()
        }
    }

    private inner class BakeRequestAdapter(var bakes: List<Bake>) : RecyclerView.Adapter<BakeRequestHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BakeRequestHolder {
            val view = layoutInflater.inflate(R.layout.list_item_bake_request, parent, false)
            return BakeRequestHolder(view)
        }

        override fun onBindViewHolder(holder: BakeRequestHolder, position: Int) {
            val bake = bakes[position]
            holder.bind(bake)
        }

        override fun getItemCount() = bakes.size
    }

    private fun roundMe(x: Double, m: Int = 2): Double {
       return round(x * 10.0.pow(m)) / 10.0.pow(m)
    }

    companion object {
        fun newInstance(): BakeRequestListFragment {
            return BakeRequestListFragment()
        }
    }
}