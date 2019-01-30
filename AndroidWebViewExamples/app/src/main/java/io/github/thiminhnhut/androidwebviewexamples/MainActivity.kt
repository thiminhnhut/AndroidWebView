package io.github.thiminhnhut.androidwebviewexamples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.thiminhnhut.androidwebviewexamples.fragment.FragmentStart
import io.github.thiminhnhut.androidwebviewexamples.fragment.FragmentWebView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            fragmentStart()
        }
    }

    private fun fragmentStart() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.root_layout, FragmentStart.newInstance(object : FragmentStart.OnEvent {
            override fun onClick(sender: Any) {
                if (supportFragmentManager.findFragmentByTag("fragmentWebView") == null) {
                    fragmentWebView()
                } else {
                    supportFragmentManager.popBackStack("fragmentWebView", 0)
                }
            }
        }), "fragmentStart")
        fragmentTransaction.addToBackStack("fragmentStart")
        fragmentTransaction.commit()
    }

    private fun fragmentWebView() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.root_layout, FragmentWebView.newInstance(object : FragmentWebView.OnEvent {
            override fun onClick(sender: Any) {
                supportFragmentManager.popBackStack("fragmentStart", 0)
            }
        }), "fragmentWebView")
        fragmentTransaction.addToBackStack("fragmentWebView")
        fragmentTransaction.commit()
    }
}
