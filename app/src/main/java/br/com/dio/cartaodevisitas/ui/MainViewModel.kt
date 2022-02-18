package br.com.dio.cartaodevisitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.dio.cartaodevisitas.data.CartaoDeVisitas
import br.com.dio.cartaodevisitas.data.CartaoDeVisitasRepository

class MainViewModel(private val cartaoDeVisitasRepository: CartaoDeVisitasRepository) : ViewModel() {
    fun insert(cartaoDeVisitas: CartaoDeVisitas) {
        cartaoDeVisitasRepository.insert(cartaoDeVisitas)
    }

    fun getAll(): LiveData<List<CartaoDeVisitas>> {
        return cartaoDeVisitasRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: CartaoDeVisitasRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
