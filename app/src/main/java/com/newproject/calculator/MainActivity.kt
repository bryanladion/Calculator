package com.newproject.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import soup.neumorphism.NeumorphButton
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException


lateinit var inputext: EditText
lateinit var resultext: EditText
var check = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonEqual=findViewById<NeumorphButton>(R.id.btnEqual)
        val buttonBackSpace=findViewById<NeumorphButton>(R.id.btnBack)
        val button0=findViewById<NeumorphButton>(R.id.btnZero)
        val button1=findViewById<NeumorphButton>(R.id.btnOne)
        val button2=findViewById<NeumorphButton>(R.id.btnTwo)
        val button3=findViewById<NeumorphButton>(R.id.btnThree)
        val button4=findViewById<NeumorphButton>(R.id.btnFour)
        val button5=findViewById<NeumorphButton>(R.id.btnFive)
        val button6=findViewById<NeumorphButton>(R.id.btnSix)
        val button7=findViewById<NeumorphButton>(R.id.btnSeven)
        val button8=findViewById<NeumorphButton>(R.id.btnEight)
        val button9=findViewById<NeumorphButton>(R.id.btnNine)
        val button00=findViewById<NeumorphButton>(R.id.btnDoubleZero)
        val buttonPercent=findViewById<NeumorphButton>(R.id.btnPercent)
        val buttonClear=findViewById<NeumorphButton>(R.id.btnClear)
        val buttonAdd=findViewById<NeumorphButton>(R.id.btnPlus)
        val buttonSub=findViewById<NeumorphButton>(R.id.btnMinus)
        val buttonMul=findViewById<NeumorphButton>(R.id.btnTimes)
        val buttonDiv=findViewById<NeumorphButton>(R.id.btnDivide)
        val buttonDot=findViewById<NeumorphButton>(R.id.btnDot)
        inputext=findViewById<EditText>(R.id.etInputNumber)
        resultext=findViewById<EditText>(R.id.etResult)

        inputext.movementMethod= ScrollingMovementMethod()
        inputext.setActivated(true)
        inputext.setPressed(true)

        var text:String


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