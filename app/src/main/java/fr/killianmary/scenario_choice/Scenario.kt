package fr.killianmary.scenario_choice

import android.content.Context
import org.json.JSONException
import org.json.JSONObject


class Scenario(
    val title: String?,
    val description: String,
    val picture: String) {

    companion object {

        fun getScenarioFromFile(filename: String, context: Context): ArrayList<Scenario> {
            val scenarioList = ArrayList<Scenario>()

            try {
                // Load data
                val jsonString = loadJsonFromAsset("scenarios.json", context)
                val json = JSONObject(jsonString)
                val scenarios = json.getJSONArray("scenarios")
                // Get Scenario objects from data
                (0 until scenarios.length()).mapTo(scenarioList) {
                    Scenario(
                        scenarios.getJSONObject(it).getString("title"),
                        scenarios.getJSONObject(it).getString("description"),
                        scenarios.getJSONObject(it).getString("picture"))
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return scenarioList
        }

        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String? = null

            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }
}