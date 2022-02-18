package br.com.dio.cartaodevisitas.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dio.cartaodevisitas.App
import br.com.dio.cartaodevisitas.R
import br.com.dio.cartaodevisitas.data.CartaoDeVisitas
import br.com.dio.cartaodevisitas.databinding.ActivityAddCartaoVisitasBinding

class AddCartaoDeVisitasActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddCartaoVisitasBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnConfirm.setOnClickListener {
            val cartaoDeVisitas = CartaoDeVisitas(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(cartaoDeVisitas)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}