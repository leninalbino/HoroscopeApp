package com.dev.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.horoscapp.databinding.ItemHoroscopeBinding
import com.dev.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    // Binding the view holder to the item_horoscope layout
    private val binding = ItemHoroscopeBinding.bind(view)

    // This function is used to bind the data to the view holder
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.constraintLayoutItemHoroscope.setOnClickListener {
            //onItemSelected(horoscopeInfo)
            // This function is used to start the rotation animation
            startRotationAnimation(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)})
        }
    }

    private fun startRotationAnimation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            // This function is used to start the new lambda function after the animation ends
            withEndAction {
                newLambda()
            }
            start()
        }
    }
}