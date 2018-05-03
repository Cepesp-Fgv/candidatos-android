package br.com.urbbox.cepespapp.screens.details

import br.com.urbbox.cepespapp.data.Candidate
import br.com.urbbox.cepespapp.services.deserialize
import br.com.urbbox.cepespapp.services.serialize
import br.com.urbbox.cepespapp.utils.BasePresenter
import com.google.gson.reflect.TypeToken

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
        val map: Map<String, String?> = deserialize(serialized, object : TypeToken<Map<String, String?>>() {}.type)

        return map
                .filter { it.key !in exclude }
                .map { it.key.replace('_', ' ') to it.value }
    }
}
