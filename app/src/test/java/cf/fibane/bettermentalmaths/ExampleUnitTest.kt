package cf.fibane.bettermentalmaths

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun generatedNumberIsCorrect(){
        val game = Game(2)
        for(i in 1..15000) {
            val number = game.getRandomNumber()
            assertTrue(number > 0);
            assertTrue(number <= 100);
        }
    }

    @Test
    fun generatedSignDistribOK(){
        val game = Game(2)
        var nbTrue = 0
        var nbFalse = 0
        val nbLoop = 200000
        for(i in 1..nbLoop) {
            val number = game.getSign()
            if(number == Sign.PLUS){
                nbTrue++
            } else {
                nbFalse++
            }
        }
        assertTrue(Math.abs(nbFalse-nbTrue)<nbLoop/100)
    }


}
