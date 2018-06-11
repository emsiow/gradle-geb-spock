package examples.geb.pages

import geb.Page

class SearchHomePage extends Page {
    static at = { title == "Google" }

    static content = {
        searchButton(to: SearchResultsPage) { $("input", value: "I'm Feeling Lucky") }
    }
}
