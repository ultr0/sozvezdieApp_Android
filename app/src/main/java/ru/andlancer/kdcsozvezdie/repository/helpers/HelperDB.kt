package ru.andlancer.kdcsozvezdie.repository.helpers

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.andlancer.kdcsozvezdie.data.db.*
import ru.andlancer.kdcsozvezdie.repository.converter.DateConverter
import ru.andlancer.kdcsozvezdie.repository.dao.*

@Database(entities = [User::class, Settings::class, Profile::class, Journal::class, Water::class], version = 1)
abstract class HelperDB: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun settingsDao(): SettingsDao
    abstract fun profileDao(): ProfileDao
    abstract fun waterDao(): WaterDao
    abstract fun journalDao(): JournalDao

    companion object {
        @Volatile
        private var databseInstance: HelperDB? = null

        fun getDatabasenIstance(mContext: Context): HelperDB =
            databseInstance ?: synchronized(this) {
                databseInstance ?: buildDatabaseInstance(mContext).also {
                    databseInstance = it
                }
            }

        private fun buildDatabaseInstance(mContext: Context) =
            Room.databaseBuilder(mContext, HelperDB::class.java, "SpaceFit")
                .fallbackToDestructiveMigration()
                .build()

    }
}