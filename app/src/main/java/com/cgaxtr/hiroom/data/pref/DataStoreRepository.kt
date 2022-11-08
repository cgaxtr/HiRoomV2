package com.cgaxtr.hiroom.data.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

const val DATASTORE_NAME = "ON_BOARDING_PREF"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_NAME)

class DataStoreRepository @Inject constructor(private val context: Context) {

    companion object {
        val COMPLETED = booleanPreferencesKey("completed")
    }

    suspend fun saveOnboardingFinished(status: Boolean) {
        context.dataStore.edit { sharedPreferences ->
            sharedPreferences[COMPLETED] = status
        }
    }

    fun loadOnboardingFinished(): Flow<Boolean> {
        return context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[COMPLETED] ?: false
                onBoardingState
            }
    }
}
