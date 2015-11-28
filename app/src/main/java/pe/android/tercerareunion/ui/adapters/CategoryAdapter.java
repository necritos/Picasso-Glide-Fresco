package pe.android.tercerareunion.ui.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

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
        if(!url.isEmpty()){
            Uri uri = Uri.parse(url);
            holder.ivPreview.setImageURI(uri);
        }else {
            Uri uri = new Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                    .path(String.valueOf(R.drawable.error))
                    .build();

            holder.ivPreview.setImageURI(uri);
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

        SimpleDraweeView ivPreview;
        TextView tvName;


        public ViewHolder(View view) {
            super(view);

            ivPreview = (SimpleDraweeView)view.findViewById(R.id.iv_preview);
            tvName = (TextView)view.findViewById(R.id.tv_name);

        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
