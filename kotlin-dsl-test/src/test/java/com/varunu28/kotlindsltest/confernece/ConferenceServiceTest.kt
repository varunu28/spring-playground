package com.varunu28.kotlindsltest.confernece

import com.varunu28.kotlindsltest.conference.Conference
import com.varunu28.kotlindsltest.conference.ConferenceNotFoundException
import com.varunu28.kotlindsltest.conference.ConferenceService
import com.varunu28.kotlindsltest.conference.CreateConferenceDto
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.util.*

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class ConferenceServiceTest @Autowired constructor(private val conferenceService: ConferenceService) {

    @Test
    @Order(1)
    fun `should throw exception for non existing conference`() {
        shouldThrow<ConferenceNotFoundException> { conferenceService.getConference(UUID.randomUUID()) }
    }

    @Test
    @Order(2)
    fun `should create and fetch conference`() {
        val conferenceId = conferenceService.addConference(createServiceRequest())

        conferenceId shouldNotBeNull {}

        val conference = conferenceService.getConference(conferenceId)
        conference shouldNotBeNull {}
        conference.name shouldBe "test name"
        conference.description shouldBe "test conference"
        conference.startDate shouldNotBeNull {}
        conference.endDate shouldNotBeNull {}
    }

    @Test
    @Order(3)
    fun `should list all created conferences`() {
        val conferences = conferenceService.listAllConferences()

        conferences shouldNotBeNull {}
        conferences shouldHaveSize 1
        conferences.first().apply {
            name shouldBe "test name"
            description shouldBe "test conference"
            startDate shouldNotBeNull {}
            endDate shouldNotBeNull {}
        }

        // Same test with power assert
        assert(
            conferences.size == 1 &&
                    conferences.first() is Conference &&
                    conferences.first().name == "test name" &&
                    conferences.first().description == "test conference" &&
                    conferences.first().startDate != null &&
                    conferences.first().endDate != null
        )
    }

    // Test data builders with named arguments & default values to simplify test data setup
    fun createServiceRequest(
        name: String = "test name",
        description: String = "test conference",
        startDate: LocalDate = LocalDate.now(),
        endDate: LocalDate = LocalDate.now()
    ): CreateConferenceDto {
        return CreateConferenceDto(name, description, startDate, endDate)
    }
}