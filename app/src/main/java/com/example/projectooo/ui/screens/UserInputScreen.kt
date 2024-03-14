package com.example.projectooo.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import com.example.projectooo.R
import com.example.projectooo.data.UserDataUiEvents
import com.example.projectooo.ui.AnimalCard
import com.example.projectooo.ui.ButtonComponent
import com.example.projectooo.ui.TextComponent
import com.example.projectooo.ui.TextFieldComponent
import com.example.projectooo.ui.TopBar
import com.example.projectooo.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel,
                    showWelcomeScreen : (valuesPair:Pair<String,String>) -> Unit){
   Surface(
       modifier = Modifier.fillMaxSize()
   ) {
     Column(
         modifier = Modifier
             .fillMaxSize()
             .padding(18.dp)
     ) {
        TopBar("Hi There")

         TextComponent(
             textValue = "Let's learn about you",
             textSize = 24.sp
         )

         Spacer(modifier = Modifier.size(20.dp))
         TextComponent(
             textValue = "This app will prepare a detail page based on the input provided by you",
             textSize = 18.sp
         )

         Spacer(modifier = Modifier.size(60.dp))

         TextComponent(textValue = "Name", textSize = 18.sp)

         Spacer(modifier = Modifier.size(10.dp))

         TextFieldComponent(onTextChanged = {
             userInputViewModel.onEvent(
                 UserDataUiEvents.UserNameEntered(it)
             )
         })

         Spacer(modifier = Modifier.size(20.dp))

         TextComponent(textValue = "What do you like?", textSize = 18.sp)

         Spacer(modifier = Modifier.size(20.dp))

         Row (
             modifier = Modifier.fillMaxWidth()
         ){
             AnimalCard(image = R.drawable.cat, animalSelected = {
                  userInputViewModel.onEvent(
                      UserDataUiEvents.AnimalSelected(it)
                  )
             }, selected = userInputViewModel.uiState.value.animalSelected=="Cat")
             AnimalCard(image = R.drawable.dog, animalSelected = {
                  userInputViewModel.onEvent(
                      UserDataUiEvents.AnimalSelected(it)
                  )
             }, selected = userInputViewModel.uiState.value.animalSelected=="Dog")
         }

         Spacer(modifier = Modifier.weight(1f))

         if (userInputViewModel.isValidState()){
             ButtonComponent(
                 goToDetailsScreen = {
                    println("Welcome Here")
                     println("the values are ${userInputViewModel.uiState.value.nameEntered} and ${userInputViewModel.uiState.value.animalSelected}")
                     showWelcomeScreen(
                         Pair(
                             userInputViewModel.uiState.value.nameEntered,
                             userInputViewModel.uiState.value.animalSelected
                         )
                     )
                 }
             )
         }
     }
   }
}

@Composable
@Preview(showBackground = true)
fun UserInputScreenPreview(){
    //UserInputScreen(UserInputViewModel())
}