package it.trovaprezzi.mvvmjetpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import it.trovaprezzi.mvvmjetpack.databinding.UsersFragmentBinding

class UsersFragment : Fragment() {
    private lateinit var usersFragmentBinding: UsersFragmentBinding

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

        return usersFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        usersFragmentBinding.user = User("pippo")
    }
}