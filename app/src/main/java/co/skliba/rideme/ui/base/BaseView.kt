package co.skliba.rideme.ui.base

interface BaseView {
    fun showProgress()
    fun hideProgress()
    fun showError(text: String)
}