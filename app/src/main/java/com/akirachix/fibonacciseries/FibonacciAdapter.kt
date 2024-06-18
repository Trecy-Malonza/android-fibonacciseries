package com.akirachix.fibonacciseries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    class FibonacciAdapter(private val fibonacciNumbers: List<Long>) :
        RecyclerView.Adapter<FibonacciViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FibonacciViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fibonacci_item_layout, parent, false)
            return FibonacciViewHolder(view)
        }

        override fun onBindViewHolder(holder: FibonacciViewHolder, position: Int) {
            holder.fibonacciNumber.text = fibonacciNumbers.get(position).toString()
        }

        override fun getItemCount(): Int {
            return fibonacciNumbers.size
        }
    }
    class FibonacciViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var fibonacciNumber = itemView.findViewById<TextView>(R.id.fibonacci_number)
    }

