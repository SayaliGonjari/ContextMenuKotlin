package com.project.contextmenukotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(btnContextMenu)
        btnContextMenu.setOnLongClickListener {
            openContextMenu(btnContextMenu)
            true
        }

    }


    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Context Menu")
        menu?.add(0, v?.id!!, 0, "Call")
        menu?.add(1, v?.id!!, 1, "SMS")
        menu?.add(2, v?.id!!, 2, "Search")
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {

        when {
            item?.title == "Call" -> {
                Toast.makeText(this, "You Clicked on Call", Toast.LENGTH_SHORT).show()
                return true
            }
            item?.title == "SMS" -> {
                Toast.makeText(this, "You Clicked on SMS", Toast.LENGTH_SHORT).show()
                return true
            }
            item?.title == "Search" -> {
                Toast.makeText(this, "You Clicked on Search", Toast.LENGTH_SHORT).show()
                return true
            }
            else ->  return super.onContextItemSelected(item)

        }

    }

}