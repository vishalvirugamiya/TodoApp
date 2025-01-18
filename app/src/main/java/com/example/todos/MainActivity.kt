package com.example.todos

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.todos.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var  binding: ActivityMainBinding


    val progressDialog : ProgressDialog  by  lazy {
            ProgressDialog(this).apply {

                setTitle("Please waite ...")
            }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var nameList = arrayListOf("Default","Personal","Shopping","Wishlist","Work")
        var iconList = arrayListOf(
            R.drawable.ic_sharp,R.drawable.ic_sharp,R.drawable.ic_sharp,
            R.drawable.ic_sharp,R.drawable.ic_sharp)

        var optiionAdapter = OptionAdapter(this,nameList,iconList)
        binding.autoComlateText.setAdapter(optiionAdapter)

        binding.addTodo.setOnClickListener {

            var inten :Intent= Intent(this@MainActivity,AddTodo::class.java)
            startActivity(inten)
        }


        fetchData()
    }

    private fun fetchData() {

        progressDialog.show()

        val queue = Volley.newRequestQueue(this)
         // val url = "https://generateapi.onrender.com/api/tosos"

        val stringRequest = object : StringRequest(
            Request.Method.GET, api,
            { response ->

                var myData : MyModel = Gson().fromJson(response,MyModel::class.java)
                setAdapter(myData.Data)
                progressDialog.dismiss()

            },
            { volleyError ->

                //binding.textView.text = volleyError.localizedMessage
            }){

            override fun getHeaders(): MutableMap<String, String> {
//                var map = mutableMapOf(
//                    Pair("Authorization","XDd8SHFPk2tzZUds"),
//                    Pair("Content-Type","application/json")
//                )
                return apiHeaders
            }
        }

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    private fun deleteTodo(id: String) {

        progressDialog.show()

        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Request.Method.DELETE,
            "$api/$id",
            { response ->

                Toast.makeText(this@MainActivity, "Deleted", Toast.LENGTH_SHORT).show()

                fetchData()

            },
            { volleyError ->

            }){
            override fun getHeaders(): MutableMap<String, String> {
                return apiHeaders
            }
        }

        queue.add(stringRequest)
    }

    private fun editeTodo(todos: Data) {

        var intent : Intent = Intent (this@MainActivity,AddTodo::class.java)
        intent.putExtra("model",todos)
        startActivity(intent)
        finish()
    }

    private fun setAdapter(todo: ArrayList<Data>) {

        var adapter = MyAdapter(
            mainActivity = this@MainActivity,
            List = todo,
            editCallback = {
                editeTodo(it)
            },
            deleteCallback = {
                deleteTodo(it)
            })

          //var adapter : MyAdapter= MyAdapter(this@MainActivity,List)

          binding.RecycleView.adapter=adapter
    }


    override fun onBackPressed():Unit {
        super.onBackPressed()
        //Log.d("CDA", "onBackPressed Called")
        val setIntent = Intent(Intent.ACTION_MAIN)
        setIntent.addCategory(Intent.CATEGORY_HOME)
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(setIntent)

        return
    }



}
    //  https://generateapi.onrender.com/api/tosos  https://generateapi.onrender.com/api/tosos/:id
    //  Authorization : XDd8SHFPk2tzZUds
