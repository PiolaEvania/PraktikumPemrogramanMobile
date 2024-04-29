package com.example.modul1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceImage1 : ImageView = findViewById(R.id.imageView)
        val diceImage2 : ImageView = findViewById(R.id.imageView2)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        diceImage1.setImageResource(R.drawable.empty_dice)
        diceImage1.contentDescription = "Dice 1"

        diceImage2.setImageResource(R.drawable.empty_dice)
        diceImage2.contentDescription = "Dice 2"
    }

    private fun rollDice() {
        val dice1 = Dice(6).roll()
        val dice2 = Dice(6).roll()

        val diceImage1 : ImageView = findViewById(R.id.imageView)
        val diceImage2 : ImageView = findViewById(R.id.imageView2)

        val drawableResource1 = when (dice1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (dice2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource1)
        diceImage1.contentDescription = dice1.toString()

        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = dice2.toString()

        val message = if (dice1 == dice2) {
            "Selamat Anda dapat dadu double!"
        }
        else {
            "Anda belum beruntung!"
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}