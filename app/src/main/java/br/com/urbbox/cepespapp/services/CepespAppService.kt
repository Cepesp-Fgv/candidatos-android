package br.com.urbbox.cepespapp.services

import br.com.urbbox.cepespapp.data.ApiResponse
import br.com.urbbox.cepespapp.data.Candidate
import br.com.urbbox.cepespapp.data.DimCandidate
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.io.IOException

class CepespAppService {

    private val client = api(CepespAppApi::class.java)

    suspend fun searchCandidate(candidateName: String?, ballotName: String?): List<DimCandidate> {
        return getList(client.searchCandidate(candidateName, ballotName))
    }

    suspend fun getElections(electoralID: String): List<Candidate> {
        return getList(client.getElections(electoralID.toLong()))
    }

    private fun <T> getList(call: Call<ApiResponse<List<T>>>): List<T> {
        return try {
            val response = call.execute()
            if (response.isSuccessful)
                response.body()!!.data
            else
                emptyList()
        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        }
    }

    interface CepespAppApi {

        @GET("dim/candidato")
        fun searchCandidate(
                @Query("NOME_CANDIDATO") candidateName: String?,
                @Query("NOME_URNA_CANDIDATO") ballotName: String?
        ): Call<ApiResponse<List<DimCandidate>>>

        @GET("candidatos")
        fun getElections(
                @Query("NUM_TITULO_ELEITORAL_CANDIDATO") electoralID: Long
        ): Call<ApiResponse<List<Candidate>>>
    }

}