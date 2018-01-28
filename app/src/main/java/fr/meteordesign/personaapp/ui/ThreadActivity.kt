package fr.meteordesign.personaapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import fr.meteordesign.personaapp.PersonaApplication
import fr.meteordesign.personaapp.R
import fr.meteordesign.personaapp.model.Message
import fr.meteordesign.personaapp.ui.adapter.ThreadListAdapter
import javax.inject.Inject

class ThreadActivity: AppCompatActivity() {

    @Inject
    lateinit var messages: List<Message>

    private val threadList by lazy { findViewById<RecyclerView>(R.id.thread_list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PersonaApplication.dagger.inject(this)

        setContentView(R.layout.activity_thread)
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
        threadList.adapter = ThreadListAdapter(this, messages)
    }
}