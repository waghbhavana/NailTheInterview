package com.bhavanawagh.nailtheinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NailTheInterviewTheme {
                App()
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

