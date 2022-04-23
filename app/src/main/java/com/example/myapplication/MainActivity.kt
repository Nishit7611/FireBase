package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSave.setOnClickListener {
            var fname=edtFName.text.toString()
            var lname=edtLname.text.toString()
            var uname=edtUname.text.toString()
            var user=User(fname,lname,uname)
            var db= FirebaseDatabase.getInstance().getReference("User")
            db.child(uname).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"Record inserted Successfully", Toast.LENGTH_LONG).show()
                edtFName.setText("")
                edtLname.setText("")
                edtUname.setText("")
            }
                .addOnFailureListener {
                    Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
                }



        }
        btnViewAll.setOnClickListener {
            var intent= Intent(this,ViewAllActivity::class.java)
            startActivity(intent)

        }
    }

}
