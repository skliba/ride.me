package co.skliba.rideme.ui.dashboard.settings

import dagger.Binds
import dagger.Module

@Module
abstract class SettingsModule {

    @Binds
    abstract fun provideView(fragment: SettingsFragment): SettingsView
}