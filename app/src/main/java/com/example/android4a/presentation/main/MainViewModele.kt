package com.example.android4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModele(
    private val createUserCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){
    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()
    val createLiveData : MutableLiveData<CreateStatus> = MutableLiveData()


    fun onClickedLogin(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            val loginStatus = if (user != null) {
                LoginSuccess(user.email)
            }else {
                LoginError
            }

            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }
    fun onClickedCreate(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO){
            if(getUserUseCase.invoke(emailUser) == null){
                createUserCase.invoke(user = User(emailUser, password))
            }
        }
    }
    fun ExistUser(email: String, password: String){
        viewModelScope.launch(Dispatchers.IO){
            var createAccountStatus: CreateStatus
            if(email == ""){
                createAccountStatus = CreateError
            }
            val user:User? = getUserUseCase.invoke(email)
            createAccountStatus = if (user == null){
                CreateSucess(email)
            }else{
                CreateError
            }
            withContext(Dispatchers.Main){
                createLiveData.value = createAccountStatus
            }
        }
    }
}