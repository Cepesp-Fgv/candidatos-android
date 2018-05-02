package br.com.urbbox.cepespapp.screens.search

import br.com.urbbox.cepespapp.data.DimCandidate

interface ISearchView {
    fun showCandidates(results: List<DimCandidate>)
}
