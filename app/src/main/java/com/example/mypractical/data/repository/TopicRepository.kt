package com.example.mypractical.data.repository

import com.example.mypractical.api.SafeAPIRequest
import com.example.mypractical.api.WebServiceInterface
import com.example.mypractical.data.db.dao.TopicDao
import com.example.mypractical.data.model.TopicModel
import com.example.mypractical.data.db.table.TopicTable
import javax.inject.Inject

class TopicRepository @Inject constructor(
    private val dao: TopicDao,
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {


//    suspend fun callGetTopics(): TopicModel {
//        return apiRequest {
//            webServiceInterface.callGetTopics()
//        }
//    }


//    suspend fun callVerifyOTP(mobile:String,otp: String): TopicModel {
//        return apiRequest {
//            webServiceInterface.callVerifyOTP(mobile,otp)
//        }
//    }

    suspend fun getTopiList(): TopicTable {
        val model = dao.getTopiList()
        return model
    }


    suspend fun insertTopic(data: TopicTable) : Long {
        return dao.insertTopic(data)
    }
//
//    suspend fun deleteCategory(model: CategoryModel) : Int {
//        return dao.deleteCategory(model)
//    }

//    suspend fun updateTaskStatus(model: TaskListData) {
//        taskListDao.updateTaskStatus(model)
//    }


}