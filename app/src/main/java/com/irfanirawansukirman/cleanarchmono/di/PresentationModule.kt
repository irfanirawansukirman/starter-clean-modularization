package com.irfanirawansukirman.cleanarchmono.di

import com.irfanirawansukirman.cleanarchmono.ui.main.presentation.MainVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MainVM(get()) }
}