package com.akka.wiseup

import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController


class CourseOverviewFragment : Fragment() {
    private lateinit var videoView: VideoView
    private lateinit var backButton: ImageView
    private lateinit var textRangkuman: TextView
    private lateinit var textModul: TextView
    private var selectedTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_course_overview, container, false)

        // Initialize views
        textRangkuman = rootView.findViewById(R.id.text_rangkuman)
        textModul = rootView.findViewById(R.id.text_modul)

        textRangkuman.setOnClickListener {
            handleTextViewClick(textRangkuman)
            // Handle fragment transaction here
            val rangkumanFragment = RangkumanFragment()
            val transactionFragmentRangkuman = childFragmentManager.beginTransaction()
            transactionFragmentRangkuman.replace(R.id.fragmentContainer, rangkumanFragment)
            transactionFragmentRangkuman.commit()
        }

        textModul.setOnClickListener {
            handleTextViewClick(textModul)
            // Handle fragment transaction here
            val modulFragment = ModulFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, modulFragment)
            transaction.commit()
        }

        // untuk klik back
        backButton = rootView.findViewById(R.id.backButtonCourseOverview)
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return rootView
    }

    // automatically opened "Rangkuman" page.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleTextViewClick(textRangkuman)

        val rangkumanFragment = RangkumanFragment()
        val transactionFragmentRangkuman = childFragmentManager.beginTransaction()
        transactionFragmentRangkuman.replace(R.id.fragmentContainer, rangkumanFragment)
        transactionFragmentRangkuman.commit()
    }

    private fun handleTextViewClick(textView: TextView) {
        selectedTextView?.let {
            // Reset the color and style of the previously selected text view
            it.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.black))
            it.paintFlags = it.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
        }

        // Update the color and style of the clicked text view
        textView.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_purple))
        textView.paintFlags = textView.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        selectedTextView = textView
    }
}