package fr.meteordesign.personaapp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import fr.meteordesign.personaapp.R

class ThreadListAdapter(context: Context) : RecyclerView.Adapter<ThreadView>() {

    private val layoutInflater: LayoutInflater by lazy {
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater }

    override fun getItemCount(): Int = 50

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ThreadView
            = ThreadView(layoutInflater.inflate(R.layout.thread_view, parent, false))

    override fun onBindViewHolder(holder: ThreadView?, position: Int) {
        holder?.bind(position)
    }
}

class ThreadView(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contactAvatar: ImageView = itemView.findViewById(R.id.contact_avatar)
    private val lastMessage: TextView = itemView.findViewById(R.id.last_message)

    fun bind(position: Int) {
        when (position % 4) {
            0 -> lastMessage.setText(R.string.text_sample_1)
            1 -> lastMessage.setText(R.string.text_sample_2)
            2 -> lastMessage.setText(R.string.text_sample_3)
            3 -> lastMessage.setText(R.string.text_sample_4)
        }
    }
}