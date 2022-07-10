package com.pupu.project

import android.content.Context
import kotlinx.coroutines.*

class KotlinMain {
    fun main(){
        runBlocking {
            val job=GlobalScope.launch{
                println("ppp")
                val res=requestLayout();
                println(res)
                println("ttt")
                withContext(Dispatchers.IO){

                }

            }
            job.cancel()
            Thread.sleep(2000)
        }
        GlobalScope.launch {

        }

        println("结束了")
    }

    private suspend fun requestLayout(): String {

        println("ooooo")
        delay(100);
        println("delay 结束")
        return "test"
    }
}