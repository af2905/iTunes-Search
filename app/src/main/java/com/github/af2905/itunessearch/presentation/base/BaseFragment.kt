package com.github.af2905.itunessearch.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.af2905.itunessearch.App
import com.github.af2905.itunessearch.di.viewmodel.ViewModelComponent

abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDaggerDependencies()
    }

    private fun createDaggerDependencies() =
        injectDependency((requireActivity().application as App).getViewModelComponent())

    abstract fun injectDependency(component: ViewModelComponent)
}