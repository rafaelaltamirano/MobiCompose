package com.example.mobicomposeapp.framework.datasource.tvShows

import com.example.data.datasource.dao.TvShowDao
import com.example.data.datasource.entities.TvShowEntity
import com.example.data.datasource.repository.TvShowsLocalSource
import com.example.domain.model.TvShow
import javax.inject.Inject

class TvShowsLocalSourceImp @Inject constructor(
    private val dao: TvShowDao
) : TvShowsLocalSource {

    override suspend fun save(t: List<TvShow>) {
        t.forEach{
            dao.insertTvShow(it.ToEntity())
        }
    }

    override suspend fun load(): List<TvShow> {
        return   dao.getTvShows().map{it.toDomain()}
    }

    override suspend fun clear() {
        dao.deleteTvShows()
    }

}


fun TvShowEntity.toDomain() = TvShow(
    poster = poster,
    name = name,
    rating = rating
)

fun TvShow.ToEntity() = TvShowEntity(
    poster = poster,
    name = name,
    rating = rating
)


