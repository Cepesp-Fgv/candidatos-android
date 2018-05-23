package br.com.urbbox.cepespapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Candidate(
        @SerializedName("ANO_ELEICAO") val electionYear: String,
        @SerializedName("NUM_TURNO") val turn: String,
        @SerializedName("DESCRICAO_ELEICAO") val electionDesc: String,
        @SerializedName("SIGLA_UF") val UF: String,
        @SerializedName("SIGLA_UE") val UE: String,
        @SerializedName("DESCRICAO_UE") val ueDesc: String,
        @SerializedName("CODIGO_CARGO") val jobCode: String,
        @SerializedName("DESCRICAO_CARGO") val jobDesc: String,
        @SerializedName("NOME_CANDIDATO") val name: String,
        @SerializedName("NUMERO_CANDIDATO") val number: String,
        @SerializedName("CPF_CANDIDATO") val CPF: String,
        @SerializedName("NOME_URNA_CANDIDATO") val ballotName: String,
        @SerializedName("COD_SITUACAO_CANDIDATURA") val sitCode: String,
        @SerializedName("DES_SITUACAO_CANDIDATURA") val sitDesc: String,
        @SerializedName("NUMERO_PARTIDO") val partyNumber: String,
        @SerializedName("SIGLA_PARTIDO") val partyAbbr: String,
        @SerializedName("NOME_PARTIDO") val partyName: String,
        @SerializedName("CODIGO_LEGENDA") val partyLabelCode: String,
        @SerializedName("SIGLA_LEGENDA") val partyLabelAbbr: String,
        @SerializedName("COMPOSICAO_LEGENDA") val partyLabelComposition: String,
        @SerializedName("NOME_COLIGACAO") val coalitionComposition: String,
        @SerializedName("CODIGO_OCUPACAO") val coalitionCode: String,
        @SerializedName("DESCRICAO_OCUPACAO") val occupationDesc: String,
        @SerializedName("DATA_NASCIMENTO") val column: String,
        @SerializedName("NUM_TITULO_ELEITORAL_CANDIDATO") val electoralID: String,
        @SerializedName("IDADE_DATA_ELEICAO") val age: String,
        @SerializedName("CODIGO_SEXO") val sexCode: String,
        @SerializedName("DESCRICAO_SEXO") val sexDesc: String,
        @SerializedName("COD_GRAU_INSTRUCAO") val educationCode: String,
        @SerializedName("DESCRICAO_GRAU_INSTRUCAO") val educationDesc: String,
        @SerializedName("CODIGO_ESTADO_CIVIL") val maritalStatusCode: String,
        @SerializedName("DESCRICAO_ESTADO_CIVIL") val maritalStatusDesc: String,
        @SerializedName("CODIGO_COR_RACA") val raceCode: String,
        @SerializedName("DESCRICAO_COR_RACA") val raceDesc: String,
        @SerializedName("CODIGO_NACIONALIDADE") val nationalityCode: String,
        @SerializedName("DESCRICAO_NACIONALIDADE") val nationalityDesc: String,
        @SerializedName("SIGLA_UF_NASCIMENTO") val birthStateAbbr: String,
        @SerializedName("CODIGO_MUNICIPIO_NASCIMENTO") val birthMunicipalityCode: String,
        @SerializedName("NOME_MUNICIPIO_NASCIMENTO") val birthMunicipalityName: String,
        @SerializedName("DESPESA_MAX_CAMPANHA") val maxCampaignExpenses: String,
        @SerializedName("COD_SIT_TOT_TURNO") val roundTotSitCode: String?,
        @SerializedName("DESC_SIT_TOT_TURNO") val roundTotSitDesc: String?,
        @SerializedName("EMAIL_CANDIDATO") val email: String?,
        @SerializedName("TOTAL_VOTACAO") val totalVotes: String?
) : Parcelable