package net.simplifiedcoding.mvvmsampleapp.data.network.responses

import net.simplifiedcoding.mvvmsampleapp.data.db.entities.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)