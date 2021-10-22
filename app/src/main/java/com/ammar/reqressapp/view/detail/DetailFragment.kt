package com.ammar.reqressapp.view.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.ammar.reqressapp.R
import com.ammar.reqressapp.data.model.User
import com.ammar.reqressapp.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    @FragmentScoped
    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args : DetailFragmentArgs by navArgs()
    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = args.user
        populateUI()
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun populateUI() {
        binding.apply {
            tvFirstName.text = user.first_name
            tvLastName.text = user.last_name
            tvEmailDetail.text = user.email

            Glide.with(this@DetailFragment)
                .load(user.avatar)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(ivProductDetail)
        }
    }
}