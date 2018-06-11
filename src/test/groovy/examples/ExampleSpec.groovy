package examples

import spock.lang.Specification

class ExampleSpec extends Specification {
    def "Example test"() {
        given: "x is set to 1"
        def x = 1

        expect: "x to equal 1"
        x == 1
    }
}
