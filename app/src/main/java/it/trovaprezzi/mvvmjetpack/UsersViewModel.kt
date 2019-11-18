package it.trovaprezzi.mvvmjetpack

import androidx.lifecycle.ViewModel

class UsersViewModel: ViewModel() {
    lateinit var user: User

    fun start() {
        user = User("cicciopollo")
    }
}