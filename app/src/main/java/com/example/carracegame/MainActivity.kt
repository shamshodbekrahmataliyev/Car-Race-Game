package com.example.carracegame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), GameTask {

    lateinit var rootLayout: LinearLayout
    lateinit var startBtn: Button
    lateinit var mGameView: GameView
    lateinit var score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)

        // O'yinni boshlash uchun tugma
        startBtn.setOnClickListener {
            startGame()
        }
    }

    private fun startGame() {
        // Yangi GameView yaratish
        mGameView = GameView(this, this)
        mGameView.setBackgroundResource(R.drawable.road)

        // GameView ni layoutga qo'shish
        rootLayout.addView(mGameView)

        // Start tugmasini va natijani yashirish
        startBtn.visibility = View.GONE
        score.visibility = View.GONE
    }

    private fun resetGame() {
        // GameView ni layoutdan olib tashlash
        rootLayout.removeView(mGameView)

        // O'yinni qayta boshlash
        startGame()
    }

    override fun closeGame(mScore: Int) {
        // Natijalarni ko'rsatish
        score.text = "Score: $mScore"

        // GameView ni layoutdan olib tashlash
        rootLayout.removeView(mGameView)

        // Start tugmasini va natijani ko'rsatish
        startBtn.visibility = View.VISIBLE
        score.visibility = View.VISIBLE

        // Start tugmasi bosilganda o'yinni qayta boshlash
        startBtn.setOnClickListener {
            resetGame()
        }
    }
}
