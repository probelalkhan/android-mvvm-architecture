package net.simplifiedcoding.mvvmsampleapp.ui.home.profile

import androidx.lifecycle.ViewModel;
import net.simplifiedcoding.mvvmsampleapp.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
