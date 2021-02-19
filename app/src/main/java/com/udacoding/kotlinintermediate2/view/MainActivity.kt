package com.udacoding.kotlinintermediate2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacoding.kotlinintermediate2.R
import com.udacoding.kotlinintermediate2.adapter.ListViewAdapter
import com.udacoding.kotlinintermediate2.helper.SessionManager
import com.udacoding.kotlinintermediate2.model.crud.DataItem
import com.udacoding.kotlinintermediate2.network.ConfigNetwork
import com.udacoding.kotlinintermediate2.presenter.crud.CrudPresenter
import com.udacoding.kotlinintermediate2.view.auth.LoginActivity
import com.udacoding.kotlinintermediate2.view.crud.DetailActivity
import com.udacoding.kotlinintermediate2.view.crud.InsertActivity
import com.udacoding.kotlinintermediate2.view.more.ProfileActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.*

class MainActivity : AppCompatActivity(), Toolbar.OnMenuItemClickListener, View.OnClickListener{

    private val TAG = "MainActivity"
    private var sessionManager: SessionManager? = null
    private var presenter: CrudPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionManager = SessionManager(this)

        //Button and Menu
        fb_insert?.setOnClickListener(this)
        rv_home.layoutManager = LinearLayoutManager(this)
        topAppBar.setOnMenuItemClickListener(this)

        showData()
    }

    override fun onResume() {
        super.onResume()
        showData()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when(item?.itemId){
                R.id.menu_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }

                R.id.menu_logout -> {
                    sessionManager?.logout()
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                    true
                }

                else -> false
            }
    }

    private fun showData(){
        val listData = ConfigNetwork.getApi().getData()
        listData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val item = it.data
                val adapter = ListViewAdapter(item as List<DataItem>?)
                rv_home.adapter = adapter


                adapter.setOnItemCallback(object : ListViewAdapter.OnItemClickCallback{
                    override fun onItemClicked(item: DataItem?) {
                        Toast.makeText(this@MainActivity, item?.nama, Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_DATA, item)
                        startActivity(intent)
                    }

                })
            }, {
                Log.d(TAG, it.localizedMessage)
            })
    }

    override fun onClick(v: View?) {
        when(v){
            fb_insert -> {
                startActivity(Intent(this, InsertActivity::class.java))
            }
        }
    }
}