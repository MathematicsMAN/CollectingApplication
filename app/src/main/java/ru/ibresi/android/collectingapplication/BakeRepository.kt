package ru.ibresi.android.collectingapplication

import android.content.Context
import androidx.room.Room
import ru.ibresi.android.collectingapplication.database.BakeDatabase
import ru.ibresi.android.collectingapplication.model.Bake
import ru.ibresi.android.collectingapplication.model.Request
import ru.ibresi.android.collectingapplication.model.Shop
import ru.ibresi.android.collectingapplication.model.Units
import java.util.*

private const val DATABASE_NAME = "bake-database.db"

class BakeRepository private constructor(context: Context) {

    private val database: BakeDatabase = Room.databaseBuilder(
        context.applicationContext,
        BakeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val bakeDao = database.bakeDao()

    //Эти функции для обращения к БД, дублирующие ф-ции из bakeDao
    fun getBakes(): List<Bake> = bakeDao.getBakes()
    fun getBake(id: UUID): Bake? = bakeDao.getBake(id)
    fun getShops(): List<Shop> = bakeDao.getShops()
    fun getShop(id: UUID): Shop? = bakeDao.getShop(id)
    fun getUnits(): List<Units> = bakeDao.getUnits()
    fun getUnit(id: UUID): Units? = bakeDao.getUnit(id)
    fun getRequests(): List<Request> = bakeDao.getRequests()
    fun getRequest(shop_id: UUID, bake_id: UUID): Request? =
        bakeDao.getRequest(shop_id, bake_id)


    companion object {
        private var INSTANCE: BakeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = BakeRepository(context)
            }
        }

        fun get(): BakeRepository {
            return INSTANCE ?: throw IllegalStateException("BakeRepository must be initialized")
        }
    }
}