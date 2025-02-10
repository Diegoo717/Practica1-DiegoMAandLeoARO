package com.example.marsphotos.fake

    class FakeNetworkMarsPhotosRepository : MarsPhotosRepository{
        override suspend fun getMarsPhotos(): List<MarsPhoto> {
            return FakeDataSource.photosList
        }
        @Test
        fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() =
            runTest {
                val marsViewModel = MarsViewModel(
                    marsPhotosRepository = FakeNetworkMarsPhotosRepository()
                )
                assertEquals(
                    MarsUiState.Success("Success: ${FakeDataSource.photosList.size} Mars " +
                            "photos retrieved"),
                    marsViewModel.marsUiState
                )
            }
    }
