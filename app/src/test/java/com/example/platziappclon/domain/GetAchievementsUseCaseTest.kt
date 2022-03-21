package com.example.platziappclon.domain

import com.example.platziappclon.core.extensions.isNull
import com.example.platziappclon.data.Repository.AchievementsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetAchievementsUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: AchievementsRepository

    lateinit var getAchievementsUseCase: GetAchievementsUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getAchievementsUseCase = GetAchievementsUseCase(repository)
    }

    @Test
    fun `when The Api Doesnt Return Anything Then Return an Empty List`() = runBlocking {
        //Given
        coEvery { repository.getAllAchievements() } returns emptyList()

        //When
        val response = getAchievementsUseCase()

        //Then
        coVerify(exactly = 1) { repository.getAllAchievements() }
        assert(!response.isNull())

    }

}