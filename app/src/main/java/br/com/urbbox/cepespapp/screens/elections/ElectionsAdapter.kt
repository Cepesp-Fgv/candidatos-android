package br.com.urbbox.cepespapp.screens.elections

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.urbbox.cepespapp.R
import br.com.urbbox.cepespapp.data.Candidate
import br.com.urbbox.cepespapp.screens.details.CandidateDetailsActivity
import kotlinx.android.synthetic.main.elections_list_item.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class ElectionsAdapter(private val context: Context, private val candidates: List<Candidate>)
    : RecyclerView.Adapter<ElectionsAdapter.ViewHolder>() {

    override fun getItemCount() = candidates.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.elections_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val candidate = candidates[position]

        holder.ballotName?.text = candidate.ballotName
        holder.electionTotal?.text = candidate.totalVotes
        holder.jobDescription?.text = candidate.jobDesc
        holder.turnDescription?.text = context.getString(R.string.turn, candidate.turn.toInt())
        holder.electionYear?.text = candidate.electionYear

        if (candidate.totalVotes != null)
            holder.electionTotal?.text = context.getString(R.string.votes, candidate.totalVotes.toInt())

        holder.itemView.onClick {
            showDetailsActivity(candidate)
        }
    }

    private fun showDetailsActivity(candidate: Candidate) {
        context.startActivity<CandidateDetailsActivity>("candidate" to candidate)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ballotName: TextView? = itemView.ballotNameTextView
        val electionTotal: TextView? = itemView.electionTotalTextView
        val jobDescription: TextView? = itemView.jobDescriptionTextView
        val turnDescription: TextView? = itemView.turnDescriptionTextView
        val electionYear: TextView? = itemView.electionYearTextView
    }
}
