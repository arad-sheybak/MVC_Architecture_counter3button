package ir.aradsheybak.counter3button_mvc_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity(),Observer ,View.OnClickListener{
    var myModel: CountModel? = null
    var Button1: Button? = null
    var Button2: Button? = null
    var Button3: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // creating relationship between the
        // observable Model and the
        // observer Activity
        myModel = CountModel()
        myModel!!.addObserver(this)

        Button1 = findViewById(R.id.btn_one)
        Button2 = findViewById(R.id.btn_two)
        Button3 = findViewById(R.id.btn_three)


        Button1?.setOnClickListener(this)
        Button2?.setOnClickListener(this)
        Button3?.setOnClickListener(this)
    }

    override fun update(p0: Observable?, p1: Any?) {
        Button1!!.text = "Count: " + myModel!!.getValueAtIndex(0)
        Button2!!.text = "Count: " + myModel!!.getValueAtIndex(1)
        Button3!!.text = "Count: " + myModel!!.getValueAtIndex(2)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.btn_one ->  myModel?.setValueAtIndex(0)
                R.id.btn_two -> myModel?.setValueAtIndex(1)
                R.id.btn_three -> myModel?.setValueAtIndex(2)
            }
        }
    }
}