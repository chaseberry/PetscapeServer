package com.petscape.server.utils

import com.petscape.server.models.Boss
import com.petscape.server.models.Drop
import com.petscape.server.models.LiteBoss
import java.io.File
import java.io.InputStream
import java.nio.file.Paths

//val s: String = File.separator
const val s = "/"

object FileUtils {

    fun loadBoss(boss: Boss): InputStream {
        return load("bosses$s${boss.file}")
    }

    fun loadBoss(boss: LiteBoss): InputStream {
        return load("bosses$s${boss.file}")
    }

    fun loadDrop(drop: Drop): InputStream {
        return load("items$s${drop.file}")
    }

    fun load(name: String): InputStream {
        return try {
            javaClass.classLoader.getResourceAsStream(name)!!
        } catch (e: Exception) {
            val f = goUp(File(javaClass.getResource(s).path))

            Paths.get(f.path, "src${s}main${s}resources${s}", name).toUri().toURL().openStream()
        }
    }

    fun findBoss(boss: Boss): String? {
        return find("bosses${s}${boss.file}")
    }

    fun findDrop(drop: Drop): String? {
        return find("items${s}${drop.file}")
    }

    fun find(name: String): String? {
        return try {
            javaClass.classLoader.getResource(name)?.toString()!!
        } catch (e: Exception) {
            val f = goUp(File(javaClass.getResource(s).path))

            Paths.get(f.path, "src${s}main${s}resources${s}", name).toUri().toString()
        }
    }

    private fun goUp(file: File): File {
        if (file.isDirectory && file.listFiles().any { it.name == "src" }) {
            return file
        }

        return goUp(file.parentFile)
    }
}