package security

import grails.plugin.springsecurity.SpringSecurityService

class RequestmapController {

    SpringSecurityService springSecurityService

    def save() {
        println 10
        /*https://grails-plugins.github.io/grails-spring-security-core/4.0.x/index.html#getauthenticateduser*/
        println "lastName = "+ getAuthenticatedUser().lastName
        println "firstName = "+ getAuthenticatedUser().firstName
        def requestmapI = new RequestMap()
        requestmapI?.dateCreated = new Date()
        requestmapI?.manCreated = authenticatedUser.fullname
        requestmapI?.url = params?.requestmap?.url
        requestmapI?.version = 0
        requestmapI?.configAttribute = params?.requestmap?.configAttribute
        requestmapI?.httpMethod = params?.requestmap?.httpMethod
        println 17

        requestmapI.save()
        println 19
        springSecurityService.clearCachedRequestmaps()

        println 21

    }
}
