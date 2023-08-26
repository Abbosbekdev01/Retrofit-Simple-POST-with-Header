package uz.abbosbek.retrofitcustomrequestheaders.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.abbosbek.retrofitcustomrequestheaders.databinding.ItemRvBinding
import uz.abbosbek.retrofitcustomrequestheaders.models.Post


class RvAdapter(var list: ArrayList<Post> = ArrayList()) :
    RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {

        fun onBind(post: Post) {
//            itemRvBinding.userIdTxt.text = post.userId.toString()
//            itemRvBinding.idTxt.text = post.id.toString()
            itemRvBinding.titleTxt.text = post.title
//            itemRvBinding.bodyTxt.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<Post>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}