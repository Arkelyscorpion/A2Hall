package com.example.sampleproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var googleSignInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user= Firebase.auth.currentUser
        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.btnCheckSlot)
        val button3 = findViewById<Button>(R.id.btnDeleteSlot)
        val logout = findViewById<Button>(R.id.logout_button)
        /*
        operations to be performed
        when user tap on the button
        */
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso);

        if(user!=null)
        {
            Details.setBookerEmail(user.email.toString())
        }
        button?.setOnClickListener()
        {
            //intent is used to link one page to another
            val intent = Intent(this, BasicDetails::class.java)
            // start your next activity
            startActivity(intent)
        }

        button2?.setOnClickListener()
        {
            val intent= Intent(this, BookedSlots::class.java)
            startActivity(intent)
            finish()
        }

        button3?.setOnClickListener()
        {
            val intent= Intent(this, DeleteSlots::class.java)
            startActivity(intent)
            finish()
        }
        logout?.setOnClickListener {
            googleSignInClient.signOut().addOnCompleteListener {
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
        }

    }
}