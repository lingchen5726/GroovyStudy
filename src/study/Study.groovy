package study

class Study {

    def static square = {it*it}
    public static foo(n) {
        if(n == 1) {
            "Roshan"
        } else {
            "Dawrani"
        }
    }
    def static printSum = { a, b -> println a+b }
    def static myConst = 5
    def static incByConst = { num -> num + myConst }
    
    def printMapClosure = { key, value -> println key + "=" + value }
    static main(args) {
        println("Hello")
        println(square(9))
        println([1,2,3,4].collect(square))
        assert foo(1) == "Roshan"
        assert foo(2) == "Dawrani"
        printSum(5,7)
        println incByConst(10)
        
        def study = new Study()
        [ "Yue" : "Wu", "Mark" : "Williams", "sudha": "Kumari" ].each(study.printMapClosure)
        def fullString = ""
        def orderParts = ["BUY", 200, "Hot Dogs", "1"]
        orderParts.each {fullString += it + " "}
        println fullString
        println "potato" ==~ /potatoe?/
        println "motatoe" ==~ /potatoe?/
        def locationData = "Liverpool, England: 53d 25m 0s N 3d 0m 0s"
        def myRegularExpression = /([a-zA-Z]+),([a-zA-Z]+): ([0-9]+). ([0-9]+). ([0-9]+).([A-Z]) ([0-9]+). ([0-9]+). ([0-9]+)./
        def matcher = ( locationData =~ myRegularExpression )
        println matcher[0]
    }

}
