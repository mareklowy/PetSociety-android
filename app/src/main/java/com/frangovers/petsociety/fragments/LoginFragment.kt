package com.frangovers.petsociety.fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.frangovers.petsociety.MainActivity
import com.frangovers.petsociety.R
import kotlinx.android.synthetic.main.fragment_login.*


/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private var callbackManager: CallbackManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onStart() {
        super.onStart()
        initFacebookLogin()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager?.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun initFacebookLogin() {
        callbackManager = CallbackManager.Factory.create()
        val email = "email"

        (login_button as LoginButton).setReadPermissions(listOf(email))
        login_button.fragment = this

        // Callback registration
        login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                loginSuccess(loginResult)
            }

            override fun onCancel() {
                Log.d("FB_LOGIN", "Login Canceled...")
            }

            override fun onError(exception: FacebookException) {
                // App code
            }
        })
    }

    private fun loginSuccess(loginResult: LoginResult) {
        Log.d("FB_LOGIN", "UserId: ${loginResult.accessToken.userId}")
        Log.d("FB_LOGIN", "UserToken: ${loginResult.accessToken.token}")

        //TODO: Implement API calls

        val intent = Intent(context, MainActivity::class.java).apply {
            //putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

}
