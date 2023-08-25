package com.example.quotecomposeapp.presantation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quotecomposeapp.DataManager
import com.example.quotecomposeapp.data.models.Quote
import com.example.quotecomposeapp.presantation.screens.QuoteDetail
import com.example.quotecomposeapp.presantation.screens.QuoteListScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Pages.LISTING.screen){

        composable(route = Pages.LISTING.screen){
            QuoteListScreen {
                navController.currentBackStackEntry?.savedStateHandle?.apply {
                    set("quote", it)
                }
                navController.navigate(Pages.DETAILS.screen)
            }
        }

        composable(route = Pages.DETAILS.screen){
            QuoteDetail()
        }

    }

}

enum class Pages(val screen:String){
    LISTING("listing"),
    DETAILS("details")
}