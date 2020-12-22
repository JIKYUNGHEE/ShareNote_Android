import ch.halarious.core.HalDeserializer
import ch.halarious.core.HalExclusionStrategy
import ch.halarious.core.HalResource
import ch.halarious.core.HalSerializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.snc.sharenote.network.HALResponseBodyConverter
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

class HALConverterFactory private constructor(type: Class<*>) :
    Converter.Factory() {
    private val gson: Gson
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        return HALResponseBodyConverter<HalResource<*>>(gson)
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        return GsonConverterFactory.create()
            .requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

    companion object {
        fun create(type: Class<*>): HALConverterFactory {
            return HALConverterFactory(type)
        }
    }

    init {
        if (!HalResource::class.java.isAssignableFrom(type)) throw NullPointerException("Type should be a subclass of HalResource")
        val builder = GsonBuilder()
        builder.registerTypeAdapter(HalResource::class.java, HalSerializer())
        builder.registerTypeAdapter(HalResource::class.java, HalDeserializer(type))
        builder.setExclusionStrategies(HalExclusionStrategy())
        gson = builder.create()
    }
}