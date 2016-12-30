import groovy.json.JsonBuilder

/**
 * Created by ka on 12/15/16.
 */
JsonBuilder jsonRoot = new JsonBuilder()

List bookInfo = [
        [isbn: "978-1935182443", title: "Groovy In Action 2nd Edition", author: "Dierk Koenig", price: "50.58"],
        [isbn: "978-1935182948", title: "Making Java Groovy", author: "Ken Kousen", price: "33.96"],
        [isbn: "978-1937785307", title: "Programming Groovy 2: Dynamic Productivity for the Java Developer", author: "Venkat Subramaniam", price: "28.92"],
]

// Goal output:
//{
//    "books": {
//        "book": {
//            "isbn": "978-1935182443",
//            "title": "Groovy In Action 2nd Edition",
//            "author": "Dierk Koenig",
//            "price": "50.58"
//        }
//        "book": {
//            "isbn": "978-1935182948",
//            "title": "Making Java Groovy",
//            "author": "Ken Kousen",
//            "price": "30.96"
//        }
//    }
//}

//jsonRoot {
//    books bookInfo.each { aBook ->
//        isbn aBook.isbn
//        title aBook.title
//        author aBook.author
//        price aBook.price
//    }
//}

jsonRoot {
    books bookInfo.collect { data ->
        data
    }
}

println "\nIn pretty print: "
println jsonRoot.toPrettyString()

