package com.example.projectooo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.projectooo.data.UserDataUiEvents
import com.example.projectooo.ui.FactComposable
import com.example.projectooo.ui.TextComponent
import com.example.projectooo.ui.TextWithShadow
import com.example.projectooo.ui.TopBar
import com.example.projectooo.ui.theme.FactsViewModel

@Composable
fun WelcomeScreen(userName: String?, animalSelected: String?) {
    println("inside welcome screen")
    println("${userName} and ${animalSelected}")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("Welcome $userName")

            Spacer(modifier = Modifier.size(30.dp))

            TextComponent(
                textValue = "Thank You! for sharing your data",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            val finalText=if (animalSelected=="Cat") "You're a Cat Lover" else "You're a Dog Lover"

            TextWithShadow(value = finalText)

            Spacer(modifier = Modifier.size(20.dp))

            val factsViewModel:FactsViewModel= viewModel()
            FactComposable(
                value = factsViewModel.generateRandomFacts(animalSelected!!)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WelcomeScreenPreview(){
    WelcomeScreen("userName","animalSelected")
}