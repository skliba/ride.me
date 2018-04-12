package co.skliba.rideme.ui.dashboard

import dagger.Binds
import dagger.Module

@Module
abstract class DashboardModule {

    @Binds
    abstract fun provideView(activity: DashboardActivity): DashboardView
}