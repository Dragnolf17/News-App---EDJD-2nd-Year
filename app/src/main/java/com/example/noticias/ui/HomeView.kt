package com.example.noticias.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.noticias.Screen
import com.example.noticias.ui.Themes.NoticiasTheme

@Composable
fun HomeView(modifier: Modifier = Modifier,
             navController: NavController = rememberNavController()) {

    val viewModel : HomeViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    HomeViewContent(modifier = modifier,
        uiState = uiState,
        navController = navController)

    LaunchedEffect(Unit) {
        viewModel.fetchArticles()
    }
}

@Composable
fun HomeViewContent(modifier: Modifier = Modifier,
                    uiState : ArticleSate,
                    navController: NavController = rememberNavController()){

    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center){
        if(uiState.isLoading){
            Text("Loading Articles")
        }
        else if (uiState.error != null) {
            Text(text = uiState.error)
        }
        else if (uiState.articles.isEmpty()) {
            Text(text = "No articles found")
        } else {
            LazyColumn(modifier = modifier) {
                itemsIndexed(
                    items = uiState.articles,
                ) { index, article ->
                    RowArticle(modifier = Modifier
                        .clickable {
                            navController.navigate(
                                Screen.ArticleDetail.route
                                    .replace("{articleUrl}", article.url ?: "")
                            )
                        },
                        article = article)
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    NoticiasTheme {
        HomeViewContent(uiState = ArticleSate())
    }
}