//package com.ahlam.eatthis.room_fav;
//
//import android.app.Application;
//
//import androidx.lifecycle.LiveData;
//
//import java.util.List;
//
//public class FavouriteRepository {
//
//    private FavouriteDAO mfavouriteDao;
//    private LiveData<List<Favourite>> mAllFavourites;
//
//
//    FavouriteRepository(Application application) {
//        FavouriteDatabase db = FavouriteDatabase.getDatabase(application);
//        mfavouriteDao = db.favouriteDAO();
//        mAllFavourites = (LiveData<List<Favourite>>) mfavouriteDao.getAlphabetizedWords();
//    }
//
//    // Room executes all queries on a separate thread.
//    // Observed LiveData will notify the observer when the data has changed.
//    LiveData<List<Favourite>> getAllWords() {
//        return mAllFavourites;
//    }
//
//    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
//    // that you're not doing any long running operations on the main thread, blocking the UI.
//    void insert(Favourite favourite) {
//        FavouriteDatabase.databaseWriteExecutor.execute(() -> {
//            mfavouriteDao.inset(favourite);
//        });
//    }
//}
