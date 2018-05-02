package br.com.urbbox.cepespapp.screens.details

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.urbbox.cepespapp.R
import kotlinx.android.synthetic.main.details_list_item.view.*

class DetailsAdapter(private val context: Context, private val data: List<Pair<String, String?>>)
    : RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.details_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pair = data[position]
        holder.columnName?.text = pair.first
        holder.columnValue?.text = pair.second
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val columnName: TextView? = view.detailItemColumnName
        val columnValue: TextView? = view.detailItemColumnValue
    }

}
