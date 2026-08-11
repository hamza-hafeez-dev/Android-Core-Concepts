package pk.org.cas.recycleviewf24;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProdcutViewHolder> {
    private List<Product> products;
    private OnItemClickListener onItemClickListener;
    private OnItemImageClickListener onItemImageClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemImageClickListener(OnItemImageClickListener onItemImageClickListener) {
        this.onItemImageClickListener = onItemImageClickListener;
    }

    public ProductAdapter(List<Product> products){
        this.products =products;
    }
    @NonNull
    @Override
    public ProdcutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row_view, null);;
//        if (viewType == 0) {
//            itemView =
LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row_view, null);
//        }else {
//            itemView =
LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row_view_reverse, null);
//        }
        return new ProdcutViewHolder(itemView);
    }

//    @Override
//    public int getItemViewType(int position) {
//        return position%2;
//    }

    @Override
    public void onBindViewHolder(@NonNull ProdcutViewHolder holder, int position) {
      var product = products.get(position);
      holder.ivProducts.setImageResource(product.getImageResourceId());
      holder.tvTitle.setText(product.getTitle());
      holder.tvPrice.setText(Double.toString(product.getPrice()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProdcutViewHolder extends RecyclerView.ViewHolder{
        ImageView ivProducts;
        TextView tvTitle,tvPrice;

        public ProdcutViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProducts = itemView.findViewById(R.id.ivProduct);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);

            ivProducts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemImageClickListener != null){
                        int position = getAbsoluteAdapterPosition();
                        onItemImageClickListener.onItemImageClick(ivProducts,position);
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null){
                        int position = getAbsoluteAdapterPosition();
                        onItemClickListener.onItemClick(position);
                    }
                }
            });
        }
    }

    interface OnItemClickListener{
        void onItemClick(int position);
    }

    interface OnItemImageClickListener{
        void onItemImageClick(ImageView imageView,int position);
    }
}
