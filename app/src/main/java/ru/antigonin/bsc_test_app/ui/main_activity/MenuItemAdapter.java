package ru.antigonin.bsc_test_app.ui.main_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ru.antigonin.bsc_test_app.R;
import ru.antigonin.bsc_test_app.databinding.ItemEurBinding;
import ru.antigonin.bsc_test_app.databinding.ItemRurBinding;
import ru.antigonin.bsc_test_app.databinding.ItemUsdBinding;
import ru.antigonin.bsc_test_app.model.models_info.Currency;


public class MenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<Currency> currencyList = new ArrayList<>();

    private final int VIEW_TYPE_RUR = 0;
    private final int VIEW_TYPE_USD = 1;
    private final int VIEW_TYPE_EUR = 2;


    @Override
    public int getItemViewType(int position) {
        if (currencyList.get(position).name == Currency.CurrencyName.RUR) {
            return VIEW_TYPE_RUR;
        } else if (currencyList.get(position).name == Currency.CurrencyName.EUR) {
            return VIEW_TYPE_USD;
        } else {
            return VIEW_TYPE_EUR;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == 0) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            ItemRurBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_rur, viewGroup, false);
            return new RURViewHolder(binding);

        } else if (viewType == 1) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            ItemUsdBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_usd, viewGroup, false);
            return new USDViewHolder(binding);

        } else {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            ItemEurBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_eur, viewGroup, false);
            return new EURViewHolder(binding);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Currency currency = currencyList.get(position);
        if(viewHolder instanceof RURViewHolder){

            RURViewHolder rurViewHolder = (RURViewHolder) viewHolder;
            rurViewHolder.bind(currency);

        }else if(viewHolder instanceof EURViewHolder){

            EURViewHolder eurViewHolder = (EURViewHolder) viewHolder;
            eurViewHolder.bind(currency);

        }else if(viewHolder instanceof USDViewHolder){

            USDViewHolder usdViewHolder = (USDViewHolder) viewHolder;
            usdViewHolder.bind(currency);

        }
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }

    public void setData(List<Currency> currencyList) {
        this.currencyList = currencyList;
        notifyDataSetChanged();
    }

    class RURViewHolder extends RecyclerView.ViewHolder {

         ItemRurBinding binding;

        public RURViewHolder(ItemRurBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Currency currency) {
            binding.currencyName.setText(currency.name.toString());
            binding.currencySum.setText(String.valueOf(currency.sum));
        }

    }

    class EURViewHolder extends RecyclerView.ViewHolder {

        ItemEurBinding binding;

        public EURViewHolder(ItemEurBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Currency currency) {
            Glide.with(binding.getRoot().getContext())
                    .load(currency.imageRes)
                    .into(binding.image);
            binding.currencyName.setText(currency.name.toString());
            binding.currencySum.setText(String.valueOf(currency.sum));

        }

    }

    class USDViewHolder extends RecyclerView.ViewHolder {

        ItemUsdBinding binding;

        public USDViewHolder(ItemUsdBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Currency currency) {
            Glide.with(binding.getRoot().getContext())
                    .load(currency.imageRes)
                    .into(binding.image);
            binding.currencyName.setText(currency.name.toString());
            binding.currencySum.setText(String.valueOf(currency.sum));
        }

    }
}

