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

    fun onSearch(name: String?, ballotName: String?) {
        view.showProgressBar()
        launch(CommonPool) {
            val results = service.searchCandidate(name, ballotName)

            launch(UI) {
                view.hideProgressBar()
                view.showCandidates(results)
            }
        }
    }

}
