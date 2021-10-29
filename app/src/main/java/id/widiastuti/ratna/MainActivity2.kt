package id.widiastuti.ratna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import id.widiastuti.ratna.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }
    }
/**
 * Calculates the tip based on the user input.
 */
private fun calculateTip() {
    val stringInTextField = binding.costOfServiceEditText.text.toString()
    val cost = stringInTextField.toDoubleOrNull()
    if (cost == null || cost == 0.0) {
        displayTip(0.0)
        return
    }
    val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
        R.id.option_twenty_percent -> 0.20
        R.id.option_eighteen_percent -> 0.18
        else -> 0.15
    }
    var tip = tipPercentage * cost
    val roundUp = binding.roundUpSwitch.isChecked
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    displayTip(tip)
}
private fun displayTip(tip: Double) {
    val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
    binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
}
private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
    if (keyCode == KeyEvent.KEYCODE_ENTER) {
        // Hide the keyboard
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        return true
    }
    return false
}

}