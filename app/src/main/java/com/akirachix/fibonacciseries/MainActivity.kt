package com.akirachix.fibonacciseries

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fibonacciAdapter: FibonacciAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.fibonacci_recycler_view)
        fibonacciAdapter = FibonacciAdapter(generateFibonacciNumbers(100))
        recyclerView.adapter = fibonacciAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    private fun generateFibonacciNumbers(n: Int): List<Long> {
        val fibonacciNumbers = mutableListOf<Long>()
        var a = 0L
        var b = 1L
        for (i in 0 until n) {
            fibonacciNumbers.add(a)
            val c = a + b
            a = b
            b = c
        }
        return fibonacciNumbers
    }
}