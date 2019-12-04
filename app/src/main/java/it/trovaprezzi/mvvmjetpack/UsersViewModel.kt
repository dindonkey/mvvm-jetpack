package it.trovaprezzi.mvvmjetpack

import android.util.Log.d
import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlin.random.Random

class UsersViewModel : ViewModel() {
    private val reloadTrigger = MutableLiveData<Boolean>()

    private val _navigateToTodos = MutableLiveData<Event<Boolean>>()
    val navigateToTodos : LiveData<Event<Boolean>>
        get() = _navigateToTodos


    init {
        reload()
    }

    val user: LiveData<Result<User>> = Transformations.switchMap(reloadTrigger) {
        liveData {
            emit(Result.loading(null))
            emit(Result.success(fetchUser()))
        }
    }

    suspend fun fetchUser(): User {
        val nextInt = Random.nextInt(0, 100)
        d("DEBUGG!!!", "start fetch user" + nextInt)
        delay(5000)
        d("DEBUGG!!!", "end fetch user"+ nextInt)
        return User("pippo" + nextInt)
    }

    fun reload() {
        reloadTrigger.value = true
    }

    fun clickOnUser() {
        _navigateToTodos.value = Event(true)
    }
}