package serdar.oz.coinkeeper.database;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class DatabaseInitalizer {

    private static final String TAG = DatabaseInitalizer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Favorites addFavorites(final AppDatabase db, Favorites favorites) {
        db.favoritesDAO().insertAll(favorites);
        return favorites;
    }

    private static void populateWithTestData(AppDatabase db) {
        Favorites favorites = new Favorites();
        favorites.setPrice("Ajay");
        favorites.setCoinId("Saini");
        favorites.setDate(25);
        addFavorites(db, favorites);

        List<Favorites> userList = db.favoritesDAO().getAll();
        Log.d(DatabaseInitalizer.TAG, "Rows Count: " + userList.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}