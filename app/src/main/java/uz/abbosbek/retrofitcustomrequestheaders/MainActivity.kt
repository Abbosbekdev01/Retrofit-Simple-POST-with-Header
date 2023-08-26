package uz.abbosbek.retrofitcustomrequestheaders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import uz.abbosbek.retrofitcustomrequestheaders.adapters.RvAdapter
import uz.abbosbek.retrofitcustomrequestheaders.databinding.ActivityMainBinding
import uz.abbosbek.retrofitcustomrequestheaders.models.Post
import uz.abbosbek.retrofitcustomrequestheaders.repository.Repository

private const val TAG = "Main"

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { RvAdapter() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.getPost()
        viewModel.myResponse.observe(this) { response ->
            myAdapter.setData(response)
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        binding.rv.adapter = myAdapter
        binding.rv.layoutManager = LinearLayoutManager(this)
    }
}