package cf.fibane.bettermentalmaths

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView3.text = (progress + 1).toString()
            }
        })

        button.text = "Go !"
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, ComputationActivity::class.java)
            intent.putExtra("Difficulty",seekBar.progress)
            startActivity(intent)
        }
    }
}
