package fr.meteordesign.personaapp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import fr.meteordesign.personaapp.R
import fr.meteordesign.personaapp.avatarStyle1
import fr.meteordesign.personaapp.messageStyle1
import fr.meteordesign.personaapp.model.Message
import fr.meteordesign.personaapp.ui.customcomponent.MessageView
import fr.meteordesign.personaapp.ui.customcomponent.setPersonaStyle

class ThreadListAdapter(context: Context, private val messages: List<Message>) : RecyclerView.Adapter<ThreadView>() {

    private val layoutInflater: LayoutInflater by lazy {
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getItemCount(): Int = messages.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ThreadView
            = ThreadView(layoutInflater.inflate(R.layout.thread_view, parent, false))

    override fun onBindViewHolder(holder: ThreadView?, position: Int) {
        holder?.bind(messages[position])
    }
}

class ThreadView(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contactAvatar: ImageView = itemView.findViewById(R.id.contact_avatar)
    private val lastMessage: MessageView = itemView.findViewById(R.id.last_message)

    fun bind(message: Message) {
        contactAvatar.setPersonaStyle(avatarStyle1)
        lastMessage.setPersonaStyle(messageStyle1)
        lastMessage.text = message.content
    }
}