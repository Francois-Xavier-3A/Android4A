package com.example.android4a.injection
import com.example.android4a.MainViewModele
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModele() }
}