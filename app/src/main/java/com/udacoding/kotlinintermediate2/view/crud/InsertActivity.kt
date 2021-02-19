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
import com.udacoding.kotlinintermediate2.presenter.crud.CrudPresenter
import com.udacoding.kotlinintermediate2.view.MainActivity
import kotlinx.android.synthetic.main.activity_insert.*

class InsertActivity : AppCompatActivity(), View.OnClickListener, CrudPresenter.CrudView {

    private val TAG = "InsertActivity"
    private var presenter: CrudPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        topAppBarInput.setNavigationOnClickListener { onBackPressed() }

        presenter = CrudPresenter(this)
        btn_submit_input.setOnClickListener(this)
        btn_input_batal.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            btn_submit_input -> {
                val name = edt_input_name.editText?.text.toString()
                val deskripsi = edt_input_deskripsi.editText?.text.toString()
                val prasyarat = edt_input_prasyarat.editText?.text.toString()
                val durasi = edt_input_durasi.editText?.text.toString()

                errorField(edt_input_name)
                errorField(edt_input_prasyarat)
                errorField(edt_input_durasi)
                errorField(edt_input_deskripsi)


                var isEmptyField = false

                when{
                    name.isEmpty()-> {
                        isEmptyField = true
                        edt_input_name.error = "Tidak boleh kosong"
                    }

                    deskripsi.isEmpty() -> {
                        isEmptyField = true
                        edt_input_deskripsi.error = "Tidak boleh kosong"
                    }

                    prasyarat.isEmpty() -> {
                        isEmptyField = true
                        edt_input_prasyarat.error = "Tidak boleh kosong"
                    }

                    durasi.isEmpty() -> {
                        isEmptyField = true
                        edt_input_durasi.error = "Tidak boleh kososng"
                    }
                }

                if(!isEmptyField){
                    presenter?.insertData(name, deskripsi, prasyarat, durasi)
                }
            }

            btn_input_batal -> {
                onBackPressed()
            }
        }
    }

    private fun errorField(s: TextInputLayout){
        if(s.editText?.text != null){
            s.isErrorEnabled = false
        }
    }

    override fun onSuccess(response: CrudResponse) {
        Toast.makeText(this, "Input berhasil", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onError(msg: String) {
        Log.d(TAG, msg)
    }
}