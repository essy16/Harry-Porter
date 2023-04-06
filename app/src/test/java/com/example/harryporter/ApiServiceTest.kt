package com.example.harryporter

import com.example.harryporter.data.HarryItem
import com.example.harryporter.network.HarryApi
import com.example.harryporter.repo.MainRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

@RunWith(JUnit4::class)
class ApiServiceTest {
    @Mock
    private lateinit var harryApi: HarryApi
    private lateinit var repo: MainRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repo = MainRepository(harryApi)

    }

    @Test
    fun getCharacters_returnsCharacters() {
        runTest {
            val characterList = emptyList<HarryItem>()
            `when`(harryApi.getHarryCharacters())
                .thenReturn(Response.success(characterList))
            val responseList=repo.getHarryCharacters()
            assert(characterList.size==responseList.body()?.size)

        }




    }


}