package cf.fibane.bettermentalmaths

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_computation.*

class ComputationActivity : AppCompatActivity() {

    var numberOfLoops = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computation)

        val difficulty = intent.getIntExtra("Difficulty",2)
        val game = Game(difficulty)



        val computation = game.getNextComputation()
        calculationText.text = computation.toString()
        var i = 0
        val countDownTimer = object: CountDownTimer(20000,100) {
            override fun onFinish() {
                progressBar.progress = 100;
                endStep(game,computation)
            }
            override fun onTick(millisUntilFinished: Long) {
                i++
                progressBar.progress = i*100/(20000/100)
            }
        }

        progressBar.progress = i
        countDownTimer.start()

        correctButton.setOnClickListener {
            endStep(game,computation)
        }
    }

    private fun endStep(game: Game, calculation: Calculation){
        processResult(game,calculation)
        displayCorrection(calculation)
        numberOfLoops--
        if(numberOfLoops > 0) {
            Handler().postDelayed({
                nextStep(game)
            }, 1000)
        }
    }

    private fun nextStep(game: Game){

    }

    private fun processResult(game: Game, calculation: Calculation){

        if(calculationText.text == calculation.getSolution().toString()){
            game.scoreOK++
        } else {
            game.scoreKO++
        }

    }

    private fun displayCorrection (calculation: Calculation) {
        calculationText.text = calculation.getSolution().toString()
        calculationText.setTextColor(Color.GREEN)
    }



}