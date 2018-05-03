package br.com.urbbox.cepespapp.screens.elections

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import br.com.urbbox.cepespapp.R
import br.com.urbbox.cepespapp.data.Candidate
import br.com.urbbox.cepespapp.data.DimCandidate
import kotlinx.android.synthetic.main.activity_elections.*

class ElectionsActivity : AppCompatActivity(), IElectionsView {

    private lateinit var presenter: ElectionsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elections)

        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        electionsRecyclerView.layoutManager = LinearLayoutManager(this)

        presenter = ElectionsPresenter(this)
        presenter.loadElections(intent.getParcelableExtra("candidate"))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun setTitle(name: String) {
        title = name
    }

    override fun showElections(candidates: List<Candidate>) {
        electionsRecyclerView.adapter = ElectionsAdapter(this, candidates)
    }

    override fun showProgressBar() {
        progressBar2.visibility = View.VISIBLE
        electionsRecyclerView.visibility = View.GONE
    }

    override fun hideProgressBar() {
        progressBar2.visibility = View.GONE
        electionsRecyclerView.visibility = View.VISIBLE
    }
}
