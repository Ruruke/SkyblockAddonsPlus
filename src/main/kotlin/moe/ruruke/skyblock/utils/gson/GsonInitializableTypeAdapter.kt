package moe.ruruke.skyblock.utils.gson

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException

/**
 * A type adapter that allows us to use the [GsonInitializable] interface.
 */
class GsonInitializableTypeAdapter : TypeAdapterFactory {
    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T> {
        val delegate = gson.getDelegateAdapter(this, type)

        return object : TypeAdapter<T>() {
            @Throws(IOException::class)
            override fun write(out: JsonWriter, value: T) {
                delegate.write(out, value)
            }

            @Throws(IOException::class)
            override fun read(`in`: JsonReader): T {
                val `object` = delegate.read(`in`)
                if (`object` is GsonInitializable) {
                    (`object` as GsonInitializable).gsonInit()
                }
                return `object`
            }
        }
    }
}
