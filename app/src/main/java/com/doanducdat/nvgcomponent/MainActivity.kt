package com.doanducdat.nvgcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //nav_host_fragment chứa 3 fragment nav_graph
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = navHostFragment.findNavController()
        //gắn nó vào bottomNvgView là xong -> ĐIỂU HƯỚNG
        btm_nvg_view.setupWithNavController(controller)

        //backbutton will be hided nếu đó là top level destination -> set up 3 fragment là top-level-destination
        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment,R.id.secondFragment, R.id.thirdFragment))
        //---
        toolbar_main.setupWithNavController(controller, appBarConfiguration) // -> HIỆN TÊN FRAGMENT KHI CHUYỂN ĐẾN FRAGMENT ĐÓ
        setSupportActionBar(toolbar_main)// -> CLICKABLE TRÊN MENU BAR
    }
    //add menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //xử lý click -> CLICK ĐIỂU HƯỚNG VÀ BTM_NVG_VIEW CŨNG NHẢY THEO
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(controller) || super.onOptionsItemSelected(item)
    }
}