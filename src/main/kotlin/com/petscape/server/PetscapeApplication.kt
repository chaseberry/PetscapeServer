package com.petscape.server

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.module.SimpleModule
import com.mongodb.MongoClient
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import com.petscape.server.api.*
import com.petscape.server.auth.PetscapeAuthenticator
import com.petscape.server.auth.PetscapeAuthorizer
import com.petscape.server.auth.User
import com.petscape.server.health.HealthCheckResource
import com.petscape.server.health.ResourcesHealthCheck
import com.petscape.server.models.Boss
import com.petscape.server.mongo.EnumCodecProvider
import io.dropwizard.Application
import io.dropwizard.auth.AuthDynamicFeature
import io.dropwizard.auth.basic.BasicCredentialAuthFilter
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import org.bson.codecs.Codec
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider
import org.bson.types.ObjectId
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.util.*


const val DB_PETSCAPE = "petscape_db"
const val COLLECTION_BOSSES = "bosses"
const val COLLECTION_BINGO_GAMES = "bingo_games"

@Throws(Exception::class)
fun main(args: Array<String>) {
    PetscapeApplication().run(*args)
}

class PetscapeApplication : Application<PetscapeConfiguration>() {

    private lateinit var logger: Logger
    private lateinit var database: MongoDatabase

    private val objectIdSerializer = object : JsonSerializer<ObjectId>() {
        override fun serialize(value: ObjectId, gen: JsonGenerator, serializers: SerializerProvider) {
            gen.writeString(value.toString())
        }

        override fun handledType(): Class<ObjectId> {
            return ObjectId::class.java
        }
    }

    private val dateSerializer = object : JsonSerializer<Date>() {

        override fun serialize(value: Date, gen: JsonGenerator, serializers: SerializerProvider) {
            gen.writeNumber(value.time / 1000) //Time in seconds
        }

        override fun handledType() = Date::class.java
    }

    override fun getName(): String {
        return "petscape-server"
    }

    override fun initialize(bootstrap: Bootstrap<PetscapeConfiguration?>) {
        logger = LoggerFactory.getLogger(javaClass.name)

        val pojoCodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        )

        val codecs = CodecRegistries.fromRegistries(
            MongoClient.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(EnumCodecProvider())
        )

        val settings = MongoClientSettings.builder().codecRegistry(codecs).build()

        val mongoClient = MongoClients.create(settings)
        database = mongoClient.getDatabase(DB_PETSCAPE).withCodecRegistry(pojoCodecRegistry)

        seedDb()
    }

    override fun run(configuration: PetscapeConfiguration, environment: Environment) {
        val auth = BasicCredentialAuthFilter.Builder<User>()
            .setAuthenticator(PetscapeAuthenticator(database, configuration))
            .setAuthorizer(PetscapeAuthorizer())
            .setRealm("Authentication")
            .buildAuthFilter()

        environment.healthChecks().register("resources", ResourcesHealthCheck(database))

        environment.jersey().register(AuthDynamicFeature(auth))
        environment.jersey().register(NewBingoGameResource(database))
        environment.jersey().register(NewCustomBingoGameResource(database))
        environment.jersey().register(AddBingoCardResource(database))
        environment.jersey().register(CompleteSquareResource(database))
        environment.jersey().register(UpdateNotesResource(database))
        environment.jersey().register(GetWinnersResource(database))
        environment.jersey().register(GetCardResource(database))
        environment.jersey().register(GetCardImageResource(database))
        environment.jersey().register(MemberResource(database))

        environment.jersey().register(HealthCheckResource(environment.healthChecks()))

        val serializersModule = SimpleModule("serializers", Version.unknownVersion())
            .addSerializer(objectIdSerializer).addSerializer(dateSerializer)

        environment.objectMapper.registerModule(serializersModule)
    }

    private fun seedDb() {
        val bossCollection = database.getCollection(COLLECTION_BOSSES, Boss::class.java)
        val file = File(javaClass.classLoader.getResource("initial_data.json")?.file ?: "")
        val bosses = ObjectMapper().readValue(file, object : TypeReference<List<Boss>>() {})

        bossCollection.drop()
        bossCollection.insertMany(bosses)
    }
}