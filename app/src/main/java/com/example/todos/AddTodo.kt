package com.example.todos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.todos.databinding.ActivityAddTodoBinding
import org.json.JSONObject

class AddTodo : AppCompatActivity() {

    lateinit var binding: ActivityAddTodoBinding

    var editeData : Data?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // enableEdgeToEdge()

        binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editeData = intent.getSerializableExtra("model") as Data?



        editeData?.let {

            binding.newTodo.setText(it.todo)
            binding.submit.text = "Update"
        }

        binding.addappbar.setNavigationOnClickListener {

           var intent: Intent= Intent(this@AddTodo,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.submit.setOnClickListener {


            var todo = binding.newTodo.text.toString()
            var completed = binding.completed.text.toString()

        if(editeData!=null){

            editteTodo(todo,completed)
        }else {

            AddData(todo,completed)
        }

            var intent : Intent= Intent(this@AddTodo,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun editteTodo(todo: String, completed: String) {
        val queue = Volley.newRequestQueue(this)
        // val url = "https://generateapi.onrender.com/api/tosos"

        // Request a string response from the provided URL.
        val stringRequest = object : StringRequest(
            Request.Method.PATCH,
            "$api/${editeData!!.Id}",
            { response ->


            },
            { volleyError ->

                //  binding.textView.text = volleyError.localizedMessage
            }){

            override fun getHeaders(): MutableMap<String, String> {

                return apiHeaders
            }

            override fun getBody(): ByteArray {
                val data = JSONObject()
                data.put("todo", todo)
                data.put("completed", false)
                return data.toString().toByteArray()
            }
        }

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }


    fun AddData(todo: String, completed: String) {


        val queue = Volley.newRequestQueue(this)
        // val url = "https://generateapi.onrender.com/api/tosos"

        // Request a string response from the provided URL.
        val stringRequest = object : StringRequest(
            Request.Method.POST, api,
            { response ->


            },
            { volleyError ->

              //  binding.textView.text = volleyError.localizedMessage
            }){

            override fun getHeaders(): MutableMap<String, String> {

                return apiHeaders
            }

            override fun getBody(): ByteArray {
                val data = JSONObject()
                data.put("todo", todo)
                data.put("completed", false)
                return data.toString().toByteArray()
            }
        }

       // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }
}