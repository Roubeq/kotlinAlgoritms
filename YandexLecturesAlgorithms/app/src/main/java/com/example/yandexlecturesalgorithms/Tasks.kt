package com.example.yandexlecturesalgorithms

class FirstLecture {
    fun maxCountSymbolInLineBad(line: String) {
        var ans = ""
        var ansCnt = 0
        for (i in line.indices) {
            var nowCnt = 0
            for (j in line.indices) {
                if (line[i] == line[j]) { //это плохой способ, потому что o(N^2)
                    nowCnt++
                }
            }
            if (nowCnt > ansCnt) {
                ans = line[i].toString()
                ansCnt = nowCnt
            }
        }
        println(ans)
    }

    fun maxCountSymbolInLineGood(line: String) {
        var symbol = ""
        var count = 0
        val setLine = line.toSet()
        for (i in setLine) {
            var nowCount = 0
            for (j in line.indices) {
                if (i == line[j]) { // o(N*K)
                    nowCount++
                }
            }
            if (nowCount > count) {
                symbol = i.toString()
                count = nowCount
            }
        }
        println(symbol)
        println(count)
    }

    fun maxCountSymbolInLineVeryGood(line: String) {
        val frequencyMap = mutableMapOf<Char, Int>()
        var maxSymbol = line[0]
        var maxCount = 0

        for (char in line) {
            frequencyMap[char] = frequencyMap.getOrDefault(char, 0) + 1 // o(N)
            println(frequencyMap)
            if (frequencyMap[char]!! > maxCount) {
                maxSymbol = char
                maxCount = frequencyMap[char]!!
            }
        }
        println(maxSymbol)
        println(maxCount)
    }

    fun sumSequence(line: String) {
        var seqSum = 0 //но если строка пустая то выведет 0, а у нас такого числа нет, надо обработать этот случай
        val listNumbers = line.map { it.digitToInt() }
            for (i in listNumbers) {
                seqSum += i
            }
        println(seqSum)
    }

    fun maxSequence(line: String) {
        val mapNumbers = line.map { it.digitToInt() }
        var maxSequnce = 0
        for (i in mapNumbers) {
            if (i > maxSequnce) {
                maxSequnce = i
            }
        }
        println(maxSequnce)
    }
}

fun main() {
    val firstLecture = FirstLecture()
    val line = readlnOrNull() ?: ""
    //firstLectureBad.maxCountSymbolInLineBad(line)
    //firstLecture.maxCountSymbolInLineGood(line)
    //firstLecture.maxCountSymbolInLineVeryGood(line)
    //firstLecture.sumSequence(line)
    //firstLecture.maxSequence(line)
}