package net.simplifiedcoding.mvvmsampleapp.ui.home.quotes

import androidx.lifecycle.ViewModel;
import net.simplifiedcoding.mvvmsampleapp.data.repositories.QuotesRepository
import net.simplifiedcoding.mvvmsampleapp.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
