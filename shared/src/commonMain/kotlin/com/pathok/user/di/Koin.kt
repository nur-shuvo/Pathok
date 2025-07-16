package com.pathok.user.di

import com.pathok.user.data.PathokSampleRepository
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Shuvo on 07/07/2025.
 */

val dataModule = module {
    single {
        PathokSampleRepository()
    }
}

fun initKoin() = initKoin(emptyList())

fun initKoin(extraModules: List<Module>) {
    startKoin {
        modules(
            dataModule,
            *extraModules.toTypedArray(),
        )
    }
}