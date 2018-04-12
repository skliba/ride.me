package co.skliba.rideme.data.network

import co.skliba.rideme.data.models.RideData
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST
    fun sendRideData(@Query("json") value: String = "1", @Body body: RideData)
}