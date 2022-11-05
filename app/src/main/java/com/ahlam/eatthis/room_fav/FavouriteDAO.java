//package com.ahlam.eatthis.room_fav;
//
//import androidx.room.Dao;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//
//import java.util.List;
//
//@Dao
//public interface FavouriteDAO {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void inset(Favourite favourite);
//
//    @Query("DELETE FROM favourite_recipe")
//    void deleteAll();
//
//    @Query("SELECT * FROM favourite_recipe ORDER BY favourite ASC")
//    List<Favourite> getAlphabetizedWords();
//}
