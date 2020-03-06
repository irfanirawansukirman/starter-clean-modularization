package com.irfanirawansukirman.cleanarchmono.ui.main.presentation

import com.irfanirawansukirman.data.common.base.BaseVM
import com.irfanirawansukirman.abstraction.base.Error
import com.irfanirawansukirman.abstraction.base.NoInternet
import com.irfanirawansukirman.abstraction.base.Success
import com.irfanirawansukirman.cleanarchmono.ui.main.MainViewEffects
import com.irfanirawansukirman.domain.interaction.movies.MoviesUseCase
import com.irfanirawansukirman.domain.model.onFailure
import com.irfanirawansukirman.domain.model.onSuccess
import com.irfanirawansukirman.domain.model.response.MovieInfo

class MainVM(private val moviesUseCase: MoviesUseCase) : BaseVM<MovieInfo, MainViewEffects>() {

    init {
        getMovieList()
    }

    private fun getMovieList() = executeUseCase({
        moviesUseCase("")
            .onSuccess { _uiState.value =
                Success(it)
            }
            .onFailure { _uiState.value =
                Error(it.throwable)
            }
    }, {
        _uiState.value = NoInternet()
    })

}