package gaur.himanshu.august.mvvm.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gaur.himanshu.august.mvvm.local.NumberRepo
import gaur.himanshu.august.mvvm.remote.retrofit.BASE_URL
import gaur.himanshu.august.mvvm.remote.retrofit.NumberApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NumberModule {


    @Provides
    @Singleton
    fun provideRetrofitInterface(): NumberApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(NumberApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepo(numberApi: NumberApi): NumberRepo {
        return NumberRepo(numberApi)
    }


}