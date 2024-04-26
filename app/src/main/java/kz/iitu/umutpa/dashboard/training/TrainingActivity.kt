package kz.iitu.umutpa.dashboard.training

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kz.iitu.umutpa.R
import kz.iitu.umutpa.SignupActivity

class TrainingActivity : AppCompatActivity() {
    private lateinit var startquiz:Button
    private lateinit var bookmark: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training)
        startquiz=findViewById(R.id.start_quiz)
        bookmark=findViewById(R.id.bookmark)
        startquiz.setOnClickListener {
            startActivity(Intent(this, Quizcat::class.java))
            finish()
        }

    }
}