package serdar.oz.coinkeeper.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface FavoritesDAO {

    @Query("SELECT * FROM favorites")
    List<Favorites> getAll();

    @Delete
    void delete(Favorites favorites);

    @Insert
    void insertAll(Favorites... favorites);

    @Update
    void update(Favorites task);

}
