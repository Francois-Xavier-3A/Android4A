package com.example.android4a.presentation.main
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android4a.R
import com.example.android4a.domain.entity.Monster
import com.example.android4a.domain.entity.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        //setSupportActionBar(toolbar)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Francois-Xavier-3A/Cards/master/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(APIService::class.java)

        api.fetchAllUsers().enqueue(object : Callback<RestMonsterResponce>{

            override fun onResponse(call: Call<RestMonsterResponce>, response: Response<RestMonsterResponce>) {
                if (response.isSuccessful && response.body()!= null)
                    showData(response.body()!!)
            }

            override fun onFailure(call: Call<RestMonsterResponce>, t: Throwable) {
                d("daniel", "onFailure")
            }

        })

    }
    private fun showData(monsters: RestMonsterResponce) {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainList)
            adapter = MonsterAdapter(monsters.results, this@MainList)
        }
    }
}
