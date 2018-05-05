package br.com.urbbox.cepespapp.screens.search

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import android.view.inputmethod.InputMethodManager
import br.com.urbbox.cepespapp.R
import br.com.urbbox.cepespapp.data.DimCandidate
import com.mancj.materialsearchbar.MaterialSearchBar
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric




class SearchActivity : AppCompatActivity(), ISearchView, TabLayout.OnTabSelectedListener, MaterialSearchBar.OnSearchActionListener {


    private lateinit var presenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        presenter = SearchPresenter(this)
        candidatesRecyclerView.layoutManager = LinearLayoutManager(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            searchInput.isFocusedByDefault = true
        }

        searchByTab.addOnTabSelectedListener(this)
        searchInput.setOnSearchActionListener(this)
    }

    override fun onButtonClicked(buttonCode: Int) {
        //Do nothing
    }

    override fun onSearchStateChanged(enabled: Boolean) {
        //Do nothing
    }

    override fun onSearchConfirmed(text: CharSequence?) {
        onSearch()
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        //Do nothing
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        //Do nothing
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        onSearch()
    }

    private fun onSearch() {
        when (searchByTab.selectedTabPosition) {
            0 -> presenter.onSearchByName(searchInput.text)
            else -> presenter.onSearchByBallotName(searchInput.text)
        }
    }

    override fun showCandidates(results: List<DimCandidate>) {
        candidatesRecyclerView.adapter = SearchAdapter(this, results)
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
        hideKeyboard()
    }
}
