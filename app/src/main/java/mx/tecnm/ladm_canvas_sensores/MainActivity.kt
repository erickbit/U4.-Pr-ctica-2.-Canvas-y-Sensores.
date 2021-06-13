package mx.tecnm.ladm_canvas_sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager : SensorManager
    lateinit var s : SensorManager
    var lienzo: Lienzo ?= null
    /*---------------------------------- Coordenadas ------------------------------------*/
    var cX = 0.0
    var cY = 0.0
    var cZ = 0.0
    var c = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        setContentView(lienzo)
    /*----------------------------------Sensor manager-----------------------------------*/
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)

        HiloControl(this).start()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {

        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            cX = event.values[0].toDouble()
            cY = event.values[1].toDouble()
            cZ = event.values[2].toDouble()
        }

        if(event.sensor.type == Sensor.TYPE_PROXIMITY){
            if(event.values[0]>=5) {
                c = -1
            }
            if(event.values[0]<5) {
                c = 1
            }
        }

    }

}