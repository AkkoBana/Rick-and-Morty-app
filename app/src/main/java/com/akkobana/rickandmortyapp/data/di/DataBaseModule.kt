package com.akkobana.rickandmortyapp.data.di

import android.content.Context
import androidx.room.Room
import com.akkobana.rickandmortyapp.data.db.AppDatabase
import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.db.DataBaseRepositoryImpl
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharactersDao
import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharactersDao
import com.akkobana.rickandmortyapp.domain.dbusecases.deleteall.DeleteAllLikedDislikedCharactersUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.deleteall.DeleteAllLikedDislikedCharactersUseCaseImpl
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.deletelikedcharacter.DeleteFavouriteCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.deletelikedcharacter.DeleteFavouriteCharacterUseCaseImpl
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getalllikedcharacters.GetAllLikedCharactersUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getalllikedcharacters.GetAllLikedCharactersUseCaseImpl
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharacters.GetDislikedCharactersUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getlikedcharecter.GetLikedCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getlikedcharecter.GetLikedCharacterUseCaseImpl
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.savelikedcharacter.SaveLikedCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.savelikedcharacter.SaveLikedCharacterUseCaseImpl
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.deletedislikedcharacter.DeleteDislikedCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.deletedislikedcharacter.DeleteDislikedCharacterUseCaseImpl
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharacters.GetDislikedCharactersUseCaseImpl
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharecterbyid.GetDislikedCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharecterbyid.GetDislikedCharacterUseCaseImpl
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.savedislikedcharacter.SaveDislikedCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.savedislikedcharacter.SaveDislikedCharacterUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    fun provideSaveLikedCharacterUseCase(dataBaseRepository: DataBaseRepository): SaveLikedCharacterUseCase =
        SaveLikedCharacterUseCaseImpl(dataBaseRepository)

    @Provides
    fun provideGetLikedCharacterUseCase(dataBaseRepository: DataBaseRepository): GetLikedCharacterUseCase =
        GetLikedCharacterUseCaseImpl(dataBaseRepository)

    @Provides
    fun provideDeleteLikedCharacterUseCase(dataBaseRepository: DataBaseRepository): DeleteFavouriteCharacterUseCase =
        DeleteFavouriteCharacterUseCaseImpl(dataBaseRepository)

    @Provides
    fun provideGetLikedCharactersUseCase(dataBaseRepository: DataBaseRepository): GetAllLikedCharactersUseCase =
        GetAllLikedCharactersUseCaseImpl(dataBaseRepository)

    @Provides
    fun provideGetDislikedCharactersUseCase(dataBaseRepository: DataBaseRepository): GetDislikedCharactersUseCase =
        GetDislikedCharactersUseCaseImpl(dataBaseRepository)

    @Provides
    fun provideSaveDislikedCharacterUseCase(dataBaseRepository: DataBaseRepository): SaveDislikedCharacterUseCase =
        SaveDislikedCharacterUseCaseImpl(dataBaseRepository)

    @Provides
    fun provideDeleteDislikedCharacterUseCase(dataBaseRepository: DataBaseRepository): DeleteDislikedCharacterUseCase =
        DeleteDislikedCharacterUseCaseImpl(dataBaseRepository)

    @Provides
    fun provideGetDislikedCharacterUseCase(dataBaseRepository: DataBaseRepository): GetDislikedCharacterUseCase =
        GetDislikedCharacterUseCaseImpl(dataBaseRepository)

    @Provides
    fun provideDeleteAllLikedDislikedCharactersUseCase(dataBaseRepository: DataBaseRepository): DeleteAllLikedDislikedCharactersUseCase =
        DeleteAllLikedDislikedCharactersUseCaseImpl(dataBaseRepository)


    @Provides
    fun provideDataBaseRepository(
        favoriteCharactersDao: LikedCharactersDao,
        dislikedCharactersDao: DislikedCharactersDao
    ): DataBaseRepository =
        DataBaseRepositoryImpl(favoriteCharactersDao, dislikedCharactersDao)

    @Provides
    fun provideFavouriteCharactersDao(appDatabase: AppDatabase): LikedCharactersDao {
        return appDatabase.getLikedCharactersDao()
    }
    @Provides
    fun provideLeastLikedCharactersDao(appDatabase: AppDatabase): DislikedCharactersDao {
        return appDatabase.getDislikedCharactersDao()
    }

    @Provides
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
            .build()
    }

}