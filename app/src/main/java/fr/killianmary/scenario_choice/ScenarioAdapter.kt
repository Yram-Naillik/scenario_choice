package fr.killianmary.scenario_choice

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class ScenarioAdapter(private val context: Context,
                    private val dataSource: ArrayList<Scenario>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_scenario, parent, false)

        // Get title element
        val titleTextView = rowView.findViewById(R.id.scenario_list_title) as TextView

        // Get description element
        val descriptionTextView = rowView.findViewById(R.id.scenario_list_description) as TextView

        // Get picture element
        //val pictureTextView = rowView.findViewById(R.id.imageView) as ImageView

        // 1
        val scenario = getItem(position) as Scenario

        // 2

        titleTextView.text = scenario.title
        descriptionTextView.text = scenario.description

        //val picture = scenario.picture




        //pictureTextView.setImageResource()

        // 3
        return rowView
    }

}
