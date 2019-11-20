package it.trovaprezzi.mvvmjetpack

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UsersViewModel: ViewModel() {
    val user: LiveData<Result<User>> = liveData {
        emit(Result.loading(null))
        emit(Result.success(fetchUser()))
    }

    suspend fun fetchUser(): User {
        delay(5000)
        return User("pippo")
    }
}