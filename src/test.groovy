import groovy.json.*

List dataList = [
        ["greeting":"hi there", b:4],
        [a:43, b:3, c:32]
]
builder = new JsonBuilder()
builder {
    items dataList.each { data ->
        return {
            my_new_key ''
            data.each {key, value ->
                "$key" value
            }
        }
    }
}
println builder.toPrettyString()
