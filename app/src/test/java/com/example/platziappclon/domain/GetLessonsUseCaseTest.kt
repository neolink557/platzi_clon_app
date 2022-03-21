package com.example.platziappclon.domain

import com.example.platziappclon.core.extensions.isNull
import com.example.platziappclon.data.Repository.LessonsRepository
import com.example.platziappclon.data.Repository.PathsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetLessonsUseCaseTest{

    @RelaxedMockK
    private lateinit var repository: LessonsRepository

    lateinit var getLessonsUseCase:GetLessonsUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getLessonsUseCase = GetLessonsUseCase(repository)
    }

    @Test
    fun `when The Api Doesnt Return Anything Then Return an Empty List`() = runBlocking {
        //Given
        coEvery { repository.getAllLessons() } returns emptyList()

        //When
        val response = getLessonsUseCase()

        //Then
        coVerify(exactly = 1) { repository.getAllLessons() }
        assert(!response.isNull())

    }

}