package com.mindorks.example.coroutines.github.ui.repos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.example.coroutines.R
import com.mindorks.example.coroutines.github.data.model.Repo
import kotlinx.android.synthetic.main.item_repo_ui.view.*

class RepoListAdapter(private val repos: ArrayList<Repo>) :
    RecyclerView.Adapter<RepoListAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_repo_ui,
                    parent,
                    false
                )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    fun addData(list: List<Repo>) {
        repos.addAll(list)
        notifyDataSetChanged()
    }


    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(repo: Repo) {
            itemView.tv_repo_name.text = repo.name
            itemView.tv_repo_description.text = repo.description
        }
    }
}