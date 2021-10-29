package id.widiastuti.ratna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnIntentent : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnIntentent = findViewById(R.id.btnintent)

        btnIntentent.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnintent -> {
                val intenBiasa = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intenBiasa)
            }
        }
    }
}