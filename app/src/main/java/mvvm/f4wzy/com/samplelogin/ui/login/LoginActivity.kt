package mvvm.f4wzy.com.samplelogin.ui.login

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import mvvm.f4wzy.com.samplelogin.R
import mvvm.f4wzy.com.samplelogin.databinding.ActivityLoginBinding
import mvvm.f4wzy.com.samplelogin.ui.login.viewmodel.LoginViewModel
import mvvm.f4wzy.com.samplelogin.util.CustomeProgressDialog

class LoginActivity : AppCompatActivity() {

    var binding: ActivityLoginBinding? = null
    var viewmodel: LoginViewModel? = null
    var customeProgressDialog: CustomeProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding?.viewmodel = viewmodel
        customeProgressDialog = CustomeProgressDialog(this)
        initObservables()


    }

    private fun initObservables() {
        viewmodel?.progressDialog?.observe(this, Observer {
            if (it!!) customeProgressDialog?.show() else customeProgressDialog?.dismiss()
        })

        viewmodel?.userLogin?.observe(this, Observer { user ->
            Toast.makeText(this, "${user?.message}", Toast.LENGTH_LONG).show()
        })
    }


}
