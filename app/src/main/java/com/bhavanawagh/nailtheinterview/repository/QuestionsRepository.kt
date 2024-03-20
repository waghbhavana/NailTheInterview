package com.bhavanawagh.nailtheinterview.repository

import androidx.compose.runtime.MutableState
import com.bhavanawagh.nailtheinterview.api.QuestionsApi
import com.bhavanawagh.nailtheinterview.models.QuestionListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class QuestionsRepository @Inject constructor(private val questionsApi: QuestionsApi) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _questions = MutableStateFlow<List<QuestionListItem>>(emptyList())
    val questionList : StateFlow<List<QuestionListItem>>
        get() = _questions

    suspend fun getCategories() {
        val response = questionsApi.getCategory()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getQuestionList( category : String){
        val response = questionsApi.getQuestions(category)
        if(response.isSuccessful && response.body()!= null){
            _questions.emit(response.body()!!)
        }
    }
}