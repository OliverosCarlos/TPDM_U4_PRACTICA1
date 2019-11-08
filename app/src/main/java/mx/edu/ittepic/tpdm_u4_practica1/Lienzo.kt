package mx.edu.ittepic.tpdm_u4_practica1

import android.graphics.*
import android.view.View
import android.graphics.Shader
import android.graphics.LinearGradient
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class Lienzo(p:MainActivity): View(p){
//1080 x 2160
    val imagen = BitmapFactory.decodeResource(resources,R.drawable.moon)
    val sled = BitmapFactory.decodeResource(resources,R.drawable.sled)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)


    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        val p = Paint()

        val oval1 = RectF(-1400f,300f,1400f,1600f)
        val oval2 = RectF(1000f,270f,4000f,1630f)



        paint.shader = LinearGradient(
            0.0F, 0.0F,
            0.0F, 800f,
            Color.rgb(1,17,74),
            Color.rgb(18,70,255),
            Shader.TileMode.MIRROR
        )

        c.drawRect(0f,0f,2160f,1080f,paint)
        estrellas(p,c)
        //p tiene todos los metodos de estilización




        //INSERTAR LUNA===============================
        c.drawBitmap(imagen,1000f,100f,p)
        c.drawBitmap(sled,1500f,150f,p)


        //DIBUJAR COLINAS CON ARCOS ================================================================
        p.color = Color.rgb(112,224,255)
        c.drawArc(oval2,270f,-90f,true,p)
        p.color = Color.rgb(108,248,255)
        c.drawArc(oval1,270f,90f,true,p)


        arbol(300f,650f,p,c)
        arbol(1750f,500f,p,c)
        arbol(1000f,800f,p,c)
        arbol(2000f,800f,p,c)

        casa(100f,600f,p,c)
        casa(400f,700f,p,c)
        casa(1500f,500f,p,c)
        casa(1700f,650f,p,c)

        /*p.color = Color.MAGENTA
        p.textSize = 40f
        //canvas tiene los metodos de dibujo, pero estilizado tipo paint
        c.drawText("Carlos Moisés",100f,100f,p)



        p.color = Color.WHITE
        p.style = Paint.Style.STROKE
        p.strokeWidth = 20f
        c.drawCircle(150f,300f,150f,p)

        p.color = Color.MAGENTA
        c.drawRect(300f,500f,600f,650f,p)


        (0..10).forEach {
            p.color = Color.WHITE
            p.style = Paint.Style.STROKE
            c.drawCircle(150f+(it+10),300f-(it*10),150f-(5*it),p)
        }*/
    }
    fun arbol(x:Float,y:Float,p:Paint,c:Canvas){
        var oval4 = RectF(-70f,-50f,70f,0f)
        (0..20).forEach {

            //tronco
            p.color = Color.rgb(142,90,34)
            c.drawRect(x+it+0f,y+it+0f,x+it+40f,y+it+60f,p)

            //ramas
            oval4.set(x+it-70f,y+it-50f,x+it+140f,y+it+0f)
            p.color = Color.rgb(72,120,33)
            c.drawArc(oval4,0f,360f,true,p)
            //ramas 2
            oval4.set(x+it-50f,y+it-100f,x+it+120f,y+it+-50f)
            c.drawArc(oval4,0f,360f,true,p)
            //ramas 3
            oval4.set(x+it-30f,y+it-150f,x+it+100f,y+it+-100f)
            c.drawArc(oval4,0f,360f,true,p)
        }
        p.color = Color.rgb(173,90,34)
        c.drawRect(x+21f,y+21f,x+61f,y+81f,p)

        oval4.set(x-49f,y-29f,x+161f,y+21f)
        p.color = Color.rgb(72,171,33)
        c.drawArc(oval4,0f,360f,true,p)

        oval4.set(x-29f,y-79f,x+141f,y-29f)
        c.drawArc(oval4,0f,360f,true,p)

        oval4.set(x-9f,y-129f,x+121f,y-79f)
        c.drawArc(oval4,0f,360f,true,p)


    }

    fun casa(x:Float,y:Float,p:Paint,c:Canvas){

        var oval3 = RectF(0f,0f,200f,100f)
        p.color = Color.LTGRAY

        (0..49).forEach {

            //Estructura de la casa
            p.color = Color.LTGRAY
            c.drawRect(x+it+0f,y+it+0f,x+it+200f,y+it+100f,p)

            //techo de la casa
            oval3.set(x+it+0f,y+it-50f,x+it+200f,y+it+50f)
            //sombra techo rojo obscuro
            p.color = Color.rgb(174,0,0)
            c.drawArc(oval3,180f,180f,true,p)
        }

        oval3.set(x+50f,y+0f,x+250f,y+100f)
        p.color = Color.RED
        c.drawArc(oval3,180f,180f,true,p)

        p.color = Color.WHITE
        c.drawRect(x+50f,y+50f,x+250f,y+150f,p)

        p.color = Color.RED
        c.drawRect(x+125f,y+90f,x+175f,y+150f,p)

        p.color = Color.BLACK
        p.style = Paint.Style.STROKE
        p.strokeWidth = 4f
        c.drawRect(x+70f,y+60f,x+110f,y+90f,p)

        p.color = Color.rgb(174,0,0)
        c.drawRect(x+190f,y+60f,x+230f,y+90f,p)
        c.drawCircle(x+152f,y+21f,16f,p)

        p.style = Paint.Style.FILL


    }

    fun estrellas(p:Paint,c:Canvas){
        p.color = Color.WHITE
        (0..100).forEach {
            c.drawCircle((0..2000).random().toFloat(),(0..600).random().toFloat(),(1..5).random().toFloat(),p)
        }


    }
}