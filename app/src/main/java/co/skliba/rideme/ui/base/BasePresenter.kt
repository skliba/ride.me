package co.skliba.rideme.ui.base

abstract class BasePresenter<out T : BaseView>(protected val view: T) {

    abstract fun cancel()
}