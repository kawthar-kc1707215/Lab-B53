package cmps312.lab.coroutinesexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var job: Job
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //you have created a small worker that is not on the main thread
        startBtn.setOnClickListener {
            job = lifecycleScope.launch {
                val task1 = async { jump() }  //download all students
                val task2 = async { playDead() }  //to find the qatari student
                val task3 = async { run() } //  the student with highest gpa

                Log.d(TAG, "completed jumping ${task1.await()}")
                Log.d(TAG, "completed playDead ${task2.await()}")
                Log.d(TAG, "completed runnning ${task3.await()}")

            }
        }

        stopBtn.setOnClickListener {
            job.cancel()
        }
    }

    override fun onPause() {
        finish()
        super.onPause()
    }

    //they can change context
    suspend fun jump() = withContext(Dispatchers.IO) {
        repeat(1000) {
            val imgeId = resources.getIdentifier("jump${it % 12 + 1}", "drawable", packageName)
            withContext(Dispatchers.Main) {
                jumpImg.setImageResource(imgeId)
            }
            Log.d(TAG, "jump: ")
        }
    }

    suspend fun run() = withContext(Dispatchers.IO) {
        repeat(1000) {
            val imgeId = resources.getIdentifier("run${it % 8 + 1}", "drawable", packageName)
            //UI update
            withContext(Dispatchers.Main) {
                runImg.setImageResource(imgeId)
            }
//            delay(100)
            Log.d(TAG, "run: ")
        }
    }

    suspend fun playDead() = withContext(Dispatchers.Default) {
        repeat(1000) {
            val imgeId = resources.getIdentifier("dead${it % 8 + 1}", "drawable", packageName)
            //UI update
            withContext(Dispatchers.Main) {
                deadImg.setImageResource(imgeId)
            }
            Log.d(TAG, "playDead: ")
        }
    }
}


/*
 val imageID = resources.getIdentifier("nameOfImage", "drawable", packageName)
 */