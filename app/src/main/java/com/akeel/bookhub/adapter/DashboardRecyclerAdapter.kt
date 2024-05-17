package com.akeel.bookhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.akeel.bookhub.R
import com.akeel.bookhub.model.Book

class DashboardRecyclerAdapter(val context: Context, private val itemList: ArrayList<Book>) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textBookName: TextView = view.findViewById(R.id.txtBookName)
        val textBookAuthor: TextView = view.findViewById(R.id.txtBookAuthor)
        val textBookCost: TextView = view.findViewById(R.id.txtBookPrice)
        val textBookRating: TextView = view.findViewById(R.id.txtBookRating)
        val textBookImage: ImageView = view.findViewById(R.id.imgBookImage)
        val bookDetail: LinearLayout = view.findViewById(R.id.book_detail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_dashboard_single_view, parent, false)

        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {

        val book = itemList[position]
        holder.textBookName.text = book.bookName
        holder.textBookAuthor.text = book.bookAuthor
        holder.textBookCost.text = book.bookCost
        holder.textBookRating.text = book.bookRating
        holder.textBookImage.setImageResource(book.bookImage)
        holder.bookDetail.setOnClickListener{
            Toast.makeText(context,"Clicked on ${holder.textBookName.text}",Toast.LENGTH_SHORT).show()}
    }
}