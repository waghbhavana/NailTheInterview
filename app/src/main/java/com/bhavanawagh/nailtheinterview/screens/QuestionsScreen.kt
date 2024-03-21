package com.bhavanawagh.nailtheinterview.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bhavanawagh.nailtheinterview.models.QuestionListItem
import com.bhavanawagh.nailtheinterview.R
import androidx.compose.runtime.State
import androidx.hilt.navigation.compose.hiltViewModel
import com.bhavanawagh.nailtheinterview.viewmodels.QuestionsViewModel

@Composable
fun QuestionsScreen(){

    val questionsViewModel : QuestionsViewModel = hiltViewModel()
    val questionList: State<List<QuestionListItem>> = questionsViewModel.questions.collectAsState()
    
    LazyColumn(content = {
       items(questionList.value){
           Log.d("QuestionsScreen","QuestionsScreen:  ${it.question}")
           println("QuestionsScreen:  ${it.question}")
           QuestionListItem(it)
       }
    })

}

@Composable
fun QuestionListItem(questionListItem: QuestionListItem){
    println("QuestionsScreen:  ${questionListItem.category}")
    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
          border = BorderStroke(1.dp, Color(R.color.light_blue)),
         content = {
             Column {
                 Text(text = questionListItem.question,
                      modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium)

                 Text(text = questionListItem.answer,
                     modifier = Modifier.padding(16.dp),
                     style = MaterialTheme.typography.bodySmall)
             }
         }
    
    )

}