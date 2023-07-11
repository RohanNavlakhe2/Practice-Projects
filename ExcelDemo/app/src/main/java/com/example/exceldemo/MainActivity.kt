package com.example.exceldemo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var file: File
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermissions()

        System.setProperty(
            "org.apache.poi.javax.xml.stream.XMLInputFactory",
            "com.fasterxml.aalto.stax.InputFactoryImpl"
        )
        System.setProperty(
            "org.apache.poi.javax.xml.stream.XMLOutputFactory",
            "com.fasterxml.aalto.stax.OutputFactoryImpl"
        )
        System.setProperty(
            "org.apache.poi.javax.xml.stream.XMLEventFactory",
            "com.fasterxml.aalto.stax.EventFactoryImpl"
        )

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener { fileChooser() }
        val writeBtn = findViewById<Button>(R.id.write_btn)
        writeBtn.setOnClickListener {
            writeExcelFile()
            readXlsxFile(openFileInput("Test-Excel.xlsx"))
        }
    }

    fun fileChooser() {
        val mimeTypes = arrayOf(
            "application/vnd.ms-excel",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        )
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            intent.type = if (mimeTypes.size == 1) mimeTypes[0] else "*/*"
            if (mimeTypes.isNotEmpty()) {
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            }
        } else {
            var mimeTypesStr = ""
            for (mimeType in mimeTypes) {
                mimeTypesStr += "$mimeType|"
            }
            intent.type = mimeTypesStr.substring(0, mimeTypesStr.length - 1)
        }
        startActivityForResult(Intent.createChooser(intent, "ChooseFile"), 10)
    }

    fun readXlsxFile(inputStream: InputStream) {
        var data = ""
        try {
            //val inputStream = assets.open("temp2.xls")


            // Create a POI File System object
            //val myFileSystem = POIFSFileSystem(FileInputStream(file))
            val workbook = WorkbookFactory.create(inputStream)
            val sheet = workbook.getSheetAt(0)
            val rowIter = sheet.rowIterator()

            while (rowIter.hasNext()) {
                data += "\n"
                val row = rowIter.next()
                val cellIter = row.cellIterator()
                while (cellIter.hasNext()) {
                    val cell = cellIter.next()
                    data += "$cell -> "
                }
            }

            Log.d("ExcelData", "Data: $data")


        } catch (e: Exception) {
            Log.d("MainAc", "Ex: ${e.message}")
        }

    }

    fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this, arrayOf<String>
                (
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ), 10
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //createNewFile()
    }

    fun createNewFile(): OutputStream? {
        var outputStream: OutputStream? = null
        try {
            //getExternalFilesDir("MyFolder3")
            val rootPath = Environment.getExternalStorageDirectory()
                .absolutePath + "/Excel Data/"
            val root = File(rootPath)
            if (!root.exists()) {
                root.mkdirs()
            }
            val f = File(rootPath + "${"New Excel"} ${UUID.randomUUID()}.xlsx")
            if (f.exists()) {
                f.delete()
            }
            f.createNewFile()
            file = f
            Log.d("ExcelData", "New File: ${f.absolutePath}")
            outputStream = FileOutputStream(f)
            /*out.flush()
            out.close()*/
        } catch (e: java.lang.Exception) {
            Log.d("ExcelData", "Exception while creating File: ${e.message}")
            e.printStackTrace()
        }
        return outputStream
    }

    fun writeExcelFile() {
        val workbook: XSSFWorkbook = XSSFWorkbook()
        try {
            val sheet: Sheet = workbook.createSheet("Sheet1")
            val row: Row = sheet.createRow(0)
            for (i in 0..15) {
                val cell: Cell = row.createCell(i)
                cell.setCellValue("$i")
            }
            sheet.isPrintGridlines = true
            //val outputStream: OutputStream = openFileOutput("Test-Excel.xlsx", Context.MODE_PRIVATE)
            val outputStream: OutputStream? = createNewFile()
            try {
                workbook.write(outputStream)
                Log.d("ExcelData", "File Path: ${file.absolutePath}")
            } finally {
                outputStream?.close()
            }

        } catch (e: Exception) {
            Log.d("ExcelData", "Exception while writing excel file: ${e.message}")
        } finally {
            workbook.close()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            Log.d("MainAc", "Result Ok")
            if (requestCode == 10) {
                Log.d("MainAc", "Request ok")
                if (data != null) {
                    val uri = data.data
                    Log.d("MainAc", "Data Not Null $uri")
                    var inputStream: InputStream? = null
                    if (uri != null)
                        inputStream = contentResolver.openInputStream(uri)
                    if (inputStream != null)
                        readXlsxFile(inputStream)
                    else
                        Toast.makeText(this, "File Not Found", Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("MainAc", "Data Null")
                }
            }
        } else {
            Log.d("MainAc", "Result Not Ok")
        }
    }
}