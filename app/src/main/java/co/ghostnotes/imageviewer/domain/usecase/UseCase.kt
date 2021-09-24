package co.ghostnotes.imageviewer.domain.usecase

interface UseCase<INPUT, OUTPUT> {
    suspend fun execute(input: INPUT): OUTPUT
}
