package fr.killianmary.scenario_choice

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.scenario_list_view)
// 1
        val scenarioList = Scenario.getScenarioFromFile("scenarios.json", this)
        val adapter = ScenarioAdapter(this, scenarioList)
        listView.adapter = adapter

// 2
        // OK up
        val listItems = arrayOfNulls<String>(scenarioList.size)
// 3
        for (i in 0..scenarioList.size-1) {
            val scenario = scenarioList[i]
            Log.e("title", scenario.title.toString())
            listItems[i] = scenario.title.toString()
        }
// 4

    }
}
