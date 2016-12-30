/**
 * Created by ka on 12/13/16.
 */

import groovy.xml.MarkupBuilder

MarkupBuilder xmlRoot = new MarkupBuilder()
new File("./files").mkdirs()
MarkupBuilder htmlRoot = new MarkupBuilder(new FileWriter("files/myGeneratedHtml.html"))

List bookInfo = [
        [isbn: "978-1935182443", title: "Groovy In Action 2nd Edition", author: "Dierk Koenig", price: "50.58"],
        [isbn: "978-1935182948", title: "Making Java Groovy", author: "Ken Kousen", price: "33.96"],
        [isbn: "978-1937785307", title: "Programming Groovy 2: Dynamic Productivity for the Java Developer", author: "Venkat Subramaniam", price: "28.92"],
]

//<books>
//    <book isbn="">
//        <title></title>
//        <author></author>
//        <price></price>
//    </book>
//</books>

xmlRoot.books {
    bookInfo.each { aBook ->
        book (isbn: aBook.isbn) {
            title aBook.title
            author aBook.author
            price aBook.price
        }
    }
}
println '\n\nTo .html file:'
htmlRoot.html {
    head {}
    body {
        table {
            bookInfo.each { aBook ->
                tr(isbn: aBook.isbn) {
                    td aBook.title
                    td aBook.author
                    td aBook.price
                }
            }
        }
    }
}
