package com.bhavanawagh.nailtheinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bhavanawagh.nailtheinterview.api.QuestionsApi
import com.bhavanawagh.nailtheinterview.screens.CategoryScreen
import com.bhavanawagh.nailtheinterview.screens.QuestionsScreen
import com.bhavanawagh.nailtheinterview.ui.theme.NailTheInterviewTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var questionsApi: QuestionsApi


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NailTheInterviewTheme {

                Scaffold(topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = Color.White),
                        title = { Text(text = "Nail The Interview",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,) },
                    )
                }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }
            }
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "category") {

            composable(route = "category") {
                CategoryScreen(onClick = {
                    navController.navigate("questions/${it}")
                })
            }

            composable(route = "questions/{category}", arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })) {
                QuestionsScreen()
            }
        }
    }
}

