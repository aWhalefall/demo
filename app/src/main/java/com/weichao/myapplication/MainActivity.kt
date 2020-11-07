package com.weichao.myapplication

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycle)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val list = mutableListOf<String>()
        for (i in 0 until 105) {
            list.add(i.toString())
        }
        recyclerView.adapter = Adapter(this, list)
    }

    class Adapter(
        context: MainActivity,
        list: MutableList<String>
    ) : RecyclerView.Adapter<Adapter.ViewHolder2>() {
        var list: List<String> = list
        val mContext = context

       class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
           val mView=itemView
           val textView=mView.findViewById<TextView>(android.R.id.text1)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder2 {
            val view = View.inflate(mContext, android.R.layout.activity_list_item, null)
            return ViewHolder2(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: Adapter.ViewHolder2, position: Int) {
            holder.textView.text=list[position]
        }


    }
}