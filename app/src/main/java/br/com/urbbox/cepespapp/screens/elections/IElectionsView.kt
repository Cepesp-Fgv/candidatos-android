package br.com.urbbox.cepespapp.screens.elections

import br.com.urbbox.cepespapp.data.Candidate

interface IElectionsView {
    fun showElections(candidates: List<Candidate>)

}
