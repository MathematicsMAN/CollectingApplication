package ru.ibresi.android.collectingapplication

import android.app.Application

class CollectingBakeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        BakeRepository.initialize(this)
    }
}