package it.trovaprezzi.mvvmjetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodosViewModel : ViewModel() {
    val todosList = MutableLiveData<List<Todo>>()

    init {
        todosList.value = arrayListOf(Todo(1,"1", "pippo",false))
    }
}
