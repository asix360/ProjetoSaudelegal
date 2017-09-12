package com.example.info.ndexemple.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.info.ndexemple.Model.UnidadeModel
import com.example.info.ndexemple.NddrawActivity
import com.example.info.ndexemple.R
import kotlinx.android.synthetic.main.listunidade.view.*

class MyAdapter constructor(val context: Context, private val undades: ArrayList<UnidadeModel>?, private val clickListener:(UnidadeModel)->Unit) :
        RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        if (undades != null) {
            return undades.size
        }else {
            return 0
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        undades?.let {

            var unidade = undades[position]
            holder.itemView.tvunidade.text = unidade.unidadename
            holder.itemView.tvVotos.text = unidade.voto.toString()
            holder.itemView.setOnClickListener { clickListener(undades[position])}

        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.listunidade, parent, false)
        val vh = ViewHolder(v)
        return vh
    }





}