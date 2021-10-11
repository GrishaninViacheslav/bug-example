package io.github.grishaninvyacheslav.bugexample.master

import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.bugexample.App
import io.github.grishaninvyacheslav.bugexample.IScreens
import io.github.grishaninvyacheslav.bugexample.Screens
import moxy.MvpPresenter

class MasterPresenter(
    private val router: Router = App.instance.router,
    private var screens: IScreens = Screens()
) : MvpPresenter<MasterView>() {
    private var counter = 0

    fun incrementCounter() {
        counter++
        viewState.showCount(counter)
    }

    fun openDetails() {
        router.navigateTo(screens.details())
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}