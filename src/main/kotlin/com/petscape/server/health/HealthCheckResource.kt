package com.petscape.server.health

import com.codahale.metrics.health.HealthCheck
import com.codahale.metrics.health.HealthCheckRegistry
import javax.annotation.security.PermitAll
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("status")
@Produces(MediaType.APPLICATION_JSON)
class HealthCheckResource(private val registry: HealthCheckRegistry) {

    @GET
    fun checkHealth(): Set<Map.Entry<String, HealthCheck.Result>> {
        return registry.runHealthChecks().entries
    }
}