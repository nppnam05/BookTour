package com.example.booktour.data.dao
import com.example.booktourdemo.models.Favorite

interface FavoritesDAO {

    suspend fun themTourYeuThich(favorite: Favorite): Boolean

    suspend fun xoaTourYeuThich(id: String): Boolean

    suspend fun kiemTraTourYeuThich(id: String): Boolean

    suspend fun layDanhSachTourYeuThich(userId: String): List<Favorite>
}

