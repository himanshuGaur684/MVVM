package gaur.himanshu.august.mvvm.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gaur.himanshu.august.mvvm.local.respone.NumberResponse
import gaur.himanshu.august.mvvm.util.Events
import gaur.himanshu.august.mvvm.util.Result
import gaur.himanshu.august.mvvm.util.Status
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(private val repo: NumberRepo) : ViewModel() {


    private val _fact = MutableLiveData<Events<Result<NumberResponse>>>()
    val fact: LiveData<Events<Result<NumberResponse>>> = _fact


    private val _history = MutableLiveData<List<NumberResponse>>()
    val history: LiveData<List<NumberResponse>> = _history

    fun getNumberFact(number: Int) = viewModelScope.launch {
        _fact.postValue(Events(Result(Status.LOADING, null, null)))
        _fact.postValue(Events(repo.getNumberFact(number)))

    }


    fun getAllData()=viewModelScope.launch {
        _history.postValue(repo.getAllData())
    }


}