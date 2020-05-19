package com.petscape.server.health

import com.codahale.metrics.health.HealthCheck
import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BOSSES
import com.petscape.server.models.Boss
import com.petscape.server.utils.FileUtils
import java.io.FileNotFoundException

class ResourcesHealthCheck(private val db: MongoDatabase) : HealthCheck() {

    override fun check(): Result {
        val bosses = db.getCollection(COLLECTION_BOSSES, Boss::class.java)

        for (boss in bosses.find()) {
            try {
                FileUtils.loadBoss(boss)
            } catch (e: FileNotFoundException) {
                return Result.unhealthy("File not found for ${boss.name}")
            }

            for (drop in boss.drops) {
                try {
                    FileUtils.loadDrop(drop)
                } catch (e: FileNotFoundException) {
                    return Result.unhealthy("File not found for ${drop.item}")
                }
            }
        }

        return Result.healthy()
    }
}