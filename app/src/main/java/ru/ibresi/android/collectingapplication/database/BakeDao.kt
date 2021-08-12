package ru.ibresi.android.collectingapplication.database

import androidx.room.Dao
import androidx.room.Query
import ru.ibresi.android.collectingapplication.model.Bake
import ru.ibresi.android.collectingapplication.model.Request
import ru.ibresi.android.collectingapplication.model.Shop
import ru.ibresi.android.collectingapplication.model.Units
import java.util.*

@Dao
interface BakeDao {
    @Query("SELECT * FROM bake")
    fun getBakes(): List<Bake>
    @Query("SELECT * FROM bake WHERE id=(:id)")
    fun getBake(id: UUID): Bake?

    @Query("SELECT * FROM shop")
    fun getShops(): List<Shop>
    @Query("SELECT * FROM shop WHERE id=(:id)")
    fun getShop(id: UUID): Shop?

    @Query("SELECT * FROM units")
    fun getUnits(): List<Units>
    @Query("SELECT * FROM units WHERE id=(:id)")
    fun getUnit(id: UUID): Units?

    @Query("SELECT * FROM request")
    fun getRequests(): List<Request>
    @Query("SELECT * FROM request WHERE shop_id=(:shop_id) AND bake_id=(:bake_id)")
    fun getRequest(shop_id: UUID, bake_id: UUID): Request?

}