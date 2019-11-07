package com.bluapp.kotlinview.recyclerView

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.bluapp.kotlinview.R
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.TextView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View


class RecyclerViewActivity10 : AppCompatActivity() {
    private var list: RecyclerView? = null
    private var recyclerAdapter: adapter? = null
    private var country: ArrayList<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view10)
        list = findViewById(R.id.list) as RecyclerView
        country = arrayListOf<String>()
        country!!.add("Nigeria")
        country!!.add("China")
        country!!.add("USA")
        country!!.add("Ghana")
        country!!.add("Canada")
        country!!.add("Finland")

        val layoutManager = LinearLayoutManager(this)
        list!!.setLayoutManager(layoutManager)
        recyclerAdapter = adapter(this@RecyclerViewActivity10, country!!)
        list!!.addItemDecoration(DividerItemDecoration(list!!.getContext(), layoutManager.orientation))
        list!!.setAdapter(recyclerAdapter)

    }

    private inner class adapter(internal var context: Context, internal var mData: List<String>) :
        RecyclerView.Adapter<adapter.myViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter.myViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter1, parent, false)
            return myViewHolder(view)
        }
        override fun onBindViewHolder(holder: adapter.myViewHolder, position: Int) {
            holder.country.text = mData[position]
        }
        override fun getItemCount(): Int {
            return mData.size
        }
        inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            internal var country: TextView
            init {
                country = itemView.findViewById(R.id.country)
            }
        }
    }

    fun update(view: View) {
        country!!.add("Denmark")
        country!!.add("Argentina")
        country!!.add("Andorra")
        country!!.add("Togo")
        recyclerAdapter!!.notifyDataSetChanged()
    }

}
