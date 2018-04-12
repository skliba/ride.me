package co.skliba.rideme.ui.dashboard.current_ride

import dagger.Binds
import dagger.Module

@Module
abstract class CurrentRideModule {

    @Binds
    abstract fun bindView(fragment: CurrentRideFragment): CurrentRideView
}