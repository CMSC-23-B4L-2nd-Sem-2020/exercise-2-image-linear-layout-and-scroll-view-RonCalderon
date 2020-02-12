/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * THIS IS AN EDITED DICEROLLER FROM GOOGLE TO COMPLY WITH A SCHOOL REQUIREMENT
 * FAIR USE APPLIES FOR USAGE OF DISNEY PROPERTY AND THANKS TO WIKIPEDIA FOR THE DETAILS
 */

package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.view.View

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates an image view with a dice
 * vector image with a random value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var diceText : TextView
    lateinit var topText : TextView
    //val descPrincess: TextView = findViewById(R.id.detail_text) as TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)
        val retryButton: Button = findViewById(R.id.retry_button)
        rollButton.setOnClickListener {
            rollDice()
            topText.text = "You are..."
            retryButton.setVisibility(View.VISIBLE);
            diceImage.setVisibility(View.VISIBLE);
            diceText.setVisibility(View.VISIBLE);
        }
        diceImage = findViewById(R.id.dice_image)
        diceText = findViewById(R.id.detail_text)
        topText = findViewById(R.id.textView)
        retryButton.setOnClickListener {
            retryButton.setVisibility(View.INVISIBLE);
            diceText.setVisibility(View.INVISIBLE);
            topText.text = "Which Disney Princess Are You?"
            diceImage.setImageResource(R.drawable.unnamed)
        }

    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollDice() {
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        val randomInt = (1..10).random()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.frogprincess
            2 -> R.drawable.elizabethwarren
            3 -> R.drawable.jasmine
            4 -> R.drawable.bella
            5 -> R.drawable.ariel
            6 -> R.drawable.blondeblueprincess
            7 -> R.drawable.snowwhite
            8 -> R.drawable.cinderella
            9 -> R.drawable.gooby
            else -> R.drawable.donaldtrump
        }
        val randomDetail = when (randomInt) {
            1 -> "Tiana is a main character who appears in Walt Disney Pictures' " +
                    "49th animated feature film The Princess and the Frog. Created by directors " +
                    "Ron Clements and John Musker and animated by Mark Henn, Tiana is voiced by " +
                    "Anika Noni Rose as an adult, while Elizabeth M. Dampier voices the character as a child."
            2 -> "Pocahontas was a Native American woman notable for her " +
                    "association with the colonial settlement at Jamestown, Virginia. " +
                    "She was the daughter of Powhatan, the paramount chief of a network of " +
                    "tributary tribes in the Tsenacommacah, encompassing the Tidewater region of Virginia."
            3 -> "Princess Jasmine is a fictional character who appears in Walt Disney Pictures' " +
                    "31st animated feature film Aladdin. Voiced by American actress Linda Larkin – " +
                    "with a singing voice provided by Filipina singer Lea Salonga – " +
                    "Jasmine is the spirited Princess of Agrabah, who has grown weary of her life of palace confinement."
            4 -> "Belle is a fictional character in Walt Disney Pictures' 30th animated feature film Beauty and the Beast. Originally voiced by American actress and singer Paige O'Hara, Belle is the non-conforming daughter of an inventor who yearns to abandon her predictable village life in return for adventure."
            5 -> "Ariel is a fictional character and the title character of Walt Disney Pictures' 28th animated film The Little Mermaid. She subsequently appears in the film's prequel television series, direct-to-video sequel The Little Mermaid II: Return to the Sea, and direct-to-video prequel The Little Mermaid: Ariel's Beginning."
            6 -> "A witch curses a princess that she will die on her 16th birthday, but a fairy alters the curse so that the princess will go into a deep sleep and can only be awakened by a prince's magical kiss."
            7 -> "Snow White is a fictional character and a main character from Walt Disney Productions' first animated feature film Snow White and the Seven Dwarfs. The character of Snow White was derived from a fairy tale known from many countries in Europe, the best-known version being the Bavarian one collected by the Brothers Grimm."
            8 -> "Cinderella is a fictional character who appears in Walt Disney Productions' 12th animated feature film Cinderella (1950) and its sequels Cinderella II: Dreams Come True (2002) and Cinderella III: A Twist in Time (2007). In the original film, Cinderella is voiced by American singer and actress Ilene Woods. For the sequels and subsequent film and television appearances, Woods was replaced by American actresses Jennifer Hale and Tami Tappan, who provide the character's speaking and singing voices respectively."
            9 -> "Goofy is the best princess. He is a funny animal cartoon character created in 1932 at Walt Disney Productions. Goofy is a tall, anthropomorphic dog who typically wears a turtle neck and vest, with pants, shoes, white gloves, and a tall hat originally designed as a rumpled fedora. Goofy is a close friend of Mickey Mouse and Donald Duck."
            else -> "Donald Fauntleroy Duck is not a princess... sorry! He is a cartoon character created in 1934 at Walt Disney Productions. Donald is an anthropomorphic white duck with a yellow-orange bill, legs, and feet. He typically wears a sailor shirt and cap with a bow tie."
        }
        diceImage.setImageResource(drawableResource)
        diceText.text = randomDetail
    }
}