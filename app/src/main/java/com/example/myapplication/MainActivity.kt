package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firebaseDatabase = FirebaseDatabase.getInstance()
        var databaseReference = firebaseDatabase.getReference("messages")

        var Employee = Employee("James Bond", "double o", "rivendell alven city", 32)

        databaseReference.setValue(Employee)
        databaseReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var value = dataSnapshot!!.value

                Log.d("VALUE: ", value.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Error", error!!.message)
            }
        })
    }
    data class Employee(var name: String, var position: String, var homeAddress: String, var age: Int)

}