package uz.abbosbek.retrofitcustomrequestheaders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.abbosbek.retrofitcustomrequestheaders.repository.Repository

class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}