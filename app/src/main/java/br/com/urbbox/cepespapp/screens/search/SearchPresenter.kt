package br.com.urbbox.cepespapp.screens.search

import br.com.urbbox.cepespapp.services.CepespAppService
import br.com.urbbox.cepespapp.utils.BasePresenter
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class SearchPresenter(view: ISearchView) : BasePresenter<ISearchView>(view) {

    private val service = CepespAppService()

    init {
        view.hideProgressBar()
    }

    fun onSearchByName(input: String) {
        onSearch(input, null)
    }

    fun onSearchByBallotName(input: String) {
        onSearch(null, input)
    }

    private fun onSearch(candidateName: String?, ballotName: String?) {
        view.showProgressBar()

        launch(CommonPool) {
            val results = service.searchCandidate(candidateName, ballotName)

            launch(UI) {
                view.hideProgressBar()
                view.showCandidates(results)
            }
        }
    }

}
