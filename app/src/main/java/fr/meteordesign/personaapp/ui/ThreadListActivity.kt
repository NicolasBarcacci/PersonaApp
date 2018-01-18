package fr.meteordesign.personaapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import fr.meteordesign.personaapp.R

class ThreadListActivity : AppCompatActivity() {

    private val threadList by lazy { findViewById<RecyclerView>(R.id.thread_list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_list)

        setSupportActionBar(findViewById(R.id.toolbar))
        initThreadList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.thread_list_menu, menu)
        return true
    }

    private fun initThreadList() {
        threadList.layoutManager = LinearLayoutManager(this)
        threadList.setHasFixedSize(true)
        threadList.adapter = ThreadListAdapter(this)
    }
}
