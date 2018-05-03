package br.com.urbbox.cepespapp.screens.details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import br.com.urbbox.cepespapp.R
import br.com.urbbox.cepespapp.data.Candidate
import kotlinx.android.synthetic.main.activity_candidate_details.*

class CandidateDetailsActivity : AppCompatActivity(), ICandidateDetailsView {

    private lateinit var presenter: CandidateDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_details)

        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        val candidate = intent.getParcelableExtra<Candidate>("candidate")

        candidateDetailsRecyclerView.layoutManager = LinearLayoutManager(this)

        presenter = CandidateDetailsPresenter(this)
        presenter.fill(candidate)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun setTitle(electionYear: String) {
        title = electionYear
    }

    override fun setBallotName(ballotName: String) {
        ballotNameTextView.text = ballotName
    }

    override fun setTotalVotes(totalVotes: String?) {
        if (totalVotes != null)
            totalVotesTextView.text = getString(R.string.votes, totalVotes.toInt())
        else
            totalVotesTextView.visibility = GONE
    }

    override fun setExtraInfo(info: List<Pair<String, String?>>) {
        candidateDetailsRecyclerView.adapter = DetailsAdapter(this, info)
    }
}
