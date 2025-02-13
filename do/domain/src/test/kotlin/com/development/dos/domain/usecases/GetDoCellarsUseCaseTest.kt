package com.development.dos.domain.usecases

import com.development.core.domain.model.LatLng
import com.development.dos.domain.CellarRepository
import com.development.dos.domain.model.Cellar
import com.development.testing.coVerifyOnce
import io.kotest.matchers.result.shouldBeFailure
import io.kotest.matchers.result.shouldBeSuccess
import io.mockk.coEvery
import io.mockk.coJustRun
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetDoCellarsUseCaseTest {

    private lateinit var useCase: GetDoCellarsUseCase

    private val repository: CellarRepository = mockk()

    private val fakeCellarList = listOf(
        Cellar(0, "name", "description", emptyList(), "email", "phone", "website", LatLng(0.0, 0.0)),
        Cellar(1, "name", "description", emptyList(), "email", "phone", "website", LatLng(0.0, 0.0)),
        Cellar(2, "name", "description", emptyList(), "email", "phone", "website", LatLng(0.0, 0.0))
    )

    @BeforeEach
    fun setup() {
        useCase = GetDoCellarsUseCase(repository)
    }

    @Test
    fun `GIVEN existing do id WHEN invoke is called THEN repository getCellarListByDo returns success with list of cellars`() = runTest {
        val id = 0
        coEvery { repository.getCellarListByDo(id) } returns Result.success(fakeCellarList)

        val result = useCase(id)

        coVerifyOnce { repository.getCellarListByDo(id) }
        coVerifyOnce { repository.getCellarListByDo(any()) }
        result shouldBeSuccess fakeCellarList
    }

    @Test
    fun `GIVEN non existing do id WHEN invoke is called THEN repository getCellarListByDo returns failure with exception`() = runTest {
        val id = 0
        val error = Exception()
        coEvery { repository.getCellarListByDo(id) } returns Result.failure(error)

        val result = useCase(id)

        coVerifyOnce { repository.getCellarListByDo(id) }
        coVerifyOnce { repository.getCellarListByDo(any()) }
        result shouldBeFailure error
    }

}
