package kanazawa.programing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: CalculatorViewModel by viewModels()
        viewModel.result.observe(this, Observer<String> { stringResult -> result.setText(stringResult)})
        viewModel.newNumber.observe(this, Observer<String> { stringNumber -> newNumber.setText(stringNumber)})
        viewModel.operation.observe(this, Observer<String> { stringOperation -> operation.text = stringOperation})

        val listener = View.OnClickListener { v ->
            viewModel.digitPressed((v as Button).text.toString())
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            viewModel.operandPressed((v as Button).text.toString())
        }

        buttonEquals.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)

        buttonNeg.setOnClickListener {
            viewModel.negPressed()
        }
    }
}