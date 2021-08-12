package ru.ibresi.android.collectingapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.ibresi.android.collectingapplication.model.Bake
import ru.ibresi.android.collectingapplication.model.Request
import ru.ibresi.android.collectingapplication.model.Shop
import ru.ibresi.android.collectingapplication.model.Units

@Database(entities = [Bake::class, Shop::class, Units::class, Request::class], version = 1)
@TypeConverters(BakeTypeConverters::class)
abstract class BakeDatabase : RoomDatabase() {
    abstract fun bakeDao(): BakeDao
}