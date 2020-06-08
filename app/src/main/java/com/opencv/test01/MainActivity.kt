package com.opencv.test01

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc

class MainActivity : AppCompatActivity() {
    private var image: ImageView? = null
    private var button: Button? = null
    private var bitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initOpenCV()
        initView()
    }

    private fun initView() {
        image = findViewById<ImageView>(R.id.image)
        button = findViewById<Button>(R.id.button)
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.test)
        image?.setImageBitmap(bitmap)
        button?.setOnClickListener(View.OnClickListener {
            doJob(it)
        })
    }

    private fun initOpenCV() {
        //加载OpenCV动态库
        OpenCVLoader.initDebug()
        /*OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION,
            applicationContext,object:LoaderCallbackInterface{
            override fun onPackageInstall(operation: Int, callback: InstallCallbackInterface?) {
                Log.d("MainActivity","onPackageInstall ->$operation")
            }

            override fun onManagerConnected(status: Int) {
                Log.d("MainActivity","onManagerConnected ->$status")
            }
        })*/
    }

    private fun doJob(view: View) {
        var rgbMat = Mat()
        var grayMat = Mat()
        var srcBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.test)
        var grayBitmap =
            Bitmap.createBitmap(srcBitmap.width, srcBitmap.height, Bitmap.Config.RGB_565)
        Utils.bitmapToMat(srcBitmap, rgbMat);//把Bitmap转为Mat.
        Imgproc.cvtColor(rgbMat, grayMat, Imgproc.COLOR_RGB2GRAY);//把rgb格式的mat转为gray的mat
        Utils.matToBitmap(grayMat, grayBitmap); //把gray的mat转为Bitmap
        image?.setImageBitmap(grayBitmap);
    }
}
