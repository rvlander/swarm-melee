package eu.rvlander.swarmmeleeandroid

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import eu.rvlander.swarm_melee.core.engine.SimpleSimulationFactory
import eu.rvlander.swarm_melee.core.engine.Simulation
import eu.rvlander.swarm_melee.core.engine.WorldConfiguration
import eu.rvlander.swarm_melee.ui.core.WorldDrawer
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setFullScreen();

        super.onCreate(savedInstanceState)

        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)


        val configuration = WorldConfiguration(2, 1000, 600, 600, 3)
        val simulation = Simulation(SimpleSimulationFactory(), configuration)

        val worldDrawer = WorldDrawer(simulation.world)
        val drawingDevice = SurfaceViewDrawingDevice(this,worldDrawer)
        drawingDevice.initialize(configuration.width, configuration.height)


        val rootLayout = findViewById<View>(R.id.root) as ConstraintLayout
        val playControlsPanelMinimized = View(this)
        rootLayout?.addView(drawingDevice)


        /* val inputManager = AwtKeyListener()
        inputManager.setSimulationCommandReceiver(simulation)
        drawingDevice.addKeyListener(inputManager) */


        val executor = ScheduledThreadPoolExecutor(2)
        executor.scheduleAtFixedRate({
            // inputManager.poll()
            simulation.runStep()
        }, 0, 50, TimeUnit.MILLISECONDS)
        executor.scheduleAtFixedRate({ drawingDevice.invalidate() }, 0, 100, TimeUnit.MILLISECONDS)
    }

    private fun setFullScreen() {
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) actionBar.hide()

        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView) ?: return
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}