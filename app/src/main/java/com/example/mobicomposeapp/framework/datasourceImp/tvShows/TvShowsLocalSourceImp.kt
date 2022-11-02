package com.example.mobicomposeapp.framework.datasourceImp.tvShows

import com.example.data.dao.TvShowDao
import com.example.data.tvShows.TvShowsLocalSource
import com.example.domain.model.TvShow
import kotlinx.coroutines.flow.Flow


class TvShowsLocalSourceImp(private val tvShowDao: TvShowDao): TvShowsLocalSource {
    override fun getTvShowsFromDB(tvShowId: Int): Flow<TvShow> = tvShowDao.getTvShow(tvShowId)
}

//class TvShowsLocalSourceImp (
//    private val dao: TvShowDao
//) : TvShowsLocalSource {

    //    override suspend fun save(t: List<TvShow>) {
//        t.forEach{
//            dao.insertTvShow(it.ToEntity())
//        }
//    }
//
//    override suspend fun load(): List<TvShow> {
//        return   dao.getAllTvShows().map{it.toDomain()}
//    }
//
//    override suspend fun clear() {
//        dao.deleteTvShows()
//    }





//fun TvShowEntity.toDomain() = TvShow(
//    poster = poster,
//    name = name,
//    rating = rating
//)
//
//fun TvShow.ToEntity() = TvShowEntity(
//    poster = poster,
//    name = name,
//    rating = rating
//)
//
//
