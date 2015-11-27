package pe.android.tercerareunion.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.android.tercerareunion.R;
import pe.android.tercerareunion.model.CategoryEntity;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>  {

    private List<CategoryEntity> categoryEntityList;
    private Context context;

    public CategoryAdapter(Context context, List<CategoryEntity> categoryEntityList) {
        this.context=context;
        this.categoryEntityList = categoryEntityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final CategoryEntity categoryEntity= categoryEntityList.get(position);

        holder.tvName.setText(categoryEntity.getName());
        String url= categoryEntity.getImage();
        if (url.isEmpty()){
            Picasso.with(context)
                    .load(R.drawable.error)
                    .placeholder(R.drawable.placeholder)
                    .into(holder.ivPreview);
        }else {
            Picasso.with(context)
                    .load(url)
                    .error(R.drawable.error)
                    .placeholder(R.drawable.placeholder)
                    .into(holder.ivPreview);
        }



    }

    @Override
    public int getItemCount() {
        return categoryEntityList.size();
    }

    public void clear()
    {
        categoryEntityList.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPreview;
        TextView tvName;


        public ViewHolder(View view) {
            super(view);

            ivPreview = (ImageView)view.findViewById(R.id.iv_preview);
            tvName = (TextView)view.findViewById(R.id.tv_name);

        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
