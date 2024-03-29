package edu.mfvp.avengers.application.web.resources

import edu.mfvp.avengers.application.web.request.AvengerRequest
import edu.mfvp.avengers.application.web.response.AvengerResponse
import edu.mfvp.avengers.domain.gateway.AvengerGateway
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

private const val API_PATH = "/v1/api/avenger"
@RestController
@RequestMapping(API_PATH)
class AvengerResource(
    private val avengerGateway: AvengerGateway
) {
    @GetMapping
    fun getAvengers() = avengerGateway.getAvengers()
        .map { AvengerResponse.from(it) }
        .let { ResponseEntity.ok().body(it) }

    @GetMapping("/{id}/detail")
    fun gerAvengerDetails(@PathVariable id: Long) =
        avengerGateway.getDetail(id)?.let {
            ResponseEntity.ok().body(AvengerResponse.from(it))
        } ?: ResponseEntity.notFound().build<Void>()

    @PostMapping
    fun createAvenger(@Valid @RequestBody request: AvengerRequest) =
        request.toAvenger().run {
            avengerGateway.create(this)
        }.let {
            ResponseEntity.created(URI("$API_PATH/${it.id}")).body(AvengerResponse.from(it))
        }

    @PutMapping("/{id}")
    fun updateAvenger(@PathVariable id: Long, @Valid @RequestBody request: AvengerRequest) =
        avengerGateway.getDetail(id)?.let {
            request.toAvenger(id).apply {
                avengerGateway.update(this)
            }.let {
                ResponseEntity.noContent().build()
            }
        } ?: ResponseEntity.notFound().build<Void>()

    @DeleteMapping("/{id}")
    fun deleteAvenger(@PathVariable id: Long) =
        avengerGateway.delete(id).let {
            ResponseEntity.accepted().build<Void>()
        }
}