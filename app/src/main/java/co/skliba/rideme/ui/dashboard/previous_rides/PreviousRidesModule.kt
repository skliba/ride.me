package co.skliba.rideme.ui.dashboard.previous_rides

import dagger.Binds
import dagger.Module

@Module
abstract class PreviousRidesModule {

    @Binds
    abstract fun provideView(fragment: PreviousRidesFragment): PreviousRidesView
}