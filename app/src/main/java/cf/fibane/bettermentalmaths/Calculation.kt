package cf.fibane.bettermentalmaths

class Calculation {

    private val numbers = mutableListOf<Int>()
    private val signs = mutableListOf<Sign>()
    private var solution = 0

    fun addNumber(number : Int){
        numbers.add(number)
    }

    fun addSign(sign:Sign){
        signs.add(sign)
    }

    override fun toString(): String {
        val sb = StringBuffer()
        sb.append(numbers[0])
        for (i in 1 until numbers.size){
            if(signs[i-1] == Sign.MINUS){
                sb.append(" - ")
            } else  {
                sb.append(" + ")
            }
            sb.append(numbers[i])
        }
        return sb.toString()
    }

    fun getSolution(): Int {
        var result = numbers[0]
        for (i in 1 until numbers.size){
            if(signs[i-1] == Sign.MINUS){
                result -= numbers[i]
            } else  {
                result += numbers[i]
            }
        }
        return result
    }

    fun compareInputToSolution(input: Int): Boolean{
        if(input == getSolution())
            return true
        return false;
    }


}