package fr.meteordesign.personaapp

import android.app.Application
import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import fr.meteordesign.personaapp.model.Message
import fr.meteordesign.personaapp.ui.ThreadListActivity
import java.util.*
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    fun provideApplication(): Application = application
}

@Module
class MockMessageModule {

    @Provides
    @Singleton
    fun providesMessages(application: Application): List<Message> {
        val messages = ArrayList<Message>()
        for (i in 0..50) {
            messages.add(Message(generateRandomMessageContent(application)))
        }

        return messages
    }

    private fun generateRandomMessageContent(context: Context): String {
        val resId = when (Random().nextInt(4)) {
            0 -> R.string.text_sample_1
            1 -> R.string.text_sample_2
            2 -> R.string.text_sample_3
            else -> R.string.text_sample_4
        }

        return context.getText(resId).toString()
    }
}

@Singleton
@Component(modules = [AppModule::class, MockMessageModule::class])
interface AppComponent {
    fun inject(threadListActivity: ThreadListActivity)
}