package ex

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class Ex100Spec extends Specification implements DomainUnitTest<Ex100> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
