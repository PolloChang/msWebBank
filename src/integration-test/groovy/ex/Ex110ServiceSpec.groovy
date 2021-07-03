package ex

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Ex110ServiceSpec extends Specification {

    Ex110Service ex110Service
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ex110(...).save(flush: true, failOnError: true)
        //new Ex110(...).save(flush: true, failOnError: true)
        //Ex110 ex110 = new Ex110(...).save(flush: true, failOnError: true)
        //new Ex110(...).save(flush: true, failOnError: true)
        //new Ex110(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ex110.id
    }

    void "test get"() {
        setupData()

        expect:
        ex110Service.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ex110> ex110List = ex110Service.list(max: 2, offset: 2)

        then:
        ex110List.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ex110Service.count() == 5
    }

    void "test delete"() {
        Long ex110Id = setupData()

        expect:
        ex110Service.count() == 5

        when:
        ex110Service.delete(ex110Id)
        sessionFactory.currentSession.flush()

        then:
        ex110Service.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ex110 ex110 = new Ex110()
        ex110Service.save(ex110)

        then:
        ex110.id != null
    }
}
