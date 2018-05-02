package br.com.urbbox.cepespapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DimCandidate(
        @SerializedName("ID") val id: Int,
        @SerializedName("NOME_CANDIDATO") val name: String,
        @SerializedName("NOME_URNA_CANDIDATO") val ballotName: String,
        @SerializedName("NUM_TITULO_ELEITORAL_CANDIDATO") val electoralID: String
) : Parcelable