package com.example.projectooo.ui.theme

import androidx.lifecycle.ViewModel

class FactsViewModel :ViewModel(){

    fun generateRandomFacts(selectedAnimal:String):String{
     return if (selectedAnimal=="Dog")
      {
          getDogFacts().random()
      }
        else
      {
          getCatFacts().random()
      }
    }

    fun getDogFacts():List<String>{
        val dogFacts= listOf(
            "Dogs have 'ruff' time understanding why squirrels don't want to play fetch.",
            "If dogs could text, their messages would mostly be 'food?','walk?', and 'belly rubs?'",
            "To a dog a car ride would be an ultimate roller coaster"
        )
        return dogFacts
    }

    fun getCatFacts():List<String>{
        val catFacts= listOf(
            "If cats had a motto, it would be 'nappinng in life.",
            "Cats consider cardboard boxes to be 5 star recommendations.",
            "Cats have a 'claw-some' sense of independence."
        )
        return catFacts
    }
}