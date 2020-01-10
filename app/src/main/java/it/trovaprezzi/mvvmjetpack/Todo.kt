package it.trovaprezzi.mvvmjetpack

import androidx.recyclerview.widget.DiffUtil

data class Todo(
    val userId: Int,
    val id: String,
    val title: String,
    val completed: Boolean) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem.title == newItem.title //TODO approfondire
            }
        }
    }
}
