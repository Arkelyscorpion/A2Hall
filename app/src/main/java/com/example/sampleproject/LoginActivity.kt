package com.example.sampleproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class LoginActivity : AppCompatActivity() {
    private lateinit var mAuth : FirebaseAuth
    val  firebaseAuth= FirebaseAuth.getInstance()
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var userProfile :GoogleSignInAccount

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val signInButton = findViewById<Button>(R.id.sign_in_button)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()
         googleSignInClient = GoogleSignIn.getClient(this, gso);

        mAuth = firebaseAuth



        signInButton.setOnClickListener{
            signInGoogle()

        }



    }

    private fun signInGoogle(){
        val signInIntent:Intent=googleSignInClient.signInIntent
        resultLauncher.launch(signInIntent)
    }
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data :Intent? = result.data
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            if(task.isSuccessful){
                try {
                    val account = task.getResult(ApiException::class.java)
                    firebaseAuthWithGoogle(account.idToken!!)

                }
                catch (e:ApiException){
                    println("excpetion")
                }
            }
            // There are no request codes
//            val data: Intent? = result.data
//            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
//            handleResult(task)
        }
    }
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("signinact", "signInWithCredential:success")
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity((intent))
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("signinact", "signInWithCredential:failure", task.exception)
                }
            }
    }

//    private fun UpdateUI(account: GoogleSignInAccount){
//        val credential= GoogleAuthProvider.getCredential(account.idToken,null)
//        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {task->
//            if(task.isSuccessful) {
//                SavedPreference.setEmail(this,account.email.toString())
//                SavedPreference.setUsername(this,account.displayName.toString())
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }
//    }

//    private fun handleResult(completedTask: Task<GoogleSignInAccount>){
//        try {
//            val account: GoogleSignInAccount? =completedTask.getResult(ApiException::class.java)
//            if (account != null) {
//                UpdateUI(account)
//            }
//        } catch (e:ApiException){
//            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show()
//        }
//    }



}