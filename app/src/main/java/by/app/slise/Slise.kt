package by.app.slise


import android.app.Application
import by.app.slise.di.AppComponent

class Slise : Application() {

    val myComponent: AppComponent by lazy { AppComponent(this) }
}