// Generated by view binder compiler. Do not edit!
package com.example.test2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RecomendItem1Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView ivItem2Logo;

  @NonNull
  public final ImageView ivItemLogo;

  @NonNull
  public final TextView tvItem2Name;

  @NonNull
  public final TextView tvItem2Price;

  @NonNull
  public final TextView tvItemName;

  @NonNull
  public final TextView tvItemPrice;

  private RecomendItem1Binding(@NonNull LinearLayout rootView, @NonNull ImageView ivItem2Logo,
      @NonNull ImageView ivItemLogo, @NonNull TextView tvItem2Name, @NonNull TextView tvItem2Price,
      @NonNull TextView tvItemName, @NonNull TextView tvItemPrice) {
    this.rootView = rootView;
    this.ivItem2Logo = ivItem2Logo;
    this.ivItemLogo = ivItemLogo;
    this.tvItem2Name = tvItem2Name;
    this.tvItem2Price = tvItem2Price;
    this.tvItemName = tvItemName;
    this.tvItemPrice = tvItemPrice;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RecomendItem1Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RecomendItem1Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.recomend_item1, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RecomendItem1Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_item2_logo;
      ImageView ivItem2Logo = ViewBindings.findChildViewById(rootView, id);
      if (ivItem2Logo == null) {
        break missingId;
      }

      id = R.id.iv_item_logo;
      ImageView ivItemLogo = ViewBindings.findChildViewById(rootView, id);
      if (ivItemLogo == null) {
        break missingId;
      }

      id = R.id.tv_item2_name;
      TextView tvItem2Name = ViewBindings.findChildViewById(rootView, id);
      if (tvItem2Name == null) {
        break missingId;
      }

      id = R.id.tv_item2_price;
      TextView tvItem2Price = ViewBindings.findChildViewById(rootView, id);
      if (tvItem2Price == null) {
        break missingId;
      }

      id = R.id.tv_item_name;
      TextView tvItemName = ViewBindings.findChildViewById(rootView, id);
      if (tvItemName == null) {
        break missingId;
      }

      id = R.id.tv_item_price;
      TextView tvItemPrice = ViewBindings.findChildViewById(rootView, id);
      if (tvItemPrice == null) {
        break missingId;
      }

      return new RecomendItem1Binding((LinearLayout) rootView, ivItem2Logo, ivItemLogo, tvItem2Name,
          tvItem2Price, tvItemName, tvItemPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
