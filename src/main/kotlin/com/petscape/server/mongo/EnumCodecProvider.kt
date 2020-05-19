package com.petscape.server.mongo

import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext
import org.bson.codecs.configuration.CodecProvider
import org.bson.codecs.configuration.CodecRegistry

class EnumCodecProvider : CodecProvider {

    val codec = EnumCodec()

    override fun <T : Any?> get(`class`: Class<T>, registry: CodecRegistry): Codec<T>? {
        return when {
            `class`.isEnum -> codec as? Codec<T>
            else -> null
        }
    }

    class EnumCodec : Codec<Enum<*>> {

        override fun getEncoderClass(): Class<Enum<*>> {
            return Enum::class.java
        }

        override fun decode(p0: BsonReader, p1: DecoderContext): Enum<*> {
            println(p0.currentBsonType)
            println(p0.currentName)
            throw NotImplementedError()
        }

        override fun encode(writer: BsonWriter, id: Enum<*>, context: EncoderContext) {
            writer.writeString(id.name)
        }

    }

}