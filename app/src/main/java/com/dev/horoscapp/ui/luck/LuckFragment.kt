package com.dev.horoscapp.ui.luck

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import com.dev.horoscapp.R
import com.dev.horoscapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random

@AndroidEntryPoint
class LuckFragment : Fragment() {

    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUX()
    }

    private fun initUX() {
        initListener()
    }

    private fun initListener() {
        binding.ivRoulette.setOnClickListener { spinRoulette() }
    }

    private fun spinRoulette() {
        val random = Random()
        val degrees = random.nextInt(1440) + 360

        val animator =
            ObjectAnimator.ofFloat(binding.ivRoulette, View.ROTATION, 0f, degrees.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()
    }

    private fun slideCard() {
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)

        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                binding.ivReverse.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })

        binding.ivReverse.startAnimation(slideUpAnimation)
    }

    private fun growCard(){
        val growAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.grow)

        growAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

        binding.ivReverse.startAnimation(growAnimation)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLuckBinding.inflate(inflater, container, false)
        return binding.root
    }

}