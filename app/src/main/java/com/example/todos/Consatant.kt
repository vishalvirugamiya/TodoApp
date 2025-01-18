package com.example.todos

import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

const val api = "https://generateapi.onrender.com/api/tosos"

val apiHeaders = mutableMapOf<String, String>(
    Pair("Authorization", "XDd8SHFPk2tzZUds"),
    Pair("Content-Type","application/json")
)

//  https://generateapi.onrender.com/api/tosos
//  https://generateapi.onrender.com/api/tosos/:id
//  Authorization : XDd8SHFPk2tzZUds
/*

        Authorization: CKU5fkbeWKuxOzXq

       POST : https://generateapi.onrender.com/api/todos
       GET : https://generateapi.onrender.com/api/todos
       DELETE : https://generateapi.onrender.com/api/todos/:id
       PATCH : https://generateapi.onrender.com/api/todos/:id

         {
       "todo": "Sample Text",
       "completed": false,
       "date": "Sample Text"
        }
 */


/*
private fun fetchData() {

    progressDialog.show()

    val queue = Volley.newRequestQueue(this)
    // val url = "https://generateapi.onrender.com/api/tosos"

    // Request a string response from the provided URL.
    val stringRequest = object : StringRequest(
        Request.Method.GET, api,
        { response ->

            // var myModel : MyModel = Gson().fromJson(response.toString(),MyModel::class.java)
            //  binding.textView.text = myModel.Message.toString()

            //  binding.textView.text = myData.todo

            //     val mainObject: JSONObject=JSONObject(response.toString())

            //   val List = ArrayList<Data>()

//                val array : JSONArray =mainObject.getJSONArray("Data")
//
//                for (i in 0 until array.length()){
//
//                    val todoObject :JSONObject=array.getJSONObject(i)
//
//                    val id : String = todoObject.getString("_id")
//                    val todo : String = todoObject.getString("todo")
//                    val completed : Boolean = todoObject.getBoolean("completed")
//
//                    val model=Data( id,todo,completed)
//                    List.add(model)
//
//                }

            var myData : MyModel = Gson().fromJson(response,MyModel::class.java)
            setAdapter(myData.Data)
            progressDialog.dismiss()

        },
        { volleyError ->

            //binding.textView.text = volleyError.localizedMessage
        }){

        override fun getHeaders(): MutableMap<String, String> {
//                var map = mutableMapOf(
//                    Pair("Authorization","XDd8SHFPk2tzZUds")
//                )
            return apiHeaders
        }
    }

// Add the request to the RequestQueue.
    queue.add(stringRequest)
}

*/
