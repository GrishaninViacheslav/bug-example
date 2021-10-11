package io.github.grishaninvyacheslav.bugexample

import com.github.terrakok.cicerone.androidx.FragmentScreen
import io.github.grishaninvyacheslav.bugexample.details.DetailsFragment
import io.github.grishaninvyacheslav.bugexample.master.MasterFragment

class Screens : IScreens {
    override fun main() = FragmentScreen { MasterFragment.newInstance() }
    override fun details() = FragmentScreen { DetailsFragment.newInstance() }
}