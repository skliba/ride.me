package co.skliba.rideme.di

import android.content.Context
import co.skliba.rideme.RideMeApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    ProvidersModule::class,
    ActivityBuilder::class,
    FragmentBuilder::class
))
interface AppComponent {

    fun context(): Context

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: RideMeApp)
}
