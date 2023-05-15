package eu.rvlander.swarmmeleeandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import eu.rvlander.swarm_melee.utils.Point

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var point = Point(1,2)

        Log.v("Test", "" + point.x)
    }
}