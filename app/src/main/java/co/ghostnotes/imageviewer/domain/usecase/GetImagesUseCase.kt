package co.ghostnotes.imageviewer.domain.usecase

import co.ghostnotes.imageviewer.domain.model.Image

interface GetImagesUseCase : UseCase<Int, List<Image>>