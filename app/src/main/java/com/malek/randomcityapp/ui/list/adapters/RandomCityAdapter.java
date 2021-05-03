package com.malek.randomcityapp.ui.list.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.malek.domain.models.RandomCity;
import com.malek.randomcityapp.databinding.CityListItemBinding;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public class RandomCityAdapter extends ListAdapter<RandomCity, RandomCityAdapter.RandomCityViewHolder> {

    private final Function1<RandomCity, Unit> onItemClick;

    public RandomCityAdapter(@NonNull Function1<RandomCity, Unit> onItemClick) {
        super(new RandomCityDiffCallback());
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public RandomCityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CityListItemBinding binding = CityListItemBinding.inflate(inflater, parent, false);
        return new RandomCityViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomCityViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class RandomCityViewHolder extends RecyclerView.ViewHolder {

        private final CityListItemBinding binding;

        public RandomCityViewHolder(@NonNull CityListItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(RandomCity randomCity) {
            binding.setCity(randomCity);
            binding.getRoot().setOnClickListener(view -> {
                onItemClick.invoke(randomCity);
            });

            binding.executePendingBindings();
        }
    }

    static class RandomCityDiffCallback extends DiffUtil.ItemCallback<RandomCity> {

        @Override
        public boolean areItemsTheSame(@NonNull RandomCity oldItem, @NonNull RandomCity newItem) {
            return oldItem.getDbId() == newItem.getDbId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull RandomCity oldItem, @NonNull RandomCity newItem) {
            return oldItem.equals(newItem);
        }
    }

}
