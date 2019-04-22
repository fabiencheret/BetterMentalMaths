package cf.fibane.bettermentalmaths

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_results.*
import java.lang.StringBuilder

class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val game : Game = intent.extras.getSerializable("GAME") as Game

        ratingBar.rating = game.scoreOK.toFloat()/2

        val builder = StringBuilder()
        for(i in 0 until game.calcList.size){
            builder.append(game.calcList[i].toString())
            builder.append(" = ")
            builder.append(game.calcList[i].getSolution())
            builder.append("\n\n")
        }

        textView5.text = builder.toString()
    }
}