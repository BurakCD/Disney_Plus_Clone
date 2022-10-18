package com.ethadien.disney.UI

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.ethadien.disney.R
import com.ethadien.disney.RecyclerAdapter
import com.ethadien.disney.SliderAdapter
import com.ethadien.disney.databinding.FragmentHomeBinding
import kotlin.math.abs

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private lateinit var handler : Handler
    var PagerImages = ArrayList<Int>()
    var specialForYouList = ArrayList<Int>()
    var newContentList = ArrayList<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        init()

        setUpTransformer()

        binding.imageSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 4000)
            }
        })

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 4000)
    }

    private val runnable = Runnable{
        binding.imageSlider.currentItem +=1
        if(binding.imageSlider.currentItem == PagerImages.size){
            binding.imageSlider.currentItem -= PagerImages.size
        }
    }

    private fun setUpTransformer(){
        var compositePT = CompositePageTransformer()
        compositePT.addTransformer(MarginPageTransformer(0))
        compositePT.addTransformer { page, position ->
            val r = 1- abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }
        binding.imageSlider.setPageTransformer(compositePT)
    }

    private fun init(){
        handler = Handler(Looper.myLooper()!!)

        PagerImages.add(R.drawable.the_old_man)
        PagerImages.add(R.drawable.rosaline)
        PagerImages.add(R.drawable.madness)
        PagerImages.add(R.drawable.acimasiz)
        PagerImages.add(R.drawable.eglence_spin)

        newContentList.add(R.drawable.andor)
        newContentList.add(R.drawable.she_hulk)
        newContentList.add(R.drawable.d_b_aramda)
        newContentList.add(R.drawable.dr_strange)
        newContentList.add(R.drawable.werewolf_by_night)
        newContentList.add(R.drawable.daredevil)
        newContentList.add(R.drawable.simpsons)
        newContentList.add(R.drawable.futurama)

        specialForYouList.add(R.drawable.werewolf_by_night)
        specialForYouList.add(R.drawable.daredevil)
        specialForYouList.add(R.drawable.simpsons)
        specialForYouList.add(R.drawable.futurama)
        specialForYouList.add(R.drawable.andor)
        specialForYouList.add(R.drawable.she_hulk)
        specialForYouList.add(R.drawable.d_b_aramda)
        specialForYouList.add(R.drawable.dr_strange)

        binding.newContentRW.adapter = RecyclerAdapter(requireContext(), newContentList)

        binding.specialForYouRW.adapter = RecyclerAdapter(requireContext(), specialForYouList)

        binding.imageSlider.adapter = SliderAdapter(requireContext(), PagerImages)
        binding.imageSlider.clipToPadding = false
        binding.imageSlider.clipChildren = false
        binding.imageSlider.offscreenPageLimit = 3
        binding.imageSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER



    }

}