package cf.fibane.bettermentalmaths

class Game (private val difficulty: Int) {

    var scoreOK = 0
    var scoreKO = 0

    fun getNextComputation(): Calculation {
        val calc = Calculation()
        for(i in 0..difficulty){
            calc.addNumber(getRandomNumber())
        }
        for(i in 0 until difficulty){
            calc.addSign(getSign())
        }
        return calc
    }

    fun getRandomNumber(): Int {
        var ret = 0;
        ret = Math.ceil(Math.random() * 100).toInt();
        return ret;
    }

    fun getSign(): Sign {
        if(Math.random() > 0.5){
            return Sign.PLUS
        }
        return Sign.MINUS
    }

}