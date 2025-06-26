package com.example.shoppingapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import android.view.MenuItem

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        //for going back to main activity screen
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Product Details"

        val imageView = findViewById<ImageView>(R.id.detailImage)
        val titleView = findViewById<TextView>(R.id.detailTitle)
        val priceView = findViewById<TextView>(R.id.detailPrice)
        val ratingView = findViewById<TextView>(R.id.detailRating)

        // Get data from intent
        val title = intent.getStringExtra("title")
        val price = intent.getDoubleExtra("price", 0.0)
        val rating = intent.getDoubleExtra("rating", 0.0)
        val imageUrl = intent.getStringExtra("thumbnail")

        // Set to views
        titleView.text = title
        priceView.text = " Price :₹ $price"
        ratingView.text = "Rating: $rating ★"
        Picasso.get().load(imageUrl).into(imageView)
    }
    //  Handle back arrow click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Closes this activity and goes back
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
