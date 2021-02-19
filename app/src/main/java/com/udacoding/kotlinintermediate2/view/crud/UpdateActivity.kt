package com.udacoding.kotlinintermediate2.view.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.udacoding.kotlinintermediate2.R
import com.udacoding.kotlinintermediate2.model.crud.CrudResponse
import com.udacoding.kotlinintermediate2.model.crud.DataItem
import com.udacoding.kotlinintermediate2.network.ConfigNetwork
import com.udacoding.kotlinintermediate2.presenter.crud.CrudPresenter
import com.udacoding.kotlinintermediate2.view.MainActivity
import kotlinx.android.synthetic.main.activity_insert.*
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity(), CrudPresenter.CrudView, View.OnClickListener {

    companion object{
        const val EXTRA_UPDATE = "extra_update"
        const val TAG = "UpdateActivity"
    }

    private var presenter: CrudPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val data = intent.getParcelableExtra<DataItem>(EXTRA_UPDATE)

        presenter = CrudPresenter(this)

        btn_submit_update.setOnClickListener(this)

        topAppBarUpdate.title = "Edit ${data?.nama}"
        topAppBarUpdate.setNavigationOnClickListener {
            onBackPressed()
            return@setNavigationOnClickListener
        }
    }

    private fun errorField(s: TextInputLayout){
        if(s.editText?.text != null){
            s.isErrorEnabled = false
        }
    }

    override fun onSuccess(response: CrudResponse) {
        startActivity(Intent(this, MainActivity::class.java))
        Toast.makeText(this, "${response.isSuccess}", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onError(msg: String) {
        Log.d(TAG, msg)
    }

    override fun onClick(v: View?) {
        val data = intent.getParcelableExtra<DataItem>(EXTRA_UPDATE)
        when(v){
            btn_submit_update -> {
                val nama = edt_update_name.editText?.text.toString()
                val deskripsi = edt_update_deskripsi.editText?.text.toString()
                val sarat = edt_update_sarat.editText?.text.toString()
                val durasi = edt_update_durasi.editText?.text.toString()

                errorField(edt_update_name)
                errorField(edt_update_deskripsi)
                errorField(edt_update_sarat)
                errorField(edt_update_durasi)

                var isEmptyField = false

                when{
                    nama.isEmpty()-> {
                        isEmptyField = true
                        edt_update_name.error = "Tidak boleh kosong"
                    }

                    deskripsi.isEmpty() -> {
                        isEmptyField = true
                        edt_update_deskripsi.error = "Tidak boleh kosong"
                    }

                    sarat.isEmpty() -> {
                        isEmptyField = true
                        edt_update_sarat.error = "Tidak boleh kosong"
                    }

                    durasi.isEmpty() -> {
                        isEmptyField = true
                        edt_update_durasi.error = "Tidak boleh kososng"
                    }
                }

                if(!isEmptyField){
                    presenter?.update(data?.id.toString(), nama, deskripsi, sarat, durasi)
                }
            }
        }
    }
}