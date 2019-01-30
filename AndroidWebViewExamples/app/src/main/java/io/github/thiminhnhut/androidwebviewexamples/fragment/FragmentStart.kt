package io.github.thiminhnhut.androidwebviewexamples.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import io.github.thiminhnhut.androidwebviewexamples.R

class FragmentStart : Fragment() {

    private lateinit var listener: OnEvent

    companion object {
        fun newInstance(listener: OnEvent): FragmentStart {
            val result = FragmentStart()
            result.listener = listener
            return result
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        val btnStart = view.findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            listener.onClick(this)
        }
        return view
    }

    interface OnEvent {
        fun onClick(sender: Any)
    }
}