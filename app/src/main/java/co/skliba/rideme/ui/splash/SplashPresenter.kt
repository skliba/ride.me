package co.skliba.rideme.ui.splash

import co.skliba.rideme.ui.base.BasePresenter
import javax.inject.Inject

class SplashPresenter @Inject constructor(
    view: SplashView
) : BasePresenter<SplashView>(view) {

    fun onAnimationEnd() {
        view.navigateToDashboard()
    }

    override fun cancel() {
    }
}