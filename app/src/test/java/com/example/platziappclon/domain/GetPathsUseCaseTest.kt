package com.example.platziappclon.domain

import com.example.platziappclon.core.extensions.isNull
import com.example.platziappclon.data.Repository.PathsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPathsUseCaseTest{

    @RelaxedMockK
    private lateinit var repository: PathsRepository

    lateinit var getPathsUseCase:GetPathsUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getPathsUseCase = GetPathsUseCase(repository)
    }

    @Test
    fun `when The Api Doesnt Return Anything Then Return an Empty List`() = runBlocking {
        //Given
        coEvery { repository.getAllPaths() } returns emptyList()

        //When
        val response = getPathsUseCase()

        //Then
        coVerify(exactly = 1) { repository.getAllPaths() }
        assert(!response.isNull())

    }

}