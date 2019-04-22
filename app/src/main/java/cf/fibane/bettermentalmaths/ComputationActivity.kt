package cf.fibane.bettermentalmaths

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_computation.*

class ComputationActivity : AppCompatActivity() {

    private val numberOfLoops = 10
    var resultCountDownTimer: CountDownTimer? = null
    var mainCountDownTimer: CountDownTimer? = null
    var progression: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computation)

        val difficulty = intent.getIntExtra("Difficulty",2)
        val game = Game(difficulty)

        val computation = game.getNextComputation()
        calculationText.text = computation.toString()


        mainCountDownTimer = object: CountDownTimer(20000,100) {
            override fun onFinish() {
                progression = 0
                progressBar.progress = 100;
                processSolution(game)
            }
            override fun onTick(millisUntilFinished: Long) {
                progression++
                progressBar.progress = progression*100/(20000/100)
            }
        }

        resultCountDownTimer = object: CountDownTimer(1000,1000){
            override fun onTick(millisUntilFinished: Long) {
                //shouldn't be called
            }

            override fun onFinish() {
                //go to next calculation / result page
                nextStep(game)
            }
        }

        progressBar.progress = progression
        (mainCountDownTimer as CountDownTimer).start()

        correctButton.setOnClickListener {
            progression = 0
            processSolution(game)
        }
    }

    private fun processSolution(game: Game){
        mainCountDownTimer?.cancel()
        //display solution for 1 sec, then go to next calculation
        processResult(game,game.getCurrentComputation())
        displayCorrection(game.getCurrentComputation())
        resultCountDownTimer?.start()
    }

    private fun nextStep(game: Game){
        editText.setText("", TextView.BufferType.EDITABLE)
        editText.setTextColor(Color.BLACK)
        if(game.getRound() == numberOfLoops){
            val intent = Intent(this@ComputationActivity, ResultsActivity::class.java)
            intent.putExtra("GAME",game)
            startActivity(intent)
        } else {
            val calc = game.getNextComputation()
            calculationText.text = calc.toString()

            mainCountDownTimer?.start()
        }
    }

    private fun processResult(game: Game, calculation: Calculation){

        if(calculationText.text == calculation.getSolution().toString()){
            game.scoreOK++
        } else {
            game.scoreKO++
        }

    }

    private fun displayCorrection (calculation: Calculation) {
        editText.setText(calculation.getSolution().toString(), TextView.BufferType.EDITABLE)
        editText.setTextColor(Color.GREEN)
    }



}