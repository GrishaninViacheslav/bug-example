package io.github.grishaninvyacheslav.bugexample.activity

import io.github.grishaninvyacheslav.bugexample.App
import io.github.grishaninvyacheslav.bugexample.IScreens
import io.github.grishaninvyacheslav.bugexample.Screens
import moxy.MvpPresenter

class MainPresenter: MvpPresenter<MainView>() {
    var router = App.instance.router

    var screens: IScreens = Screens()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.main())
    }

    fun backClicked() {
        router.exit()
    }
}