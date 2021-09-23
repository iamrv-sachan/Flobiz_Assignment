package com.rajdroid.flobizassignment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rajdroid.flobizassignment.entity.Article
import kotlinx.android.synthetic.main.show_image.view.*
import kotlinx.android.synthetic.main.show_list.view.*
import java.util.*

class NewsAdapter(val list: ArrayList<Article>?, val clickListener: onitemClick) : RecyclerView.Adapter<NewsAdapter.viewholder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder1 {
        if (viewType==0)
        return viewholder1(LayoutInflater.from(parent.context).inflate(R.layout.show_list,parent,false))
        return viewholder1(LayoutInflater.from(parent.context).inflate(R.layout.show_image,parent,false))
    }

    override fun getItemCount(): Int {
        Log.i("info", "${list!!.size}")
        return list!!.size+1
    }

    override fun onBindViewHolder(holder: viewholder1, position: Int) {
        if(position==list!!.size) {
            holder.bind(null, position, clickListener)
        }
        else
        {
            holder.bind(list[position], position, clickListener)
        }
    }
    override fun getItemViewType(position: Int): Int {
        if (position == list!!.size) {
            return 1;
        }
        return 0;

    }

    interface onitemClick{
        fun onItemClicked(d: Int)
    }



var f=false
inner class viewholder1(private val itemBinding: View) : RecyclerView.ViewHolder(itemBinding){
    fun bind(data: Article?, position: Int, clickListener: NewsAdapter.onitemClick) {
        if (position==list!!.size){
            viewholder2(itemView)
        }else {
            if (data?.urlToImage != null) {
                Glide.with(itemBinding).load(data?.urlToImage)
                    .into(itemBinding.news_image)
            }

            itemBinding.news_source.text = data?.author
            itemBinding.news_text.text = data?.title
            itemBinding.show.setOnClickListener {
                clickListener.onItemClicked(position)
            }
        }
    }


}
    private fun viewholder2(itemView: View)  {

        itemView.cancel.setOnClickListener{
            f=true
            itemView.visibility=View.INVISIBLE

        }
        if (f){
            itemView.visibility=View.INVISIBLE
        }


    }
}



