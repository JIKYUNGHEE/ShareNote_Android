package com.snc.sharenote.network

import ch.halarious.core.HalResource
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.Closeable
import java.io.IOException
import java.nio.charset.Charset

internal class HALResponseBodyConverter<T : HalResource<*>?>(private val gson: Gson) :
    Converter<ResponseBody, T> {
    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T {
        val source = value.source()
        return try {
            val s = source.readString(Charset.forName("UTF-8"))
            gson.fromJson(s, HalResource::class.java) as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        } finally {
            closeQuietly(source)
        }
    }

    companion object {
        private fun closeQuietly(closeable: Closeable?) {
            if (closeable == null) return
            try {
                closeable.close()
            } catch (ignored: IOException) {
            }
        }
    }

}