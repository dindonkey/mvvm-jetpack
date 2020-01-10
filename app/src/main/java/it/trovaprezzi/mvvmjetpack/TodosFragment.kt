package it.trovaprezzi.mvvmjetpack

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import it.trovaprezzi.mvvmjetpack.databinding.TodosFragmentBinding


class TodosFragment : Fragment() {

    private lateinit var viewModel: TodosViewModel
    private lateinit var binding: TodosFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(TodosViewModel::class.java)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.todos_fragment,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TodosListAdapter()
        binding.todos.adapter = adapter
        viewModel.todosList.observe(viewLifecycleOwner, Observer { todosList ->
            adapter.submitList(todosList)
        })

    }

}
