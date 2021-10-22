package com.ammar.reqressapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ammar.reqressapp.R
import com.ammar.reqressapp.data.model.User
import com.ammar.reqressapp.databinding.ItemUserBinding
import com.ammar.reqressapp.view.home.HomeFragmentDirections
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)
    var dataUser: List<User>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = dataUser[position]

        holder.bind(dataUser[position])
        holder.itemView.setOnClickListener { mViews ->
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(user)
            mViews.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int = dataUser.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemUserBinding.bind(itemView)
        fun bind(user: User) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(ivUser)

                tvUserFirst.text = user.first_name
                tvUserLast.text = user.last_name
                tvEmail.text = user.email
            }
        }
    }

}