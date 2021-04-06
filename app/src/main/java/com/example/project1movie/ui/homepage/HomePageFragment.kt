package com.example.project1movie.ui.homepage

import android.view.View
import androidx.fragment.app.Fragment
import com.example.project1movie.R
import com.example.project1movie.base.BaseFragment
import com.example.project1movie.ui.favourite.FavouriteFragment
import com.example.project1movie.ui.genres.GenresFragment
import com.example.project1movie.ui.hot.HotFragment
import kotlinx.android.synthetic.main.fragment_home_page.*

class HomePageFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_home_page

    override fun onViewCreated(view: View) {
        onInitViewPager()
        onInitNav()
    }

    private fun onInitNav() {
        bottomNavHomePage.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.hotPage -> {
                    viewPagerHomePage.currentItem = 0
                    true
                }
                R.id.genresPage -> {
                    viewPagerHomePage.currentItem = 1
                    true
                }
                R.id.favoritePage -> {
                    viewPagerHomePage.currentItem = 2
                    true
                }
                else -> false
            }

        }
    }

    private fun onInitViewPager() {
        val listFragment = listOf<Fragment>(HotFragment(), GenresFragment(), FavouriteFragment())
        fragmentManager?.let {
            viewPagerHomePage.adapter = HomePageAdapter(it, listFragment)
        }
    }
}