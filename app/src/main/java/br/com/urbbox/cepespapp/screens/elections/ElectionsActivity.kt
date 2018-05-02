package br.com.urbbox.cepespapp.screens.elections

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.urbbox.cepespapp.R
import br.com.urbbox.cepespapp.data.Candidate
import br.com.urbbox.cepespapp.data.DimCandidate
import kotlinx.android.synthetic.main.activity_elections.*

class ElectionsActivity : AppCompatActivity(), IElectionsView {

    private lateinit var presenter: ElectionsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elections)

        val candidate = intent.getParcelableExtra<DimCandidate>("candidate")

        electionsRecyclerView.layoutManager = LinearLayoutManager(this)

        title = candidate.name
        presenter = ElectionsPresenter(this)
        presenter.loadElections(candidate)
    }

    override fun showElections(candidates: List<Candidate>) {
        electionsRecyclerView.adapter = ElectionsAdapter(this, candidates)
    }
}
