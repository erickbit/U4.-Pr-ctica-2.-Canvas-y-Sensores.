package mx.tecnm.ladm_canvas_sensores

import android.graphics.*
import android.view.MotionEvent
import android.view.View

class Lienzo(p: MainActivity) : View(p) {
    var puntero = p
    /*------------------------- Personaje -----------------------------------------------------*/
    var sonicD = BitmapFactory.decodeResource(resources, R.drawable.sonicderecha1) /*Derecha*/
    var sonicI = BitmapFactory.decodeResource(resources, R.drawable.sonicizquierda1) /*Izquierda*/
    var sonic = BitmapFactory.decodeResource(resources, R.drawable.sonic) /*Estatico*/
    var personaje = Figuras(sonic, 600 , 600)
    /*------------------------- Fondos -----------------------------------------------------*/
    var fondoDia = BitmapFactory.decodeResource(resources, R.drawable.fondodia1)/*Dia*/
    var fondoNoche = BitmapFactory.decodeResource(resources, R.drawable.fondonoche1)/*Noche*/
    var back = Figuras(fondoDia, 0, 0)/*Estatico*/

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        back.paint(canvas, paint)
        personaje.paint(canvas, paint)
    }

    /*------------------------- movimiento personajes -----------------------------------------------------*/
    fun movimiento(){
        fondos()
        if(puntero.cX < 0){
            personaje.changeImage(sonicD)
            personaje.movD()
        }
        if(puntero.cX > 0){
            personaje.changeImage(sonicI)
            personaje.movI()
        }
        invalidate()
    }
    /*------------------------- fondo cambio -----------------------------------------------------*/
    fun fondos(){
        if(puntero.c > 0){
            back.changeImage(fondoNoche)
        }else{
            back.changeImage(fondoDia)
        }
    }

}