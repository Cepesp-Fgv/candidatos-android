package br.com.urbbox.cepespapp.screens.elections

import br.com.urbbox.cepespapp.data.DimCandidate
import br.com.urbbox.cepespapp.services.CepespAppService
import br.com.urbbox.cepespapp.utils.BasePresenter
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class ElectionsPresenter(view: IElectionsView) : BasePresenter<IElectionsView>(view) {

    private val client = CepespAppService()

    fun loadElections(candidate: DimCandidate) {
        launch(CommonPool) {
            val candidates = client.getElections(candidate.electoralID)

            launch(UI) {
                view.showElections(candidates)
            }
        }
    }

}
