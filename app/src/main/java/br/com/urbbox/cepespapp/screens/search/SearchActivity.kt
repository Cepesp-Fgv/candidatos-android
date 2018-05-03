package br.com.urbbox.cepespapp.screens.search

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import android.view.inputmethod.InputMethodManager
import br.com.urbbox.cepespapp.R
import br.com.urbbox.cepespapp.data.DimCandidate


class SearchActivity : AppCompatActivity(), ISearchView {

    private lateinit var presenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        presenter = SearchPresenter(this)
        candidatesRecyclerView.layoutManager = LinearLayoutManager(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            searchInput.isFocusedByDefault = true
        }

        searchByName.onClick {
            presenter.onSearch(searchInput.text.toString(), null)
        }

        searchByUrnName.onClick {
            presenter.onSearch(null, searchInput.text.toString())
        }
    }

    override fun showCandidates(results: List<DimCandidate>) {
        candidatesRecyclerView.adapter = SearchAdapter(this, results)
        hideKeyboard()
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }

    override fun hideProgressBar() {
        candidatesRecyclerView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun showProgressBar() {
        candidatesRecyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }
}
