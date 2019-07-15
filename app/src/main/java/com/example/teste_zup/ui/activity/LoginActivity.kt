package com.example.teste_zup.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.os.Message
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.teste_zup.R
import com.example.teste_zup.model.UserAccount
import com.example.teste_zup.ui.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.*
import java.lang.Exception
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val mViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        val loginField = edtLogin

        val passField = edtPassword

        var intent = Intent(this, MainActivity::class.java)

        var currentUser: UserAccount? = null;

        // abre a tela de detalhes
        fun openDetails() {

            currentUser = mViewModel.authUser(loginField.text.toString(), passField.text.toString())

            intent.putExtra("UserAccount", currentUser);

            startActivity(intent);

        }

        // função para validar a senha
        fun validPassword(password : String) : Boolean{
            // padrao do regex de verificação letras maiusculas / minusculas e caracteres especiais
            val verify = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+\$")
            return verify.matcher(password).matches()
        }

        // listener do botão de login
        btnLogin.setOnClickListener {
            if (edtLogin.text.isEmpty()){
                Toast.makeText(this,"Usuário inválido",Toast.LENGTH_LONG).show()
            }else{
                if (validPassword(passField.text.toString())){
                    CoroutineScope(Dispatchers.Default).launch {
                        openDetails()
                    }
                }else{
                    Toast.makeText(this,"Senha inválida, a senha deve conter números, letras maiúsculas, letras minúsculas e characteres especiais",Toast.LENGTH_LONG).show()
                }
            }

        }

    }

}
