package com.example.android4a.injection
import android.content.Context
import androidx.room.Room
import com.example.android4a.data.local.AppDatabase
import com.example.android4a.data.local.DataBaseDAO
import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.domain.usecase.GetUserUseCase
import com.example.android4a.presentation.main.MainViewModele
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import java.security.AccessControlContext

val presentationModule = module {
    factory { MainViewModele(get(), get()) }
}

val domainModule = module{
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single {UserRepository(get()) }
    single{createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DataBaseDAO {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}