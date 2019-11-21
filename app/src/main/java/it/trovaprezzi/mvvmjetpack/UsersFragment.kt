package it.trovaprezzi.mvvmjetpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import it.trovaprezzi.mvvmjetpack.databinding.UsersFragmentBinding

class UsersFragment : Fragment() {
    private lateinit var usersFragmentBinding: UsersFragmentBinding
    private lateinit var usersViewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        usersFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.users_fragment,
            container,
            false
        )

        usersViewModel = ViewModelProviders.of(this)[UsersViewModel::class.java]
        usersFragmentBinding.lifecycleOwner = this

        // TODO: studiare perchè viene fatto in OnViewCreated su un field autoCleared
        usersFragmentBinding.viewModel = usersViewModel

        return usersFragmentBinding.root
    }

}