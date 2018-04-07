/*package com.example.timotheecorrado.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.e( "TAG", "Alerte ERROR")
    }
}
*/

package com.example.timotheecorrado.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)

        // Recupération du clic sur boutons et envoie à lauchInfo
        findViewById<Button>(R.id.federer).setOnClickListener(){v -> launchInfo("Federer")}
        findViewById<Button>(R.id.azarenka).setOnClickListener(){v -> launchInfo("Azarenka")}
        findViewById<Button>(R.id.hingis).setOnClickListener(){v -> launchInfo("Hingis")}
        findViewById<Button>(R.id.murray).setOnClickListener(){v -> launchInfo("Murray")}
        findViewById<Button>(R.id.nadal).setOnClickListener(){v -> launchInfo("Nadal")}
        findViewById<Button>(R.id.schiavone).setOnClickListener(){v -> launchInfo("Schiavone")}
        findViewById<Button>(R.id.serena).setOnClickListener(){v -> launchInfo("Serena")}
        findViewById<Button>(R.id.sharapova).setOnClickListener(){v -> launchInfo("Sharapova")}
        findViewById<Button>(R.id.tsonga).setOnClickListener(){v -> launchInfo("Tsonga")}

    }

    private fun launchInfo(s: String)
    {
        val intent = Intent(this, InfoActivity::class.java)

        intent.putExtra("NAME", s)

        startActivity(intent)
    }
}
