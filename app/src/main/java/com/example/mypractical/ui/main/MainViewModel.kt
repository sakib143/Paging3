package com.example.mypractical.ui.main

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mypractical.MyApp
import com.example.mypractical.api.ApiExceptions
import com.example.mypractical.api.NoInternetException
import com.example.mypractical.data.model.TopicModel
import com.example.mypractical.data.db.table.TopicTable
import com.example.mypractical.data.repository.TopicRepository
import com.example.mypractical.utils.Constant
import com.example.mypractical.utils.Coroutines
import com.example.mypractical.utils.GlobalMethods
import com.example.mypractical.utils.LogM
import com.google.gson.Gson
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val application: MyApp,
    private val repository: TopicRepository,
    private val globalMethods: GlobalMethods,
) : AndroidViewModel(application) {

    //Login observer related data
    private val _topicList: MutableLiveData<TopicModel> =
        MutableLiveData<TopicModel>()
    val topicList: LiveData<TopicModel>
        get() = _topicList

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    init {
        Coroutines.main {
            executeTopicList()
        }
    }

    suspend fun executeTopicList(): LiveData<TopicModel> {
        Coroutines.main {
//            if (globalMethods.isInternetAvailable(application)) {
//                try {
//                    _isViewLoading.postValue(true)
//                    val apiResponse = repository.callGetTopics()
//                    _isViewLoading.postValue(false)
//                    _topicList.postValue(apiResponse)
//                } catch (e: ApiExceptions) {
//                    _isViewLoading.postValue(false)
//                    _onMessageError.postValue(e.message)
//                } catch (e: NoInternetException) {
//                    _isViewLoading.postValue(false)
//                    _onMessageError.postValue(e.message)
//                }
//            } else {
//                val data = repository.getTopiList()
//                if (data != null) {
//                    val gson = Gson()
//                    val testModel: TopicModel = gson.fromJson(data.data, TopicModel::class.java)
//                    _topicList.postValue(testModel)
//                } else {
//                    _isViewLoading.postValue(false)
//                    _onMessageError.postValue(Constant.CHECK_INTERNET)
//                }
//            }
        }
        return _topicList
    }

    suspend fun insertTopic(data: TopicTable) {
        Coroutines.io {
            repository.insertTopic(data)
        }
    }
}