package kz.iitu.umutpa.dashboard.todo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kz.iitu.umutpa.R


class TaskRecyclerViewAdapter(options: FirestoreRecyclerOptions<Task>, var context: Context) :
    FirestoreRecyclerAdapter<Task, TaskRecyclerViewAdapter.MyViewHolder>(options) {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.textView_title)
        var description: TextView = itemView.findViewById(R.id.textView_description)
        var taskCompleted: CheckBox = itemView.findViewById(R.id.task_completed)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: Task) {
        holder.title.text = model.title
        holder.description.text = model.description
        holder.taskCompleted.isChecked = model.completed.equals("yes")

        holder.itemView.findViewById<CheckBox>(R.id.task_completed).setOnClickListener {
            val docId: String = snapshots.getSnapshot(position).id

            val user = FirebaseAuth.getInstance().currentUser
            val reference: DocumentReference =
                FirebaseFirestore.getInstance().collection("${user?.uid}").document(docId)

            val data = HashMap<String, Any>()
            if (model.completed == "no") {
                data["completed"] = "yes"
                Toast.makeText(context, "Marked completed", Toast.LENGTH_SHORT).show()
            } else {
                data["completed"] = "no"
            }

            reference.update(data).addOnSuccessListener {
                Log.d("UpdateCheck", "Completed!")
            }.addOnFailureListener {
                Log.d("UpdateCheck", "Failed!")
            }
            notifyDataSetChanged()

        }
    }
}