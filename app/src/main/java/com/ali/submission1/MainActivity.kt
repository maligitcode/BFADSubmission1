package com.ali.submission1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private  lateinit var rvuser : RecyclerView
    private val list = ArrayList<userdata>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvuser = findViewById(R.id.listuser)
        rvuser.setHasFixedSize(true)

        list.addAll(listuser)
        showRecyclerList()
    }

    private  val listuser:ArrayList<userdata>
        get(){
            val username = resources.getStringArray(R.array.username)
            val name = resources.getStringArray(R.array.name)
            val location = resources.getStringArray(R.array.location)
            val repository = resources.getStringArray(R.array.repository)
            val company = resources.getStringArray(R.array.company)
            val following = resources.getStringArray(R.array.following)
            val followers = resources.getStringArray(R.array.followers)
            val avatar = resources.obtainTypedArray(R.array.avatar)
            val listusers = ArrayList<userdata>()
            for (i in username.indices){
                val user = userdata(username[i],name[i],avatar.getResourceId(i, -1),company[i],location[i],repository[i],followers[i],following[i])
                listusers.add(user)
                Log.v("name",name[i].toString())
                Log.v("avatar",avatar.getResourceId(i, -1).toString())
            }
            return  listusers

        }

    private fun  showRecyclerList(){
        rvuser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter=ListUserAdapter(list)
        rvuser.adapter=listUserAdapter
        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: userdata) {
                showSelectedgituser(data)
            }
        })
    }

    private fun showSelectedgituser(Usergit: userdata) {
        var parseuser= userdata(
            Usergit.Username,
            Usergit.Name,
            Usergit.Avatar,
            Usergit.Company,
            Usergit.Location,
            Usergit.Repository,
            Usergit.Follower,
            Usergit.Following
        )
        val intentdtl = Intent(this@MainActivity, gituserdetail::class.java)
        intentdtl.putExtra(gituserdetail.USER_GIT_DTL,parseuser)
        startActivity(intentdtl)
    }
}
