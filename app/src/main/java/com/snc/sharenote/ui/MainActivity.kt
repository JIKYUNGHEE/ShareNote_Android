package com.snc.sharenote.ui

import android.content.Intent
import android.net.Network
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.nhn.android.naverlogin.OAuthLogin
import com.nhn.android.naverlogin.OAuthLoginHandler
import com.snc.sharenote.R
import com.snc.sharenote.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val TAG: String? = this::class.java.simpleName

    private val LOGIN_INFO_SNS: String? = "LOGIN_INFO_SNS"
    private val LOGIN_INFO_ID: String? = "LOGIN_INFO_ID"
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var binding: ActivityMainBinding
    private lateinit var mOAuthLoginModule: OAuthLogin

    companion object {
        var RC_SIGN_IN: Int = 1;
    }

    // 로그인 공통 callback 구성
    val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.e(TAG, "로그인 실패", error)
            startActivity(Intent(this, NetworkTestActivity::class.java))
        } else if (token != null) {
            Log.i(TAG, "로그인 성공 ${token.accessToken}")
        }
    }

    /**
     * OAuthLoginHandler를 startOAuthLoginActivity() 메서드 호출 시 파라미터로 전달하거나 OAuthLoginButton
     * 객체에 등록하면 인증이 종료되는 것을 확인할 수 있습니다.
     */
    private val mOAuthLoginHandler: OAuthLoginHandler = object : OAuthLoginHandler() {
        override fun run(success: Boolean) {
            if (success) {
                val accessToken: String = mOAuthLoginModule.getAccessToken(applicationContext)
                val refreshToken: String = mOAuthLoginModule.getRefreshToken(applicationContext)
                val expiresAt: Long = mOAuthLoginModule.getExpiresAt(applicationContext)
                val tokenType: String = mOAuthLoginModule.getTokenType(applicationContext)
                binding.loginSuccess.text =
                    mOAuthLoginModule.getState(applicationContext).toString()
            } else {
                val errorCode: String =
                    mOAuthLoginModule.getLastErrorCode(applicationContext).getCode()
                val errorDesc: String = mOAuthLoginModule.getLastErrorDesc(applicationContext)
                Toast.makeText(
                    applicationContext, "errorCode:" + errorCode
                            + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initGoogleLogin()
        initNaverLogin()
        binding.loginGoogle.setSize(SignInButton.SIZE_STANDARD)
        binding.loginGoogle.setOnClickListener { view ->
            val signInIntent: Intent = mGoogleSignInClient?.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        binding.loginKakao.setOnClickListener { view ->
            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (LoginClient.instance.isKakaoTalkLoginAvailable(applicationContext)) {
                LoginClient.instance.loginWithKakaoTalk(applicationContext, callback = callback)
            } else {
                LoginClient.instance.loginWithKakaoAccount(applicationContext, callback = callback)
            }
        }

        binding.loginNaver.setOAuthLoginHandler(mOAuthLoginHandler)
    }


    private fun initGoogleLogin() {
        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    private fun initNaverLogin() {
        mOAuthLoginModule = OAuthLogin.getInstance()
        mOAuthLoginModule.init(
            this,
            getString(R.string.naver_client_key), getString(
                R.string.naver_secret_key
            ), "ShareNote"
        )
    }


    override fun onStart() {
        super.onStart()
        val account: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
    }

    private fun updateUI(account: GoogleSignInAccount?) {
        if (account != null) {
            binding.loginSuccess.visibility = View.VISIBLE
            Log.d("MainActivity", "account: $account, email: ${account.email}")

            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra(LOGIN_INFO_SNS, "Google")
            intent.putExtra(LOGIN_INFO_ID, account.email)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            updateUI(null)
        }
    }
}
