package br.com.urbbox.cepespapp.screens.details

import br.com.urbbox.cepespapp.data.Candidate
import br.com.urbbox.cepespapp.services.deserialize
import br.com.urbbox.cepespapp.services.serialize
import br.com.urbbox.cepespapp.utils.BasePresenter

class CandidateDetailsPresenter(view: ICandidateDetailsView) : BasePresenter<ICandidateDetailsView>(view) {

    private val exclude = arrayOf("id", "totalVotes", "ballotName")

    fun fill(candidate: Candidate) {
        val info = getCandidateInfo(candidate)

        view.setExtraInfo(info)
        view.setTitle(candidate.electionYear)
        view.setBallotName(candidate.ballotName)
        view.setTotalVotes(candidate.totalVotes)
    }

    private fun getCandidateInfo(candidate: Candidate): List<Pair<String, String?>> {
        val serialized = serialize(candidate)
        val map = deserialize(serialized) as Map<String, String?>

        return map
                .filter { it.key !in exclude }
                .map { it.key.replace('_', ' ') to it.value }
    }
}
