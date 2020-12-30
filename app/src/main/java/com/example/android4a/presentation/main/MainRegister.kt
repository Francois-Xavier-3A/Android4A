package com.example.android4a.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android4a.R
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.android4a.domain.entity.Monster
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.login_edit
import kotlinx.android.synthetic.main.activity_main.password_edit
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.save.*
import org.koin.android.ext.android.inject

class MainRegister : AppCompatActivity() {
    val mainViewModele: MainViewModele by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.save)

        mainViewModele.createLiveData.observe(this, Observer{
            when(it){
                is CreateSucess -> {
                    mainViewModele.onClickedCreate(login_edit.text.toString().trim(), password_edit.text.toString())
                    var toast: Toast = Toast.makeText(this,"Je suis là",Toast.LENGTH_LONG)
                    toast.show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent);
                }
                CreateError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Deja existant")
                        .setPositiveButton("Ok"){ dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        save_button.setOnClickListener{
            mainViewModele.ExistUser(login_edit.text.toString().trim(), password_edit.text.toString())
        }

    }
}