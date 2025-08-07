package com.example.booktour.data.repository

import com.example.booktour.data.dao.FavoritesDAO
import com.example.booktourdemo.models.Favorite

class FavoritesRepositoryImpl(private val dao: FavoritesDAO) {

    suspend fun themTourYeuThich(favorite: Favorite): Boolean {
        return dao.themTourYeuThich(favorite)
    }

    suspend fun xoaTourYeuThich(id: String): Boolean {
        return dao.xoaTourYeuThich(id)
    }

    suspend fun kiemTraTourYeuThich(id: String): Boolean {
        return dao.kiemTraTourYeuThich(id)
    }

    suspend fun layDanhSachTourYeuThich(userId: String): List<Favorite> {
        return dao.layDanhSachTourYeuThich(userId)
    }
}
