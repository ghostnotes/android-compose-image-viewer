package co.ghostnotes.imageviewer.di

import co.ghostnotes.imageviewer.data.repository.ImageRepositoryImpl
import co.ghostnotes.imageviewer.data.usecase.GetImagesUseCaseImpl
import co.ghostnotes.imageviewer.domain.repository.ImageRepository
import co.ghostnotes.imageviewer.domain.usecase.GetImagesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindImageRepository(impl: ImageRepositoryImpl): ImageRepository

    @Binds
    abstract fun bindGetImageUseCase(impl: GetImagesUseCaseImpl): GetImagesUseCase

}