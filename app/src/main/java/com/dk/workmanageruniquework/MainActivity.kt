package com.dk.workmanageruniquework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

/**
 * WorkManager 고유 작업
 * 중복 예약 문제를 해결하기 위함
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtBtn = findViewById<Button>(R.id.testBtn)
        txtBtn.setOnClickListener{
            val testWorkManager = OneTimeWorkRequestBuilder<TestWorkManager>().build()

//            기존 클릭 방식 (버튼 클릭 만큼 TestWorkmanager를 생성함)
//            WorkManager.getInstance(this).enqueue(testWorkManager)

//          ExistingWorkPolicy.KEEP - 중복실행 방지 / .REPLACE 기존 작업이 중지되고 새로 실행
            WorkManager.getInstance(this).enqueueUniqueWork("test", ExistingWorkPolicy.REPLACE, testWorkManager)
        }
    }
}