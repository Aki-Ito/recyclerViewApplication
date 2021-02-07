package app.ito.akki.recyclerviewapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (private val context: Context) :RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    val items: MutableList<CourseData> = mutableListOf()
    //ViewHolderは複数のViewを保持するクラスのことを指し、Adapterを使う際に必要
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val charaImage: ImageView = view.findViewById(R.id.characterImageView)
        val charaNameTextView: TextView = view.findViewById(R.id.courseNameTextView)
        val charaDetailTextView: TextView = view.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_course_data_cell,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        //リストの要素数を返すメソッドを実装する
        return items.size
    }

    //onBindViewHolderの中にitemsのposition番目の要素をViewHolderに表示するコードを書く。
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.charaImage.setImageResource(item.characterImageResource)
        holder.charaNameTextView.text = item.courseName
        holder.charaDetailTextView.text = item.description
    }

    //Adapterにデータを登録するためのaddAllメソッド
    //これを使うとRecyclerViewにデータが表示される
    fun addAll(items: List<CourseData>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}