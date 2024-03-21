package com.bhavanawagh.nailtheinterview.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhavanawagh.nailtheinterview.models.QuestionListItem
import com.bhavanawagh.nailtheinterview.repository.QuestionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionsRepository, private val saveStateHandle: SavedStateHandle) : ViewModel() {

    val questions : StateFlow<List<QuestionListItem>>
        get() = repository.questions

    init {
        viewModelScope.launch {
            val category = saveStateHandle.get<String>("category") ?: "Java"
            repository.getQuestionList(category)
        }
    }
}