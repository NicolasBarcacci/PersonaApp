package fr.meteordesign.personaapp.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import fr.meteordesign.personaapp.R

class ThreadListAdapter(context: Context): RecyclerView.Adapter<ThreadView>() {

    private val layoutInflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItemCount(): Int = 50

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ThreadView
            = ThreadView(layoutInflater.inflate(R.layout.thread_view, parent, false))

    override fun onBindViewHolder(holder: ThreadView?, position: Int) {}
}

class ThreadView(itemView: View): RecyclerView.ViewHolder(itemView) {
    val contactAvatar: ImageView = itemView.findViewById(R.id.contact_avatar)
    val lastMessage: TextView = itemView.findViewById(R.id.last_message)
}