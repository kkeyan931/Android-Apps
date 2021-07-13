package com.example.dicegame

import android.media.AudioManager
import android.media.MediaParser
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private fun rollDice(){

        val imageView : ImageView = findViewById(R.id.imageView)

        val diceNum = (1..6).random()

        val image = when(diceNum){

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        imageView.animate().rotationBy(1800F).setDuration(1000)
        val mediaPlayer : MediaPlayer = MediaPlayer.create(this,R.raw.dice_sound)
        mediaPlayer.start()
        imageView.setImageResource(image)

        imageView.contentDescription = image.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)

        button.setOnClickListener {
            rollDice()
        }
    }
}