package ex

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class Ex100ServiceSpec extends Specification implements ServiceUnitTest<Ex100Service>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
