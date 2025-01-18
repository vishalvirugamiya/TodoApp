package com.example.todos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    var mainActivity: MainActivity,
    var List: ArrayList<Data>,
    val deleteCallback: (String) -> Unit, //callback function
    val editCallback: (Data) -> Unit
) : RecyclerView.Adapter<MyAdapter.Holder>() {

    class  Holder(view : View):RecyclerView.ViewHolder(view){

      //  var id : TextView = view.findViewById(R.id.id_item)
        var todo : TextView = view.findViewById(R.id.todo)
        var checkbox : CheckBox = view.findViewById(R.id.checkboX)
       // var completed : TextView = view.findViewById(R.id.completed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        var layoutInflater = LayoutInflater.from(mainActivity)
        var view : View = layoutInflater.inflate(R.layout.item_todo,parent,false)
        var holer: Holder=Holder(view)

        return holer
    }

    override fun getItemCount(): Int {
       return List.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

    //    holder.id.text = "id : "+List[position].Id
        // holder.todo.text =  List[position].todo
        //holder.completed.text = "completd : "+ List[position].completed.toString()

        var model = List[position]

        holder.todo.text =  model.todo
//
//      holder.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
//
//      }
        holder.todo.setOnClickListener {

            var papupMenu = PopupMenu(mainActivity,holder.todo)

            papupMenu.menu.add("Delete")
            papupMenu.menu.add("Edite")
            papupMenu.setOnMenuItemClickListener {

                when(it.title)
                {
                    "Delete" ->{

                        deleteCallback.invoke(model.Id)

                    }
                    "Edite" ->{
                        editCallback.invoke(model)
                    }
                }
                return@setOnMenuItemClickListener true
            }

            papupMenu.show()
        }

    }
}