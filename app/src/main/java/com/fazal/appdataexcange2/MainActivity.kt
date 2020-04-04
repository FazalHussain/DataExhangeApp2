package com.fazal.appdataexcange2

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun LoadData(view: View) {

        val packageName = "com.fazal.appdataexchange1";
        val applicationInfo: ApplicationInfo = packageManager.getApplicationInfo(packageName,
            PackageManager.GET_META_DATA)
        val fullPath = applicationInfo.dataDir + "/files/faz.txt"
        Log.d("full_path", fullPath)
        readFile(fullPath)
    }

    private fun readFile(fullPath: String) {
        var fileInputStream: FileInputStream? = null
        try {
            fileInputStream = FileInputStream(File(fullPath))
            val inputString = fileInputStream.bufferedReader().use { it.readText() }
            txt.text = inputString
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
