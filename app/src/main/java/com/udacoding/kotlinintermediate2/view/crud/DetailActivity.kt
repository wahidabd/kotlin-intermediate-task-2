package com.udacoding.kotlinintermediate2.view.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.udacoding.kotlinintermediate2.R
import com.udacoding.kotlinintermediate2.model.crud.CrudResponse
import com.udacoding.kotlinintermediate2.model.crud.DataItem
import com.udacoding.kotlinintermediate2.presenter.crud.CrudPresenter
import com.udacoding.kotlinintermediate2.view.MainActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity(), Toolbar.OnMenuItemClickListener, CrudPresenter.CrudView {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    private var presenter: CrudPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        showData()
        presenter = CrudPresenter(this)

        topAppBarDetail.setOnMenuItemClickListener(this)

        topAppBarDetail.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun showData(){
        val data =  intent.getParcelableExtra<DataItem>(EXTRA_DATA)


        tv_detail_nama.text = data?.nama
        tv_detail_deskripsi.text = data?.deskripsi
        tv_detail_prasyarat.text = data?.sarat
        tv_detail_durasi.text = data?.durasi

        topAppBarDetail.title = data?.nama
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        val data =  intent.getParcelableExtra<DataItem>(EXTRA_DATA)

        return when(item?.itemId){
                R.id.menu_hapus -> {
                    presenter?.delete(data?.id.toString())
                    true
                }

                R.id.menu_edit -> {
                    val intent = Intent(this, UpdateActivity::class.java)
                    intent.putExtra(UpdateActivity.EXTRA_UPDATE, data)
                    startActivity(intent)
                    true
                }

            else -> false
        }
    }

    override fun onSuccess(response: CrudResponse) {
        val data =  intent.getParcelableExtra<DataItem>(EXTRA_DATA)
        Toast.makeText(this, "${data?.nama} berhasil dihapus", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}