package br.com.aiko.estagio.bussp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.aiko.estagio.bussp.data.remote.response.Linha
import br.com.aiko.estagio.bussp.databinding.ItemLinhaBinding

class LinhasAdapter : ListAdapter<Linha, LinhasAdapter.LinhasViewHolder>(LinhaDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinhasViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ItemLinhaBinding.inflate(view, parent, false)
        return LinhasViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LinhasViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class LinhasViewHolder(private val binding: ItemLinhaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(linha: Linha) {
            binding.tvLetreiro.text = "${linha.lt}-${linha.tl}"
            binding.tvTerminalPrincipal.text = linha.tp
            binding.tvTerminalSecundario.text = linha.ts
        }
    }
}

private class LinhaDiffCallBack : DiffUtil.ItemCallback<Linha>() {
    override fun areItemsTheSame(oldItem: Linha, newItem: Linha) = oldItem.cl == newItem.cl

    override fun areContentsTheSame(oldItem: Linha, newItem: Linha) = oldItem == newItem

}