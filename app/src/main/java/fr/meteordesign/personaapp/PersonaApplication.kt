package fr.meteordesign.personaapp

import android.app.Application

class PersonaApplication : Application() {

    companion object {
        lateinit var dagger: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        dagger = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}