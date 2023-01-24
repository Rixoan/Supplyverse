package com.example.test2.Services

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.app.JobIntentService
import com.example.test2.*
import com.example.test2.UI.img
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL



class DownloadService : JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        var progress = 0 //progress download/upload dimulai dari 0
        //Log.d("DownloadService","setelah var progress")
        var bitmap = processBitMap("https://image.cermati.com/q_70,w_1200,h_800,c_fit/a2tkiggmyjmuie1xxjdt")

        do {
            Thread.sleep(500)
            progress+=20
            //membuat intent untuk dikirimkan progress
            var intentfile = Intent(ACTION_DOWNLOAD)
            intentfile.putExtra(EXTRA_PROGRESS,progress)
            intentfile.putExtra(EXTRA_FINISH,false)
            //intentfile.putExtra(EXTRA_IMAGE,bitmap)
            img = bitmap

            if(progress>=100){
                intentfile.putExtra(EXTRA_FINISH,true)
            }
            //mengirimkan intent melalui broadcast
            sendBroadcast(intentfile)


        }while (progress<100)
        //Toast.makeText(this,"Mulai",Toast.LENGTH_SHORT).show()
        //test() // harus menggunakan runable ketika ingin menjalankan toast di onhandlework
        /*if(intent != null){
            try {
                for(i in 1..10){
                    Thread.sleep(1000)
                    Log.d("JobIntentService","Send = $i")
                }

            }catch (e:Exception){}
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()

        //Toast.makeText(this,"Upload selesai",Toast.LENGTH_SHORT).show()
    }
    //kode handler digunakan untuk menggunakan mainthread untuk dijalankan ?
    val handler : Handler = Handler(Looper.getMainLooper())
    fun test (){
        handler.post(Runnable {
            Toast.makeText(this,"Upload selesai",Toast.LENGTH_SHORT).show()

        })
    }
    private fun processBitMap(url: String): Bitmap? {
        return try {
            val url = URL(url)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input: InputStream = connection.inputStream
            val myBitmap = BitmapFactory.decodeStream(input)
            myBitmap
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    companion object{
        fun enqueuework(context :Context, intent: Intent){
            enqueueWork(context, DownloadService::class.java, JOB_ID_DOWNLOAD,intent)
        }
    }


}