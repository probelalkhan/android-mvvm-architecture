package net.simplifiedcoding.mvvmsampleapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.simplifiedcoding.mvvmsampleapp.data.db.AppDatabase
import net.simplifiedcoding.mvvmsampleapp.data.db.entities.Quote
import net.simplifiedcoding.mvvmsampleapp.data.network.MyApi
import net.simplifiedcoding.mvvmsampleapp.data.network.SafeApiRequest
import net.simplifiedcoding.mvvmsampleapp.util.Coroutines

class QuotesRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    suspend fun getQuotes(): LiveData<List<Quote>>{
        return withContext(Dispatchers.IO){
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }
    }

    private suspend fun fetchQuotes() {
        if (isFetchNeeded()) {
            val response = apiRequest { api.getQuotes() }
            quotes.postValue(response.quotes)
        }
    }

    private fun isFetchNeeded(): Boolean {
        return true
    }


    private fun saveQuotes(quotes: List<Quote>) {
        Coroutines.io {
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }

}