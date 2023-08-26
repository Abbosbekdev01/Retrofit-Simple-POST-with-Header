package uz.abbosbek.retrofitcustomrequestheaders

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import uz.abbosbek.retrofitcustomrequestheaders.models.Post
import uz.abbosbek.retrofitcustomrequestheaders.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {
    var myResponse: MutableLiveData<List<Post>> = MutableLiveData()
    var errorMessage: MutableLiveData<String> = MutableLiveData()
//    var myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
//    var myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
//    var myCustomPosts2: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()

            if (response.isSuccessful) {
                myResponse.value = response.body()
            } else {
                errorMessage.value = response.message()
            }
        }
    }

//    fun getPost2(number: Int) {
//        viewModelScope.launch {
//            viewModelScope.launch {
//                val response = repository.getPost2(number)
//                myResponse2.value = response
//            }
//        }
//    }

//    fun pushPost(post: Post) {
//        viewModelScope.launch {
//            var response = repository.pushPost(post)
//            myResponse.value = response
//        }
//    }
//
//    fun pushPost2(userId: Int, id: Int, title: String, body: String) {
//        viewModelScope.launch {
//            val response = repository.pushPost2(userId, id, title, body)
//            myResponse.value = response
//        }
//    }


//
//    fun getCustomPost(userId: Int, sort: String, order: String) {
//        viewModelScope.launch {
//            val response = repository.getCustomPosts(userId, sort, order)
//            myCustomPosts.value = response
//        }
//    }
////
////    fun getCustomPost2(userId: Int, sort:String, order:String){
////        viewModelScope.launch {
////            val response = repository.getCustomPost2(userId, sort, order)
////            myCustomPosts2.value = response
////        }
////    }

}