package com.gcode.imaker.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.gcode.imaker.network.Repository

class StudentActivityViewModel:ViewModel() {
    private val stuNo = MutableLiveData<String>()

    val searchResult = Transformations.switchMap(stuNo){Object->
        Repository.searchCheckStatus(Object)
    }

    fun searchCheckStatus(stuNo:String){
        this.stuNo.postValue(stuNo)
    }
}