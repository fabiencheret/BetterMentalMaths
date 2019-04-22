package cf.fibane.bettermentalmaths

import java.io.Serializable

class Game (private val difficulty: Int) : Serializable {

    var scoreOK = 0
    var scoreKO = 0
    var calcList = ArrayList<Calculation>()

    fun getRound(): Int = scoreKO + scoreOK

    fun getNextComputation(): Calculation {
        val calc = Calculation()
        for(i in 0..difficulty){
            calc.addNumber(getRandomNumber())
        }
        for(i in 0 until difficulty){
            calc.addSign(getSign())
        }
        calcList.add(calc)
        return calc
    }

    fun getCurrentComputation() : Calculation = calcList.last()

    fun getRandomNumber(): Int {
        val ret: Int = Math.ceil(Math.random() * 100).toInt();
        return ret;
    }

    fun getSign(): Sign {
        if(Math.random() > 0.5){
            return Sign.PLUS
        }
        return Sign.MINUS
    }

}