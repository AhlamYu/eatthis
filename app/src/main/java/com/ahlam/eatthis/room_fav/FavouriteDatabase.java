//package com.ahlam.eatthis.room_fav;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@Database(entities = {Favourite.class}, version = 1, exportSchema = false)
//public abstract class FavouriteDatabase extends RoomDatabase {
//
//    abstract FavouriteDAO favouriteDAO();
//
//    private static volatile FavouriteDatabase INSTANCE;
//    private static final int NUMBER_OF_THREADS = 4;
//    static final ExecutorService databaseWriteExecutor =
//            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
//
//    static FavouriteDatabase getDatabase(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (FavouriteDatabase.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                                    FavouriteDatabase.class, "favourite_database")
//                            .build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//
//}
