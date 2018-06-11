package examples.soap

import spock.lang.Specification
import wslite.soap.SOAPClient

class ExampleSoapSpec extends Specification {
//    def proxy = System.getProperty("proxyUrl") ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("proxyUrl"), System.getProperty("proxyPort"))) : null

    def "Example SOAP call test"() {
        when: "Looking up the date of Mothers Day in 2011 in the US"
        def client = new SOAPClient("http://www.holidaywebservice.com/Holidays/US/Dates/USHolidayDates.asmx")
        def response = client.send(
//                proxy: proxy,
                SOAPAction: 'http://www.27seconds.com/Holidays/US/Dates/GetMothersDay') {
            body {
                GetMothersDay('xmlns': 'http://www.27seconds.com/Holidays/US/Dates/') {
                    year(2011)
                }
            }
        }

        then: "The date returned should be 8 May 2011"
        200 == response.httpResponse.statusCode
        "2011-05-08T00:00:00" == response.GetMothersDayResponse.GetMothersDayResult.text()
    }
}
