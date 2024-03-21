package com.bhavanawagh.nailtheinterview

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.bhavanawagh.nailtheinterview.api.QuestionsApi
import com.bhavanawagh.nailtheinterview.screens.CategoryScreen
import com.bhavanawagh.nailtheinterview.screens.QuestionsScreen
import com.bhavanawagh.nailtheinterview.ui.theme.NailTheInterviewTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

// First Commit
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var questionsApi: QuestionsApi
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NailTheInterviewTheme {
               // QuestionsScreen()
                CategoryScreen()

            }
        }

    }
}

