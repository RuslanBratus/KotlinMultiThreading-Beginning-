package processor



/**
 * Class that will split text in to several parts.
 * Chunk size represents how many lines can be in single part (chunk) of the text.
 * Each part could not always contain the number of lines equal to chunk size.
 */
class LetterProcessor(private val chunkSize: Int = CHUNK_SIZE) {

    /**
     * Method split text into parts. The size of each part is defined by chunkSize from the constructor.
     * @param content text to split into parts
     * @return list of parts of the original text.
     */
    fun splitLetter(content: String) : List<String> {

        fun listToString(listTemp : List<String> ): String {
            var str : String = ""
            for ((index, value) in listTemp.withIndex()) {
                str += value
                if (index != listTemp.indices.last) {
                    str += System.lineSeparator()
                }
            }
            return str
        }


        val temp = mutableListOf<String>()

        content.lines().chunked(this.chunkSize).forEach {
            temp.add(listToString(it))
        }
        return temp

    }

    companion object {
        const val CHUNK_SIZE = 2
    }
}
