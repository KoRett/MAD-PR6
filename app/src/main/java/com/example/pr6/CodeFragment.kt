package com.example.pr6

import android.graphics.drawable.Drawable
import android.icu.util.Calendar
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import java.io.IOException


class CodeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val constraintLayout = ConstraintLayout(requireContext())
        val margin20dp =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20F, resources.displayMetrics)
                .toInt()

        val dp230 =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 230F, resources.displayMetrics)
                .toInt()

        val firstText = TextView(context)
        firstText.id = View.generateViewId()
        val string = resources.getString(R.string.some_text)
        firstText.text = string
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.setMargins(0, margin20dp, 0, 0)
        firstText.layoutParams = layoutParams

        val userName = "Rostislav"
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val secondText = TextView(context)
        secondText.id = View.generateViewId()
        secondText.text = getString(R.string.welcome, userName, hour, minute)
        val layoutParams1 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams1.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams1.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams1.topToBottom = firstText.id
        layoutParams1.setMargins(0, margin20dp, 0, 0)
        secondText.layoutParams = layoutParams1

        val rose = resources.getQuantityString(R.plurals.flowers, 21, 21)
        val thirdText = TextView(context)
        thirdText.id = View.generateViewId()
        thirdText.text = rose
        val layoutParams2 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams2.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams2.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams2.topToBottom = secondText.id
        layoutParams2.setMargins(0, margin20dp, 0, 0)
        thirdText.layoutParams = layoutParams2

        val di = resources.getStringArray(R.array.di)
        var allLanguages = ""
        for (lang in di)
            allLanguages += "$lang "
        val fourthText = TextView(context)
        fourthText.id = View.generateViewId()
        fourthText.text = allLanguages
        val layoutParams3 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams3.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams3.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams3.topToBottom = thirdText.id
        layoutParams3.setMargins(0, margin20dp, 0, 0)
        fourthText.layoutParams = layoutParams3

        val fifthText = TextView(context)
        fifthText.id = View.generateViewId()
        fifthText.text = "Dimension"
        fifthText.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_size))
        fifthText.setBackgroundColor(resources.getColor(R.color.teal_200))
        val layoutParams4 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams4.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams4.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams4.topToBottom = fourthText.id
        layoutParams4.setMargins(0, resources.getDimension(R.dimen.vertical_margin).toInt(), 0, 0)
        fifthText.layoutParams = layoutParams4

        val image = ImageView(context)
        image.id = View.generateViewId()
        image.setImageDrawable(resources.getDrawable(R.drawable.kotik))
        val layoutParams5 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            dp230
        )
        layoutParams5.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams5.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams5.topToBottom = fifthText.id
        layoutParams5.setMargins(0, resources.getDimension(R.dimen.vertical_margin).toInt(), 0, 0)
        image.layoutParams = layoutParams5

        val imageView = ImageView(context)
        imageView.id = View.generateViewId()
        val layoutParams6 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams6.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams6.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams6.topToBottom = image.id
        layoutParams6.setMargins(0, resources.getDimension(R.dimen.vertical_margin).toInt(), 0, 0)
        imageView.layoutParams = layoutParams6

        val filename = "cat_with.jpg"
        try {
            val ims = context?.assets?.open(filename)
            val drawable = Drawable.createFromStream(ims, null)
            imageView.setImageDrawable(drawable)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        constraintLayout.addView(firstText)
        constraintLayout.addView(secondText)
        constraintLayout.addView(thirdText)
        constraintLayout.addView(fourthText)
        constraintLayout.addView(fifthText)
        constraintLayout.addView(image)
        constraintLayout.addView(imageView)
        return constraintLayout
    }
}