package com.ali.submission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class gituserdetail : AppCompatActivity() {
    companion object{
        const val USER_GIT_DTL = "usergitdpt"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gituserdetail)
        val imageavatar:ImageView = findViewById(R.id.users_avatar)
        val gitname: TextView = findViewById(R.id.gitname)
        val username_github: TextView = findViewById(R.id.username_github)
        val txtcompany: TextView = findViewById(R.id.txtcompany)
        val txtlocation: TextView = findViewById(R.id.txtlocation)
        val btnfollower: Button = findViewById(R.id.btnfollower)
        val btnfollowing: Button = findViewById(R.id.btnfollowing)
        val btnRepository: Button = findViewById(R.id.btnRepository)

        val gituser = intent.getParcelableExtra<userdata>(USER_GIT_DTL) as userdata
        Glide.with(this).load(gituser.Avatar).circleCrop().into(imageavatar)
        gitname.text=gituser.Name
        gitname.text=gituser.Username
        username_github.text = gituser.Username
        txtcompany.text=gituser.Company
        txtlocation.text=gituser.Location
        btnfollower.text="Follower  "+gituser.Follower
        btnfollowing.text="Following  "+gituser.Following
        btnRepository.text="Repository  "+gituser.Repository
    }
}
