package com.example.android.videogameproject.ui.main


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.videogameproject.databinding.ListItemVideoGameBinding
import com.example.android.videogameproject.network.data.Results

class MainAdapter: ListAdapter<Results, MainAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private var binding: ListItemVideoGameBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(videoGame: Results) {
                    binding.videoGame = videoGame
                    binding.executePendingBindings()

                    binding.listVideoGameBackground.setOnClickListener { v: View ->
                        v.findNavController().navigate(
                            MainFragmentDirections.actionMainFragmentToVideoGameInfoFragment(
                                videoGame = videoGame
                            )
                        )
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemVideoGameBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val videoGameFeed = getItem(position)
        holder.bind(videoGameFeed)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
