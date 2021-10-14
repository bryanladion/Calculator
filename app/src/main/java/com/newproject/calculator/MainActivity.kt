package com.newproject.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

lateinit var button1: android.widget.Button
lateinit var button2: android.widget.Button
lateinit var button3: android.widget.Button
lateinit var button4: android.widget.Button
lateinit var button5: android.widget.Button
lateinit var button6: android.widget.Button
lateinit var button7: android.widget.Button
lateinit var button8: android.widget.Button
lateinit var button9: android.widget.Button
lateinit var button0: android.widget.Button
lateinit var button00: android.widget.Button
lateinit var buttonDot: android.widget.Button
lateinit var buttonAdd: android.widget.Button
lateinit var buttonSub: android.widget.Button
lateinit var buttonMul: android.widget.Button
lateinit var buttonDiv: android.widget.Button
lateinit var buttonEqual: android.widget.Button
lateinit var buttonPercent: android.widget.Button
lateinit var buttonClear: android.widget.Button
lateinit var buttonBackSpace: android.widget.Button

lateinit var inputext: EditText
lateinit var resultext: EditText
var check = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEqual=findViewById<Button>(R.id.btnEqual)
        buttonBackSpace=findViewById<Button>(R.id.btnBack)
        button0=findViewById<Button>(R.id.btnZero)
        button1=findViewById<Button>(R.id.btnOne)
        button2=findViewById<Button>(R.id.btnTwo)
        button3=findViewById<Button>(R.id.btnThree)
        button4=findViewById<Button>(R.id.btnFour)
        button5=findViewById<Button>(R.id.btnFive)
        button6=findViewById<Button>(R.id.btnSix)
        button7=findViewById<Button>(R.id.btnSeven)
        button8=findViewById<Button>(R.id.btnEight)
        button9=findViewById<Button>(R.id.btnNine)
        button00=findViewById<Button>(R.id.btnDoubleZero)
        buttonPercent=findViewById<Button>(R.id.btnPercent)
        buttonClear=findViewById<Button>(R.id.btnClear)
        buttonAdd=findViewById<Button>(R.id.btnPlus)
        buttonSub=findViewById<Button>(R.id.btnMinus)
        buttonMul=findViewById<Button>(R.id.btnTimes)
        buttonDiv=findViewById<Button>(R.id.btnDivide)
        buttonDot=findViewById<Button>(R.id.btnDot)
        inputext=findViewById<EditText>(R.id.etInputNumber)
        resultext=findViewById<EditText>(R.id.etResult)

        inputext.movementMethod= ScrollingMovementMethod()
        inputext.setActivated(true)
        inputext.setPressed(true)

        var text:String


        button0.setOnClickListener {
            text=inputext.text.toString()+"1"
            inputext.setText(text)

            result(text)

        }
        button0.setOnClickListener {
            text=inputext.text.toString()+"1"
            inputext.setText(text)

            result(text)

        }
        button0.setOnClickListener {
            text=inputext.text.toString()+"0"
            inputext.setText(text)

            result(text)

        }
        button1.setOnClickListener {
            text=inputext.text.toString()+"1"
            inputext.setText(text)

            result(text)

        }
        button2.setOnClickListener {
            text=inputext.text.toString()+"2"
            inputext.setText(text)

            result(text)

        }
        button3.setOnClickListener {
            text=inputext.text.toString()+"3"
            inputext.setText(text)

            result(text)

        }
        button4.setOnClickListener {
            text=inputext.text.toString()+"4"
            inputext.setText(text)

            result(text)

        }
        button5.setOnClickListener {
            text=inputext.text.toString()+"5"
            inputext.setText(text)

            result(text)

        }
        button6.setOnClickListener {
            text=inputext.text.toString()+"6"
            inputext.setText(text)

            result(text)

        }
        button7.setOnClickListener {
            text=inputext.text.toString()+"7"
            inputext.setText(text)

            result(text)

        }
        button8.setOnClickListener {
            text=inputext.text.toString()+"8"
            inputext.setText(text)

            result(text)

        }
        button9.setOnClickListener {
            text=inputext.text.toString()+"9"
            inputext.setText(text)

            result(text)

        }
        button00.setOnClickListener {
            text=inputext.text.toString()+"00"
            inputext.setText(text)

            result(text)

        }
        buttonDot.setOnClickListener {
            text=inputext.text.toString()+"."
            inputext.setText(text)

            result(text)

        }



        //operators
        buttonAdd.setOnClickListener {
            text =inputext.text.toString()+"+"
            inputext.setText(text)
            check=check+1
        }
        buttonSub.setOnClickListener {
            text =inputext.text.toString()+"-"
            inputext.setText(text)
            check=check+1
        }
        buttonDiv.setOnClickListener {
            text =inputext.text.toString()+"/"
            inputext.setText(text)
            check=check+1
        }
        buttonMul.setOnClickListener {
            text =inputext.text.toString()+"*"
            inputext.setText(text)
            check=check+1
        }
        buttonPercent.setOnClickListener {
            text =inputext.text.toString()+"%"
            inputext.setText(text)
            check=check+1
        }

        buttonEqual.setOnClickListener {
            text= inputext.text.toString()
            inputext.setText(null)

        }
        buttonClear.setOnClickListener{
            inputext.setText(null)
            resultext.setText(null)
        }
        var backspace:String?=null
        buttonBackSpace.setOnClickListener{
            if(inputext.text.length==1){
                inputext.setText(null)
                resultext.setText(null)
            }
            if(inputext.text.length>0){
                val stringBuilder: StringBuilder= StringBuilder(inputext.text)
                val find=inputext.text.toString()
                val find2 = find.length-1// temporary

                if(find2.equals("+")||find2.equals("-")||find2.equals("*")||find2.equals("/")){
                    check-=1
                }

                stringBuilder.deleteCharAt(inputext.text.length-1)
                backspace=stringBuilder.toString()
                inputext.setText(backspace)
                result(backspace!!)

            }
        }

    }

    private fun result(text: String) {
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try{
            val result: Any=engine.eval(text)
            var mainr = result.toString()
            if(check==0){
                resultext.setText(null)
            }
            else{
                resultext.setText(mainr)
            }

        }
        catch (e: ScriptException){
            Log.d("TAG", "ERROR")
        }

    }
}