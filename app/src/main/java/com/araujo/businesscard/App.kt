package com.araujo.businesscard

import android.app.Application
import com.araujo.businesscard.data.AppDatabase
import com.araujo.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}