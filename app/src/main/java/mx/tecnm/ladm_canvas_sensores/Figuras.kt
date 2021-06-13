package mx.tecnm.ladm_canvas_sensores

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint

class Figuras () {
    var x = 0f
    var y = 0f
    var t = 1
    var rd = 0f
    var wdt = 0f
    var ht = 0f
    var iX = 3
    var iY = 6
    var image : Bitmap ?= null

    constructor(x:Int, y:Int, rd:Int) : this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.rd = rd.toFloat()
    }

    constructor(x:Int, y:Int, wdt:Int, ht:Int) : this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.wdt = wdt.toFloat()
        this.ht= ht.toFloat()
        t = 2
    }

    constructor(bitmap: Bitmap, x:Int, y:Int):this(){
        image = bitmap
        this.x = x.toFloat()
        this.y = y.toFloat()
        t = 3
        wdt = image!!.width.toFloat()
        ht = image!!.height.toFloat()
    }

    fun paint(c: Canvas, p: Paint){
        when(t){
            1->{
                c.drawCircle(x,y,rd,p)
            }
            2->{
                c.drawRect(x,y,x+wdt,y+ht,p)
            }
            3->{
                c.drawBitmap(image!!,x,y,p)
            }
        }
    }

    fun movD(){
        if(x >= 900){
            x += 0
        }else {
            x += iX
        }
    }

    fun movI(){
        if(x <= -20){
            x -= 0
        }else {
            x -= iX
        }
    }

    fun changeImage(img: Bitmap){
        image = img
    }

}