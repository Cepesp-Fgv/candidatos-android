package br.com.urbbox.cepespapp.screens.details

interface ICandidateDetailsView {
    fun setExtraInfo(info: List<Pair<String, String?>>)
    fun setTitle(electionYear: String)
    fun setBallotName(ballotName: String)
    fun setTotalVotes(totalVotes: String?)
}
