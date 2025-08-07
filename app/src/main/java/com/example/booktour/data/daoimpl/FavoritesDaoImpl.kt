package com.example.booktour.data.daoimpl


import android.util.Log
import com.example.booktour.data.dao.FavoritesDAO
import com.example.booktourdemo.models.Favorite
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FavoritesDaoImpl(private val db: FirebaseFirestore) : FavoritesDAO {

    private val collection = db.collection("favorites")

    override suspend fun themTourYeuThich(favorite: Favorite): Boolean {
        return try {
            // Tạo document mới với ID tự động
            val docRef = collection.document()

            // Gán ID vừa tạo vào đối tượng
            favorite.id = docRef.id

            // Lưu vào Firestore
            docRef.set(favorite).await()
            true
        } catch (e: Exception) {
            false
        }
    }


    override suspend fun xoaTourYeuThich(id: String): Boolean {
        return try {
            collection.document(id).delete().await()
            true
        } catch (e: Exception) {
            Log.d("test","$e")
            false
        }
    }

    override suspend fun kiemTraTourYeuThich(id: String): Boolean {
        return try {
            val snapshot = collection.document(id).get().await()
            snapshot.exists()
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun layDanhSachTourYeuThich(userId: String): List<Favorite> {
        return try {
            val snapshot = collection
                .whereEqualTo("user_id", userId)
                .get()
                .await()
            snapshot.toObjects(Favorite::class.java)
        } catch (e: Exception) {
            Log.d("test","$e")
            emptyList()
        }
    }

}
