package com.irfanirawansukirman.cleanarchmono.ui.main.view

import android.content.Intent
import androidx.core.net.toUri
import com.irfanirawansukirman.abstraction.base.*
import com.irfanirawansukirman.abstraction.common.ext.*
import com.irfanirawansukirman.cleanarchmono.R
import com.irfanirawansukirman.cleanarchmono.ui.main.presentation.MainVM
import com.irfanirawansukirman.data.network.model.MoviesResult
import com.irfanirawansukirman.domain.model.response.MovieInfo
import kotlinx.android.synthetic.main.main_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel: MainVM by viewModel()

    private lateinit var mainAdapter: MainAdapter

    override fun bindLayoutId() = R.layout.main_activity

    override fun setupViewListener() {

    }

    override fun onLoadObserver() {
        viewModel.uiState.subscribe(this, ::movieUiState)
    }

    override fun setupComponents() {
        mainAdapter = MainAdapter(this) { movie ->
            val url = "auth://auth/${movie?.originalTitle}".toUri()
            startActivity(Intent(Intent.ACTION_VIEW, url))
        }
    }

    private fun movieUiState(uiState: UiState<MovieInfo>) {
        when (uiState) {
            is Loading -> {
                progress.visible()
                btnMain.gone()
            }
            is Success -> {
                val data = uiState.data.movieList?.asListOfType<MoviesResult>()
                if (data != null) {
                    recyclerMain.visible()
                    progress.gone()
                    btnMain.gone()
                    setupMovieList(data)
                } else {
                    recyclerMain.gone()
                    progress.gone()
                    btnMain.visible()
                }
            }
            is Error -> {
                showToast(
                    this,
                    uiState.error.message ?: getString(R.string.message_error_not_found)
                )
                progress.gone()
                btnMain.visible()
            }
            is NoInternet -> {
                showToast(this, getString(R.string.message_error_connection))
                progress.gone()
                btnMain.visible()
            }
        }
    }

    private fun setupMovieList(data: List<MoviesResult>) {
        recyclerMain.apply {
            gridList()
            adapter = mainAdapter
        }

        mainAdapter.items = data
    }
}