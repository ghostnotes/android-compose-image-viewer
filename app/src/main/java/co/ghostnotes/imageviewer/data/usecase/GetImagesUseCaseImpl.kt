package co.ghostnotes.imageviewer.data.usecase

import co.ghostnotes.imageviewer.domain.model.Image
import co.ghostnotes.imageviewer.domain.repository.ImageRepository
import co.ghostnotes.imageviewer.domain.usecase.GetImagesUseCase
import javax.inject.Inject

class GetImagesUseCaseImpl @Inject constructor(
    private val imageRepository: ImageRepository
) : GetImagesUseCase {
    override suspend fun execute(input: Int): List<Image> =
        imageRepository.getImages(input)
}