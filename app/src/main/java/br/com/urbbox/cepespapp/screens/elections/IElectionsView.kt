package br.com.urbbox.cepespapp.screens.elections

import br.com.urbbox.cepespapp.data.Candidate

interface IElectionsView {
    fun showElections(candidates: List<Candidate>)
    fun showProgressBar()
    fun hideProgressBar()
    fun setTitle(name: String)

}
