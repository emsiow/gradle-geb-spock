package examples.geb

import geb.spock.GebSpec
import examples.geb.pages.SearchHomePage
import examples.geb.pages.SearchResultsPage

class ExamplePageSpec extends GebSpec {
    def config = new ConfigSlurper(System.getProperty("env")).parse(getClass().getResource('/Config.groovy').toURI().toURL())

    def "Doing an empty 'I'm Feeling Lucky' search takes you to Google Doodles"() {
        when: "Visiting Google.com"
        go config.searchUrl

        and: "user does an empty 'I'm Feeling Lucky' search"
        at SearchHomePage
        report "Viewing Search home page"
        searchButton.click()

        then: "show Google Doodles search results page"
        at SearchResultsPage
    }
}
