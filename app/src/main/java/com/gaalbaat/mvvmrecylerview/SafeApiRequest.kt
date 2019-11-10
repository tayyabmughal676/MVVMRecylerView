package com.gaalbaat.mvvmrecylerview

import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest{


     suspend fun <T :Any > apiRequest(call : suspend () -> Response<T>) : T{

//         response
        val response = call.invoke()

//         check response successful
        if(response.isSuccessful){
            // return response body
            return response.body()!!
        }else{
//            return error
            throw ApiException(response.code().toString())
        }
    }
}

//Api exception class constructor message
class ApiException(message :String) : IOException(message)