class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            val sjConverter = StrangeJapaneseConverter()
            //println(convert(args[0]))
            println(sjConverter.convert("怪しい日本語"))
        }
    }
}