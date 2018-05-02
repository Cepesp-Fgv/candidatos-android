package br.com.urbbox.cepespapp.screens.search

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.urbbox.cepespapp.R
import br.com.urbbox.cepespapp.data.DimCandidate
import br.com.urbbox.cepespapp.screens.elections.ElectionsActivity
import kotlinx.android.synthetic.main.search_list_item.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class SearchAdapter(private val context: Context, private val candidates: List<DimCandidate>)
    : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun getItemCount() = candidates.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.search_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name?.text = candidates[position].name
        holder.electoralID?.text = candidates[position].electoralID
        holder.itemView.onClick {
            openElectionsActivity(position)
        }
    }

    private fun openElectionsActivity(position: Int) {
        context.startActivity<ElectionsActivity>("candidate" to candidates[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView? = itemView.candidateNameTextView
        val electoralID: TextView? = itemView.electoralIDTextView
    }
}